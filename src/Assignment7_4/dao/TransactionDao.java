package Assignment7_4.dao;

import Assignment7_4.model.Transaction;
import jakarta.persistence.*;

public class TransactionDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("currencyPU");

    // Tallennetaan uusi transaktio tietokantaan
    public void addTransaction(Transaction transaction) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(transaction); // Tallennetaan tietokantaan
            tx.commit();
        } finally {
            em.close();
        }
    }
}
