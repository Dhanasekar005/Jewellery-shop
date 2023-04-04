package com.code.jewelleryshop.controller;

import com.code.jewelleryshop.entity.Customer;
import com.code.jewelleryshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customers")
    public List<Customer> getCustomers(@RequestParam(value="prices",required = false) Set<Integer>pre)
    {
        return customerService.getCustomers(pre);
    }

    @RequestMapping(value="/customers",method= RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return customerService.createCustomer(customer);
    }

    @RequestMapping(value="/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id") Integer customerId)
    {
        return customerService.getCustomerById(customerId);
    }

    @RequestMapping(value="/customers",method=RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer incomingCustomer)
    {
        return customerService.updateCustomer(incomingCustomer);
    }

    @RequestMapping(value="/customers/{customerId}",method=RequestMethod.DELETE)
    public String deleteCustomerById(@PathVariable Integer customerId)
    {
        return customerService.deleteById(customerId);
    }


}
