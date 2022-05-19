package ecb.amw.SOAECBSpringBootAPI.manager;


import ecb.amw.SOAECBSpringBootAPI.dao.CurrencyRepo;
import ecb.amw.SOAECBSpringBootAPI.dao.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyManager {

    private CurrencyRepo currencyRepo;

    @Autowired
    public CurrencyManager(CurrencyRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    public Optional<Currency> find(String date){
        return currencyRepo.findById(date);
    }

    public Iterable<Currency> findAll(String date){
        return currencyRepo.findAll();
    }


}
