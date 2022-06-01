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
    String userDate = today.toString();
    String message = "";

    @GetMapping("{currencyFrom}/{currencyTo}")
    @ResponseBody
    public String endPoint(@PathVariable String currencyFrom, @PathVariable String currencyTo){

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
        message = "Current exchange rate from " + currencyFrom + " to " + currencyTo + " is: " + currency.getRate();
        return message;
    }

    @GetMapping("{year}/{month}/{day}/{currencyFrom}/{currencyTo}")
    @ResponseBody
    public String endPointHistorical(@PathVariable String year, @PathVariable String month, @PathVariable String day, @PathVariable String currencyFrom, @PathVariable String currencyTo){

        userDate = year + "-" + month + "-" + day;
        Currency currency = new Currency();
        if(currencyFrom.equals("EUR")) {
            currency = readData(userDate, currencyTo);
        } else if(currencyTo.equals("EUR")){
            currency = readData(userDate,currencyFrom);
            currency = currencyToEuro(currency);
        }else {
            Currency exFrom = readData(userDate,currencyFrom);
            Currency exTo = readData(userDate,currencyTo);
            currency = currencyToCurrency(exFrom,exTo);
        }
        message = "Currency rate for date: " + userDate + " from " + currencyFrom + " to " + currencyTo + " is: " + currency.getRate();
        return message;
    }


}
