package com.yiinxiang.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @program: ordering
 * @Description: to recorder the information of the customer
 * @author: Mr.Cheng
 * @date: 2019/3/27 8:03 PM
 */
@Data
@Entity
@Table(name = "customer_info")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfo {

    /** customer id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerID;

    /** customer name */
    @Column(name="customer_name", length=30)
    private String customerName;

    /** customer gender */
    @Column(name="customer_gender")
    private String customerGender;

    /** customer contact */
    @Column(name="customer_contact")
    private String customerContact;

    /** customer phone number */
    @Column(name="customer_phone")
    private String customerPhone;

    /** customer email */
    @Column(name="customer_email")
    private String customerEmail;

    /** customer address */
    @Column(name="customer_address")
    private String customerAddress;
}
