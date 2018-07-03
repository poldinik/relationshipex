package com.cosmink.models.User;

import com.cosmink.models.CRUD;
import com.cosmink.models.Dao;
import org.hibernate.Hibernate;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao extends Dao implements CRUD<User>{

    @Override
    public Boolean create(User entity) throws EntityExistsException, IllegalStateException, IllegalArgumentException, TransactionRequiredException {
        entityManager.persist(entity);
        return true;
    }

    @Override
    public User read(long primaryKey) throws IllegalStateException, IllegalArgumentException {
        return null;
    }

    @Override
    public Boolean update(User entity) throws IllegalStateException, IllegalArgumentException, TransactionRequiredException {
        return null;
    }

    @Override
    public Boolean delete(long id) throws IllegalStateException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
        return null;
    }

    public List<User> getUsers() throws Exception {
       Query query = entityManager.createQuery("SELECT u from User as u JOIN FETCH u.userGroups");
        //va usato il fetch sennò non carica in modo lazy la lista di gruppi
        //FIXME: query non restituisce utenti, forse perchè prende utenti che hanno almeno un gruppo...
        //Query query = entityManager.createQuery("SELECT u from User as u JOIN FETCH u.userGroups ug WHERE u.id = ug.id");
        List<User> users = query.getResultList();
        return users;
    }

    //FIXME: aggiungere throws exceptions idonee

    public User findByUsernameOrEmail(String identifier) {
        List<User> users = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :identifier OR u.userCredentials.email= :identifier", User.class)
                .setParameter("identifier", identifier)
                .setMaxResults(1)
                .getResultList();
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }



}
