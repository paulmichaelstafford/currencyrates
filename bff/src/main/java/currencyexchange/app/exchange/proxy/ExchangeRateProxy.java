package currencyexchange.app.exchange.proxy;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import currencyexchange.app.exchange.Currency;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.core.ZipFile;

@Service
public class ExchangeRateProxy {
    private final String fileName = "eurofxref";

    public Map<Currency, Float> getDailyRates() {
        try {
            Path zipPath = downloadZipFile();
            File zipFile = extractZipFile(zipPath);
            return readRatesFromFile(zipFile);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Problem getting/extracting daily rates %s", e.getMessage()));
        }
    }

    private Path downloadZipFile() throws IOException {
        Path path = Files.createTempFile(fileName, ".zip");
        String urlEndPoint = "https://www.ecb.europa.eu/stats/eurofxref/" + fileName + ".zip";
        try (BufferedInputStream in = new BufferedInputStream(new URL(urlEndPoint).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(path.toUri().getPath())) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }
        return path;
    }

    private File extractZipFile(Path tmpZipFile) throws IOException, ZipException {
        File tmpdir = Files.createTempDirectory("tmpDailyRateDirPrefix").toFile();
        ZipFile zipFile = new ZipFile(tmpZipFile.toUri().getPath());
        zipFile.extractAll(tmpdir.getAbsolutePath());
        return tmpdir;
    }

    private Map<Currency, Float> readRatesFromFile(File zipFile) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<Currency, Float> dailyCurrency = new HashMap<>();

        try (
                Reader reader = Files.newBufferedReader(Paths.get(zipFile.getAbsolutePath() + "/" + fileName + ".csv"));
        ) {
            CsvToBean<Eurofxref> csvToBean = new CsvToBeanBuilder<Eurofxref>(reader)
                    .withType(Eurofxref.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<Eurofxref> csvUserIterator = csvToBean.iterator();
            Eurofxref csvUser = csvUserIterator.next();

            List<Field> fields = List.of(Eurofxref.class.getDeclaredFields());
            for(Field f : fields) {
                if(!f.getName().equals("date")) {
                    Method method = Eurofxref.class.getDeclaredMethod("get"+f.getName());
                    Currency currency = Currency.valueOf(f.getName());
                    Float rate = (Float) method.invoke(csvUser);
                    dailyCurrency.put(currency, rate);
                }
            }
        }

        return dailyCurrency;
    }
}
