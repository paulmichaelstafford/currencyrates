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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeRateProxy {

//    private final WebClient webClient;

//    private final WebClient webClient;

    private final String urlEndPoint = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref.zip";

    public Map<Currency, Float> getDailyRates() {
        return new HashMap<>();
    }

    private Mono<byte[]> get() throws IOException {
        Path path = Files.createTempFile("hello", ".file");
        WebClient client = WebClient.builder()
                .baseUrl(urlEndPoint)
                .build();
        Flux<DataBuffer> dataBufferFlux = client.get().retrieve().bodyToFlux(DataBuffer.class);
        DataBufferUtils.write(dataBufferFlux, path, StandardOpenOption.CREATE);


        return null;
    }
}
