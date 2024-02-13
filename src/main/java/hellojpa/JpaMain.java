package hellojpa;

import hellojpa.domain.*;
import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        Member member = new Member();
        member.setUsername("member1");
        member.setAge(10);
        em.persist(member);

        em.flush();
        em.clear();

        List<MemberDTO> resultList = em.createQuery("SELECT NEW hellojpa.domain.MemberDTO(m.username, m.age) FROM Member m")
                .getResultList();

        MemberDTO memberDTO = resultList.get(0);
        System.out.println("username = " + memberDTO.getUsername());
        System.out.println("age = " + memberDTO.getAge());

        tx.commit();

        em.close();
        emf.close();
    }
}
