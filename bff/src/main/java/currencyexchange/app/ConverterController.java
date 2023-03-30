package currencyexchange.app;

import currencyexchange.app.exchange.Currency;
import currencyexchange.app.exchange.CurrentExchangeRateService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/currencies")
public class ConverterController {

    private final CurrentExchangeRateService currentExchangeRateService;

    public ConverterController(CurrentExchangeRateService currentExchangeRateService) {
        this.currentExchangeRateService = currentExchangeRateService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<Currency, Float> getClicksAndCosts()
    {
        return currentExchangeRateService.getRates();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{fromCurrency}/{toCurrency}/{value}")
    public Float getClicksAndCosts(@PathVariable Currency fromCurrency,
                                   @PathVariable Currency toCurrency,
                                   @PathVariable Float value)
    {
        return currentExchangeRateService.getRate(fromCurrency, toCurrency, value);
    }


}
