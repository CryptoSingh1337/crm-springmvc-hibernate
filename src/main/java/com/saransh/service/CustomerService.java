package com.saransh.service;

import com.saransh.entity.Customer;

import java.util.List;

/**
 * Created by CryptoSingh1337 on 6/1/2021
 */

public interface CustomerService {

    void addCustomer(Customer customer);
    Customer getCustomer(int id);
    List<Customer> getCustomers(int sortBy);
    void deleteCustomer(int id);
    List<Customer> searchCustomer(String searchString);
}
