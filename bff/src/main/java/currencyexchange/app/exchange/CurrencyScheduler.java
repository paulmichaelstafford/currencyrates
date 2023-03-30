package currencyexchange.app.exchange;


import currencyexchange.app.exchange.proxy.ExchangeRateProxy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CurrencyScheduler {

    private final ExchangeRateProxy exchangeRateProxy;
    private final CurrentExchangeRateService currentExchangeRateService;

    public CurrencyScheduler(ExchangeRateProxy exchangeRateProxy, CurrentExchangeRateService currentExchangeRateService) {
        this.exchangeRateProxy = exchangeRateProxy;
        this.currentExchangeRateService = currentExchangeRateService;
    }


    @Scheduled(cron = "* * 0 * * *")
    public void getDailyRates() {

    }
}
