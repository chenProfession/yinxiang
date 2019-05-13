package com.yiinxiang.customer;

import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: manage the information of the customers
* @Author: Mr.Cheng
* @Date: 2019/3/27 8:36 PM
*/
public interface CustomerService {
    /**
    * @Description: to get the list of all the customers
    * @return:  customer list
    * @Author: Mr.Cheng
    * @Date: 2019/3/27 8:36 PM
    */
    List<CustomerInfo> findAllCustomers();

    /**
    * @Description: to get the information of the customer by name
    * @Param: name
    * @return: Customer Information
    * @Author: Mr.Cheng
    * @Date: 2019/3/27 8:42 PM
    */
    CustomerInfo getCustomerByName(String name);

    /**
    * @Description: to get the information of the customer by id
    * @Param: id
    * @return: Customer Information
    * @Author: Mr.Cheng
    * @Date: 2019/3/27 8:53 PM
    */
    CustomerInfo getCustomerByID(Long id);

    /**
     * @Description: to get the information of the customer by phone
     * @Param: phone
     * @return: Customer Information
     * @Author: Mr.Cheng
     * @Date: 2019/3/27 8:53 PM
     */
    CustomerInfo getCustomerByPhone(String phone);
}
