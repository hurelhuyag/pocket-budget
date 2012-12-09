package org.hurelhuyag.pocketbudget.web.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: hurlee
 * Date: 12/9/12
 * Time: 4:31 PM
 */
public class EMF {

    public static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("transactions-optional");

    public static EntityManagerFactory get(){
        return EMF;
    }
}
