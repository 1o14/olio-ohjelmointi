package Assignment7_3.dao;

import Assignment7_3.model.Currency;
import jakarta.persistence.*;
import java.util.List;

public class CurrencyDao {
    // Luodaan EntityManagerFactory tietokantayhteyksiä varten
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("currencyPU");

    // Hakee valuutan tietokannasta lyhenteen perusteella
    public Currency getCurrencyByCode(String code) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Currency c WHERE c.abbreviation = :code", Currency.class)
                    .setParameter("code", code)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    // Lisää uuden valuutan tietokantaan
    public void addCurrency(Currency currency) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(currency);
            tx.commit();
        } finally {
            em.close();
        }
    }

    // Hakee kaikki valuutat tietokannasta
    public List<Currency> getAllCurrencies() {
        EntityManager em = emf.createEntityManager();
        List<Currency> currencies = em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
        em.close();
        return currencies;
    }
}
