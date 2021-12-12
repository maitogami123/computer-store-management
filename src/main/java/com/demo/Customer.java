package com.demo;

import java.util.Scanner;

public class Customer {
    private String customerId, mail, customerName, address, phoneNumber;
    Scanner sc = new Scanner(System.in);

    // Constructor

    Customer() {

    }

    Customer(String customerId, String mail, String customerName, String address, String phoneNumber) {
        this.customerId = customerId;
        this.mail = mail;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Setter

    void setCustomerId() {
        System.out.print("Customer Id: ");
        customerId = sc.nextLine();
    }

    void setMail() {
        System.out.print("Customer's Mail: ");
        mail = sc.nextLine();
    }
    
    void setCustomnerName() {
        System.out.print("Customer's name: ");
        customerName = sc.nextLine();
    }

    void setAddress() {
        System.out.print("Customer address: ");
        address = sc.nextLine();
    }

    void setPhoneNumber() {
        System.out.print("Customer contact number: ");
        phoneNumber = sc.nextLine();
    }

    void setInfo() {
        setCustomerId();
        setMail();
        setCustomnerName();
        setAddress();
        setPhoneNumber();
    }

    // Getter

    String getCustomerId() {
        return customerId;
    }

    String getMail() {
        return mail;
    }

    String getCustomnerName() {
        return customerName;
    }
    
    String getAddress() {
        return address;
    }
    
    String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return (customerId + "/" + mail + "/" + customerName + "/" + address + "/" + phoneNumber);
    }

}
