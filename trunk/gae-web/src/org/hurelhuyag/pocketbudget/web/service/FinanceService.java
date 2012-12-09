package org.hurelhuyag.pocketbudget.web.service;

import org.hurelhuyag.pocketbudget.web.domain.Finance;

import javax.persistence.*;
import java.util.List;

/**
 * User: hurelhuyag
 * Email: hurle0409@gmail.com
 * Date: 12/8/12
 * Time: 7:36 PM
 */
public class FinanceService {

    private static FinanceService financeService;
    public static FinanceService getFinanceService(){
        if (financeService==null){
            financeService = new FinanceService(EMF.get());
        }
        return financeService;
    }

    EntityManagerFactory emf;

    public FinanceService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Finance get(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(Finance.class, id);
    }

    public void save(Finance f){
        /*if (f.getId()==null){
            em.persist(f);
        }else{
            em.merge(f);
        }*/
        //em.merge(f);
        EntityManager em = emf.createEntityManager();
        try{
            em.persist(f);
        }finally {
            em.close();
        }
    }

    public void delete(Finance f){
        EntityManager em = emf.createEntityManager();
        try{
            em.remove(f);
        }finally {
            em.close();
        }
    }

    public List<Finance> list(String userid){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select f from Finance f where f.userid = :userid");
        q.setParameter("userid", userid);
        return q.getResultList();
    }
}
