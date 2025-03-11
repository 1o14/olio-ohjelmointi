package Assignment7_4.dao;

import Assignment7_4.model.Currency;
import jakarta.persistence.*;
import java.util.List;

public class CurrencyDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("currencyPU");

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

    public List<Currency> getAllCurrencies() {
        EntityManager em = emf.createEntityManager();
        List<Currency> currencies = em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
        em.close();
        return currencies;
    }
}
