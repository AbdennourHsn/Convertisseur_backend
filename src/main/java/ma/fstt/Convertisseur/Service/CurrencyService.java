package ma.fstt.Convertisseur.Service;

import ma.fstt.Convertisseur.Models.Currency;
import ma.fstt.Convertisseur.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository repository;

    public void SaveCurrency(Currency currency){
        repository.save(currency);
    }

    public Currency getById(Integer id){
        return  repository.getById(id);
    }

    public List<Currency> getAll(){
        return  repository.findAll();
    }


    public Currency getByName(String name){
        return  repository.findByName(name);
    }
}
