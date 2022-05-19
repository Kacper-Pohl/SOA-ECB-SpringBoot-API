package ecb.amw.SOAECBSpringBootAPI.dao;

import ecb.amw.SOAECBSpringBootAPI.dao.entity.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends CrudRepository<Currency, String>{
}
