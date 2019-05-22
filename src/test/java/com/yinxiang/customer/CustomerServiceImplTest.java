package com.yinxiang.customer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    }

    @Test
    public void getCustomerByID() throws Exception {
    }

    @Test
    public void getCustomerByPhone() throws Exception {

        String phone_one = "123456789";
        CustomerInfo customerInfo = customerService.getCustomerByPhone(phone_one);
        log.info(customerInfo.getCustomerID().toString());
        log.info(customerInfo.getCustomerEmail());
        Assert.assertNotNull(customerInfo);

        String phone_two = "123456788";
        CustomerInfo customerInfoNew = customerService.getCustomerByPhone(phone_two);
        Assert.assertNull(customerInfoNew);
    }

    @Test
    public void countAllCustomer() throws Exception {
    }

    @Test
    public void removeCustomerByID() throws Exception {
    }

    @Test
    public void saveCustomer() throws Exception {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerName("new hello world");
        customerInfo.setCustomerGender("female");
        customerInfo.setCustomerAddress("this is our world");
        customerInfo.setCustomerContact("020-456789");
        customerInfo.setCustomerEmail("bewhelloworld@163.com");
        customerInfo.setCustomerPhone("123456787");

        int result = customerService.saveCustomer(customerInfo);

        Assert.assertEquals(1,result);
    }

    @Test
    public void saveAllCustomers() throws Exception {
    }

}