package currencyexchange.app.exchange;


import currencyexchange.app.exchange.proxy.ExchangeRateProxy;
import jakarta.annotation.PostConstruct;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CurrencyScheduler {

    private final ExchangeRateProxy exchangeRateProxy;
    private final CurrentExchangeRateService currentExchangeRateService;

    public CurrencyScheduler(ExchangeRateProxy exchangeRateProxy, CurrentExchangeRateService currentExchangeRateService) {
        this.exchangeRateProxy = exchangeRateProxy;
        this.currentExchangeRateService = currentExchangeRateService;
    }


//    @Scheduled(cron = "* * * * * *")
    @PostConstruct
    public void getDailyRates() throws IOException, ZipException {
        exchangeRateProxy.getDailyRates();
    }
}
