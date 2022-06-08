package ecb.amw.SOAECBSpringBootAPI;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@RestController
@RequestMapping("/currency/rates")
public class CurrencyApi extends SQLiteOperations {

    public CurrencyApi() throws Exception {

    }

    protected static Currency currencyToEuro(Currency currency) {
        Currency swap;
        double rate = 1 / currency.getRate();
        swap = new Currency(currency.getDate(), currency.getTo(), currency.getFrom(), rate);
        return swap;
    }

    protected static Currency currencyToCurrency(Currency fromCurrency, Currency toCurrency) {
        Currency swap;
        double rate = toCurrency.getRate() / fromCurrency.getRate();
        swap = new Currency(fromCurrency.getDate(), fromCurrency.getTo(), toCurrency.getTo(), rate);
        return swap;
    }

    protected static boolean isValidDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(date);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void checkCurrencies(@PathVariable String currencyFrom, @PathVariable String currencyTo, String userDate) {
        if (currencyFrom.equals("EUR")) {
            currency = readData(userDate, currencyTo);
        } else if (currencyTo.equals("EUR")) {
            currency = readData(userDate, currencyFrom);
            currency = currencyToEuro(currency);
        } else {
            Currency exFrom = readData(userDate, currencyFrom);
            Currency exTo = readData(userDate, currencyTo);
            currency = currencyToCurrency(exFrom, exTo);
        }
    }

    LocalDate today = LocalDate.now();
    String string2Date = today.toString();
    String userDate = today.toString();
    Currency currency = new Currency();
    String message = "";

    @GetMapping("{currencyFrom}/{currencyTo}")
    @ResponseBody
    public String endPoint(@PathVariable String currencyFrom, @PathVariable String currencyTo) {
        checkCurrencies(currencyFrom, currencyTo, string2Date);
        if (currency.getRate() == 0 || Double.isNaN(currency.getRate())) {
            message = "Currencies not available in our service!";
        } else {
            message = "Current exchange rate from " + currencyFrom + " to " + currencyTo + " is: " + currency.getRate();
        }
        return message;
    }

    @GetMapping("{currencyFrom}/{currencyTo}/{year}/{month}/{day}")
    @ResponseBody
    public String endPointHistorical(@PathVariable String year, @PathVariable String month, @PathVariable String day,
            @PathVariable String currencyFrom, @PathVariable String currencyTo) {

        userDate = year + "-" + month + "-" + day;
        if(!isValidDate(userDate)){
            message = "Not a proper date!";
        } else {
            checkCurrencies(currencyFrom, currencyTo, userDate);
            if (currency.getRate() == 0 || Double.isNaN(currency.getRate())) {
                message = "Currencies or date not available in our service!";
            } else {
                message = "Exchange rate for date: " + userDate + " from " + currencyFrom + " to " + currencyTo + " is: " + currency.getRate();
            }
        }
        return message;
    }

}
