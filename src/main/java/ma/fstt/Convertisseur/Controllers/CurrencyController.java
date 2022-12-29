package ma.fstt.Convertisseur.Controllers;

import ma.fstt.Convertisseur.Models.ApiStructure;
import ma.fstt.Convertisseur.Models.Currency;
import ma.fstt.Convertisseur.Service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@RestController
public class CurrencyController {
	@Autowired
	CurrencyService service;
	@GetMapping("/price/{name}")
	public Double GetPriceOf( @PathVariable("name") String name) {
		Currency currency= service.getByName(name);
		return currency.getPrice();
	}

	@GetMapping("/lastUpdate")
	public Currency getLastUpdate(){
		Currency currency =  service.getByName("USD");
		return currency;
	}


	@GetMapping("/GetDate")
	public String GetDataApi(){
		String url="https://v6.exchangerate-api.com/v6/462d448ff371ad029a2eece1/latest/USD";
		RestTemplate restTemplate = new RestTemplate();
		ApiStructure result= restTemplate.getForObject(url, ApiStructure.class);
		Set<String> keys = result.conversion_rates.keySet();
		String[] date_=result.time_last_update_utc.split(" ");
		String date="";
		for (int i =0; i<4;i++) {
			date+=" "+date_[i];
		}
		for(String key: keys){
			service.SaveCurrency(new Currency(key , result.conversion_rates.get(key) , date));
		}
		return "Dome";
	}

	
}
