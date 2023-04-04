package com.code.jewelleryshop.repo;

import com.code.jewelleryshop.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>
{
    List<Customer> findAllBypriceIn(Set<Integer> pre);
}
