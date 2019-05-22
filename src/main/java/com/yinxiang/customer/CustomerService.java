package com.yinxiang.customer;

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
    List<CustomerInfo> getCustomerByName(String name);

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

    /**
     * @Description: to get the information of the customer by email
     * @Param: phone
     * @return: Customer Information
     * @Author: Mr.Cheng
     * @Date: 2019/3/27 8:53 PM
     */
    CustomerInfo getCustomerByEmail(String email);

    /**
    * @Description: to count the number of the customers
    * @return: java.lang.Long
    * @Author: Mr.Cheng
    * @Date: 2019/5/13 4:05 PM
    */
    Long countAllCustomer();

    /**
    * @Description: to delete the customer by id
    * @Param: [id]
    * @return: java.lang.Long
    * @Author: Mr.Cheng
    * @Date: 2019/5/13 4:09 PM
    */
    int removeCustomerByID(Long id);

    /**
    * @Description: to save the data of customer
    * @Param: [customerInfo]
    * @return: int
    * @Author: Mr.Cheng
    * @Date: 2019/5/14 11:10 AM
    */
    int saveCustomer(CustomerInfo customerInfo);

    Iterable<CustomerInfo> saveAllCustomers(Iterable<CustomerInfo> customerInfoIterable);
}
