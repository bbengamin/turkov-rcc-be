package ru.studioluck.turkovrccbe.dao;

import com.google.inject.Inject;
import ru.studioluck.turkovrccbe.bean.User;

import javax.persistence.EntityManager;

public class UserDao {
    protected EntityManager entityManager;

    @Inject
    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveInNewTransaction(User user) {
        entityManager.getTransaction().begin();
        save(user);
        entityManager.getTransaction().commit();
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public User getByOtherField(String otherField) {
        return (User) entityManager
                .createQuery("select e from ExamplePersistedClass e where e.otherField=:otherField")
                .setParameter("otherField", otherField)
                .getSingleResult();
    }

}
