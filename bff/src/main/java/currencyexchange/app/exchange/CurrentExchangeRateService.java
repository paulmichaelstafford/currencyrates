package currencyexchange.app.exchange;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrentExchangeRateService {
    private final Map<Currency, Float> rates = new HashMap<>();
    public void updateRates(Map<Currency, Float> dailyRates) {
        rates.clear();
        rates.put(Currency.EUR, 1f);
        rates.putAll(dailyRates);
    }

    public Map<Currency, Float> getRates() {
        return rates;
    }

    public Float getRate(Currency currency) {
        return rates.get(currency);
    }
}
