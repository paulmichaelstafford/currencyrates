package currencyexchange.app.exchange;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrentExchangeRateService {
    private final Map<Currency, Float> rates = new HashMap<>();
    public void updateRates(Map<Currency, Float> dailyRates) {
        for (Map.Entry<Currency, Float> dailyRate : dailyRates.entrySet()){
            rates.putIfAbsent(dailyRate.getKey(), dailyRate.getValue());
            if(rates.get(dailyRate.getKey()) < dailyRate.getValue()) {
                rates.put(dailyRate.getKey(), dailyRate.getValue());
            }
        }
        System.out.println(rates);
    }
    public Float getRate(Currency currency) {
        return rates.get(currency);
    }
}
