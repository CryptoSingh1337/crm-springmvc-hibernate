package com.saransh.dao;

import com.saransh.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CryptoSingh1337 on 6/1/2021
 *
 * It is a DAO implementation of {@link CustomerDAO}
 */

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private SessionFactory factory;

    @Override
    public void addCustomer(Customer customer) {
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = factory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public List<Customer> getCustomers(int sortBy) {
        String sort;
        switch (sortBy) {
            case 0: sort = "firstName";
                break;
            case 2: sort = "email";
                break;
            default:
                sort = "lastName";
        }
        Session session = factory.getCurrentSession(); // get hibernate session.
        String queryString = "from Customer order by " + sort;
        Query<Customer> query = session.createQuery(queryString, Customer.class); // create query.
        return query.getResultList(); // execute query and get customers list.
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = factory.getCurrentSession(); // get hibernate session.
        Query query = session.createQuery("delete from Customer where id=:customerID");
        query.setParameter("customerID", id);
        query.executeUpdate(); // delete the customer from the database.
    }

    @Override
    public List<Customer> searchCustomer(String searchString) {
        Session session = factory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer where firstName like :search or lastName like :search or email like :search", Customer.class);
        searchString = "%" + searchString + "%";
        query.setParameter("search", searchString);
        return query.getResultList();
    }

    @Autowired
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
}
