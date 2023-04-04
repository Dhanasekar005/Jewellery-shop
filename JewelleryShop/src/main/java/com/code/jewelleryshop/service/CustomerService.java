package com.code.jewelleryshop.service;

import com.code.jewelleryshop.entity.Customer;
import com.code.jewelleryshop.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getCustomers(Set<Integer> pre)
    {
        List<Customer> customerList=new ArrayList<>();
        if(pre==null)
        {
            customerRepository.findAll().forEach(customers ->customerList.add(customers));
        }
        else
        {
            return customerRepository.findAllBypriceIn(pre);
        }
        return customerList;
    }

    public Customer createCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Integer customerId)
    {
        return customerRepository.findById(customerId);
    }

    public Customer updateCustomer(Customer incomingCustomer)
    {
        return customerRepository.save(incomingCustomer);
    }

    public String deleteById(Integer customerId)
    {
        customerRepository.deleteById(customerId);
        return "Deleted successfully";
    }
}
