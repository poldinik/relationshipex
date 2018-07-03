package com.cosmink.models;


import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
//@Model
@Stateful
public class Dao {

    @PersistenceContext(unitName = "persistence-unit-1", type = PersistenceContextType.EXTENDED)
    protected EntityManager entityManager;
}
