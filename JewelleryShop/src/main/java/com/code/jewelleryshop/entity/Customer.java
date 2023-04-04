package com.code.jewelleryshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="customers")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String customerName;
    private String JewelType;
    private Integer price;

    public Customer()
    {

    }

    public Customer(Integer id, String customerName, String jewelType, Integer price)
    {
        this.id = id;
        this.customerName = customerName;
        this.JewelType = jewelType;
        this.price = price;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getJewelType()
    {
        return JewelType;
    }

    public void setJewelType(String jewelType)
    {
        JewelType = jewelType;
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }
}
