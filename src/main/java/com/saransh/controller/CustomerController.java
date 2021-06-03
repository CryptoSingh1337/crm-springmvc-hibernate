package com.saransh.controller;

import com.saransh.entity.Customer;
import com.saransh.service.CustomerService;
import com.saransh.utils.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by CryptoSingh1337 on 6/1/2021
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, trimmer);
    }

    @GetMapping("/add")
    public String addCustomerPage(Model model) {
        model.addAttribute("customer", new Customer()); // add customer attribute so that on submit spring mvc can call setter on it.
        return "customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) // check for any error in customer properties
            return "customer-form";
        customerService.addCustomer(customer); // save the customer object in database
        return "redirect:/customer/list";
    }

    @GetMapping("/list")
    public String customerList(@RequestParam(name = "sortBy", required = false) String sortBy , Model model) {
        if (sortBy != null) {
            int sort = Integer.parseInt(sortBy);
            List<Customer> customers = customerService.getCustomers(sort);
            model.addAttribute("search", null);
            model.addAttribute("customers", customers);
        } else {
            List<Customer> customers = customerService.getCustomers(SortUtils.SortByLastName.getValue()); // get customers list from CustomerService class
            model.addAttribute("search", null);
            model.addAttribute("customers", customers); // add customers list in the model
        }
        return "customer-list";
    }

    @GetMapping("/update")
    public String updateCustomerPage(@RequestParam("id") int id, Model model) {
        model.addAttribute("customer", customerService.getCustomer(id)); // add customer attribute with the specific id.
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id) {
        customerService.deleteCustomer(id); // delete customer using the CustomerService class
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam(required = false) String search, Model model) {
        if (search != null) {
            model.addAttribute("search", search);
            model.addAttribute("customers", customerService.searchCustomer(search));
            return "customer-list";
        }
        return "redirect:/customer/list";
    }

    @Autowired
    public void setCustomerDAO(CustomerService customerService) {
        this.customerService = customerService;
    }
}
