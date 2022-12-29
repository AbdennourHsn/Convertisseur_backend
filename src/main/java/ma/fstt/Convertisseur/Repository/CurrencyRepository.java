package ma.fstt.Convertisseur.Repository;

import ma.fstt.Convertisseur.Models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    Currency findByName(String code);

}
