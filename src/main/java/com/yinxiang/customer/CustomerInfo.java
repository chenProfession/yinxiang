package com.yinxiang.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Size(min = 1,max = 10,message = "{customerInfo.customerName.size}")
    @NotBlank(message = "{customerInfo.customerName.notBlank}")
    @Column(name="customer_name", length=30)
    private String customerName;

    /** customer gender */
    @NotBlank(message = "{customerInfo.customerGender.notBlank}")
    @Column(name="customer_gender")
    private String customerGender;

    /** customer contact */
    @Column(name="customer_contact")
    private String customerContact;

    /** customer phone number */
    @Pattern(regexp = "1\\d{10}",message = "{customerInfo.customerPhone.pattern}")
    @Column(name="customer_phone")
    private String customerPhone;

    /** customer email */
    @Email
    @Column(name="customer_email")
    private String customerEmail;

    /** customer address */
    @Column(name="customer_address")
    private String customerAddress;
}
