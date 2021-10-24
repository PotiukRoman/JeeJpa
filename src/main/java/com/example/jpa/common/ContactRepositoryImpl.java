package com.example.jpa.common;
import com.example.jpa.common.Contact;
import com.example.jpa.common.ContactRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    int id;
    String first_name;
    String last_name;
    String phone;
    String command;

    public ContactRepositoryImpl() {
        // default
    }

    public ContactRepositoryImpl(Contact contact) {
        this.first_name = contact.getFirstName();
        this.last_name = contact.getLastName();
        this.phone = contact.getPhone();
    }

    @Override
    public void save(Contact contact) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(contact);
        entityManager.getTransaction().commit();
    }

    @Override
    public void saveBulk(List<Contact> list) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        for(int i=0; i<list.size();i++){
            entityManager.persist(list.get(i));
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Contact contact) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Contact contact1 = entityManager.find(Contact.class, contact.getId());
        contact1.setFirstName(contact.getFirstName());
        contact1.setLastName(contact.getLastName());
        contact1.setPhone(contact.getPhone());
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Contact contact = entityManager.find(Contact.class, id);
        entityManager.remove(contact);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Contact> getContacts() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        List<Contact> list= (List<Contact>)entityManager.createNativeQuery("SELECT * FROM test2.contacts;",Contact.class).getResultList();
        entityManager.getTransaction().commit();
        return list;
    }

    @Override
    public Contact getContactById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Contact contact = entityManager.find(Contact.class, id);
        entityManager.detach(contact);
        entityManager.getTransaction().commit();
        return contact;
    }
}