package com.code.jewelleryshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer quantity;
    private String paymentMode;

    public Order() {

    }

    public Order(Integer id, String name, Integer quantity, String paymentMode) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.paymentMode = paymentMode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Integer getQuantity()
    {
        return quantity;
    }
    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }
    public String getPaymentMode()
    {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode)
    {
        this.paymentMode = paymentMode;
    }

}
