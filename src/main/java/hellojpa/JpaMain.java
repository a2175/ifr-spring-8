package hellojpa;

import hellojpa.domain.*;
import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Book book = new Book();
        book.setName("JPA");
        book.setAuthor("김영한");

        em.persist(book);

        tx.commit();

        em.close();
        emf.close();
    }
}
