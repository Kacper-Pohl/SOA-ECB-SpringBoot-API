package ecb.amw.SOAECBSpringBootAPI;


import ecb.amw.SOAECBSpringBootAPI.SQLiteOperations;
import ecb.amw.SOAECBSpringBootAPI.Currency;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/currency/rates")
public class CurrencyApi extends SQLiteOperations {

    public CurrencyApi()throws Exception{

    }

    protected static Currency currencyToEuro(Currency currency){
        double rate = 1/ currency.getRate();
        Currency swap = new Currency(currency.getDate(), currency.getTo(), currency.getFrom(),rate);
        return swap;
    }
    protected static Currency currencyToCurrency(Currency fromCurrency, Currency toCurrency){
        Currency swap;
        double rate = toCurrency.getRate()/ fromCurrency.getRate();
        swap = new Currency(fromCurrency.getDate(), fromCurrency.getTo(), toCurrency.getTo(), rate);
        return swap;
    }

    LocalDate today = LocalDate.now();
    String string2Date = today.toString();

    @GetMapping("{currencyFrom}/{currencyTo}")
    @ResponseBody
    public Currency endpointhistorical(@PathVariable String currencyFrom, @PathVariable String currencyTo){

        Currency currency = new Currency();
        if(currencyFrom.equals("EUR")) {
            currency = readData(string2Date, currencyTo);
        } else if(currencyTo.equals("EUR")){
            currency = readData(string2Date,currencyFrom);
            currency = currencyToEuro(currency);
        }else {
            Currency exFrom = readData(string2Date,currencyFrom);
            Currency exTo = readData(string2Date,currencyTo);
            currency = currencyToCurrency(exFrom,exTo);
        }
        return currency;
    }


}
