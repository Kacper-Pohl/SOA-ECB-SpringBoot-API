package ecb.amw.SOAECBSpringBootAPI.api;


import ecb.amw.SOAECBSpringBootAPI.manager.CurrencyManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyApi {

    private CurrencyManager currency;


}
