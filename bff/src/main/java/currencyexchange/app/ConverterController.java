package currencyexchange.app;

import currencyexchange.app.exchange.Currency;
import currencyexchange.app.exchange.CurrentExchangeRateService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @RequestMapping(method = RequestMethod.GET, value = "/{currency}/{value}")
    public Float getClicksAndCosts(@PathVariable Currency currency, @PathVariable Float value)
    {
        return currentExchangeRateService.getRate(currency);
    }


}
