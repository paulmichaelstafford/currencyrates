package currencyexchange.app.exchange;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    public Float getRate(Currency fromCurrency, Currency toCurrency, Float value) {
        return Double.valueOf(Math.round(( rates.get(fromCurrency) / rates.get(toCurrency) * value) *100.0)/100.0).floatValue();
    }
}
