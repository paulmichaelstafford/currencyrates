package currencyexchange.app.exchange.proxy;

import currencyexchange.app.exchange.Currency;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
//import java.util.zip.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.core.ZipFile;

@Service
public class ExchangeRateProxy {
    private final String fileName = "eurofxref";
    private final String urlEndPoint = "https://www.ecb.europa.eu/stats/eurofxref/"+fileName+".zip";
    public Map<Currency, Float> getDailyRates() throws IOException, ZipException {
        return get();
    }

    private Map<Currency, Float> get() throws IOException, ZipException {
        Path path = Files.createTempFile("dailyRate", ".zip");
//        WebClient client = WebClient.builder()
//                .baseUrl(urlEndPoint)
//                .build();
//        Flux<DataBuffer> dataBufferFlux = client.get().retrieve().bodyToFlux(DataBuffer.class);
//        DataBufferUtils.write(dataBufferFlux, path, StandardOpenOption.CREATE);


        try (BufferedInputStream in = new BufferedInputStream(new URL(urlEndPoint).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(path.toUri().getPath())) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }
//        } catch (IOException e) {
//            // handle exception
//        }

        String tmpdir = Files.createTempDirectory("tmpDailyRateDirPrefix").toFile().getAbsolutePath();
        ZipFile zipFile = new ZipFile(path.toUri().getPath());
        zipFile.extractAll(tmpdir);

//        zipFile.extractAll(destination);


        return null;
    }
}
