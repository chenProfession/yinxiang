package com.yinxiang.customer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl customerService;

    @Test
    public void findAllCustomers() throws Exception {
        List<CustomerInfo> customerInfoList = customerService.findAllCustomers();
        log.info(customerInfoList.toString());
        Assert.assertNotNull(customerInfoList);
    }

    @Test
    public void getCustomerByName() throws Exception {
        String name = "hello world";
        List<CustomerInfo> customerInfoList = customerService.getCustomerByName(name);
        if(customerInfoList.size() == 0){
            log.info("can not find it");
            Assert.assertEquals(0,customerInfoList.size());
        } else {
            log.info(customerInfoList.toString());
            Assert.assertNotNull(customerInfoList);
        }
    }

    @Test
    public void getCustomerByID() throws Exception {
        Long customerId = new Long(1);
        CustomerInfo customerInfo = customerService.getCustomerByID(customerId);
        if(customerInfo == null){
            log.info("can not find the customer");
            Assert.assertNull(customerInfo);
        } else {
            log.info(customerInfo.toString());
            Assert.assertNotNull(customerInfo);
        }
    }

    @Test
    public void getCustomerByPhone() throws Exception {
        String phone = "1234567890";
        CustomerInfo customerInfo = customerService.getCustomerByPhone(phone);
        if(customerInfo != null) {
            log.info(customerInfo.getCustomerID().toString());
            log.info(customerInfo.getCustomerEmail());
            Assert.assertNotNull(customerInfo);
        } else {
            log.info("can not find it");
            Assert.assertNull(customerInfo);
        }
    }

    @Test
    public void getCustomerByEmail() throws Exception {
        String email = "helloworld@163.com";
        CustomerInfo customerInfo = customerService.getCustomerByEmail(email);
        if(customerInfo != null){
            log.info(customerInfo.toString());
            Assert.assertNotNull(customerInfo);
        } else {
            log.info("can not find it");
            Assert.assertNull(customerInfo);
        }
    }

    @Test
    public void countAllCustomer() throws Exception {
        List<CustomerInfo> customerInfoList = customerService.findAllCustomers();
        log.info("counting number is : " + customerService.countAllCustomer().toString());
        log.info(String.valueOf("the list size is : " + customerInfoList.size()));
        Assert.assertEquals(customerInfoList.size(),customerService.countAllCustomer().intValue());
    }

    @Test
    public void removeCustomerByID() throws Exception {
        Long customerId = new Long(4);

        if(customerService.getCustomerByID(customerId) != null) {
            int result = customerService.removeCustomerByID(customerId);
            log.info("remove customer");
            Assert.assertEquals(1,result);
        } else {
            int result = customerService.removeCustomerByID(customerId);
            log.info("no customer");
            Assert.assertEquals(0,result);
        }
    }

    @Test
    public void saveCustomer() throws Exception {

        String phone = "123456787";
        String email = "qhelloworld@163.com";
        String name = "new hello world";
        String gender = "female";
        String address = "this is our world";
        String contact = "020-456789";

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerName(name);
        customerInfo.setCustomerGender(gender);
        customerInfo.setCustomerAddress(address);
        customerInfo.setCustomerContact(contact);
        customerInfo.setCustomerEmail(email);
        customerInfo.setCustomerPhone(phone);

        if(customerService.getCustomerByPhone(phone) == null
                && customerService.getCustomerByEmail(email) == null) {
            int result = customerService.saveCustomer(customerInfo);
            Assert.assertEquals(1,result);
        } else {
            int result = customerService.saveCustomer(customerInfo);
            log.info("user already exist");
            Assert.assertEquals(0,result);
        }

    }

    @Test
    public void saveAllCustomers() throws Exception {

        String phoneA = "123456785";
        String emailA = "bhelloworld@163.com";
        String nameA = "new hello world";
        String genderA = "female";
        String addressA = "this is our world";
        String contactA = "020-456789";

        String phoneB = "123456784";
        String emailB = "zhelloworld@163.com";
        String nameB = "new hello world";
        String genderB = "female";
        String addressB = "this is our world";
        String contactB = "020-456789";

        CustomerInfo customerInfoA = new CustomerInfo();
        customerInfoA.setCustomerName(nameA);
        customerInfoA.setCustomerGender(genderA);
        customerInfoA.setCustomerAddress(addressA);
        customerInfoA.setCustomerContact(contactA);
        customerInfoA.setCustomerEmail(emailA);
        customerInfoA.setCustomerPhone(phoneA);

        CustomerInfo customerInfoB = new CustomerInfo();
        customerInfoB.setCustomerName(nameB);
        customerInfoB.setCustomerGender(genderB);
        customerInfoB.setCustomerAddress(addressB);
        customerInfoB.setCustomerContact(contactB);
        customerInfoB.setCustomerEmail(emailB);
        customerInfoB.setCustomerPhone(phoneB);

        List<CustomerInfo> customerInfoLinkedList = new ArrayList<>();
        customerInfoLinkedList.add(customerInfoA);
        customerInfoLinkedList.add(customerInfoB);
        List<CustomerInfo> customerInfoList = customerService.saveAllCustomers(customerInfoLinkedList);
        log.info("List size is : " + String.valueOf(customerInfoList.size()));
        log.info(customerInfoList.toString());
        Assert.assertNotNull(customerInfoList);
    }

}