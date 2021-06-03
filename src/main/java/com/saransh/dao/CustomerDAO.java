package com.saransh.dao;

import com.saransh.entity.Customer;

import java.util.List;

/**
 * Created by CryptoSingh1337 on 6/1/2021
 *
 * Its a simple DAO interface for Customer class.
 */

public interface CustomerDAO {

    /**
     * Method to add {@link Customer} object in database.
     * @param customer - {@link Customer} object which has to add in database.
     */
    void addCustomer(Customer customer);

    /**
     * @param id - id of the {@link Customer} object.
     * @return - {@link Customer} object which is retrieved from database.
     */
    Customer getCustomer(int id);

    /**
     * Getter method for retrieving the customers list from database.
     * @param sortBy - get list of {@link Customer} in sorted manner based on sortBy.
     * @return - list of {@link Customer}
     */
    List<Customer> getCustomers(int sortBy);

    /**
     * Method to delete the {@link Customer} object with the id from the database.
     * @param id - used to retrieve the {@link Customer} object from the database.
     */
    void deleteCustomer(int id);

    /**
     * Method to search {@link Customer} based on searchString.
     * @param searchString - pattern to be search in firstName, lastName and email.
     * @return - list of {@link Customer} which have the given String in their property.
     */
    List<Customer> searchCustomer(String searchString);
}
