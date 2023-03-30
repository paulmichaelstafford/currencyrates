package currencyexchange.app.exchange;


import currencyexchange.app.exchange.proxy.ExchangeRateProxy;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Map;

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
    public void getDailyRates() {
        Map<Currency, Float> dailyRates = exchangeRateProxy.getDailyRates();
        currentExchangeRateService.updateRates(dailyRates);
    }
}
