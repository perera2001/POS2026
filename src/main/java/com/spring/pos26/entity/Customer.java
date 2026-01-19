package com.spring.pos26.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id" , length = 45 )
    private int customerId;

    @Column(name = "customer_name" , length = 45  , nullable = false)
    private String customerName;

    @Column(name = "customer_address" , length = 255 )
    private String customerAddress;

    @Column(name = "contact_number" , length = 255)
    private String contactNumber;


    @Column(name = "active_sate" , columnDefinition = "TINYINT default 1")
    private boolean active;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, String contactNumber, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumber = contactNumber;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
