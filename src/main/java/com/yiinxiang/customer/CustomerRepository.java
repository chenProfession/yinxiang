package com.yiinxiang.customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @program: ordering
 * @Description: Customer Repository
 * @author: Mr.Cheng
 * @date: 2019/3/28 12:32 AM
 */
public interface CustomerRepository extends CrudRepository<CustomerInfo, Long> {

    /**
    * fetch the data of customer from database by name
    * @Param: [customerName]
    * @return: java.util.List<com.yiinxiang.customer.CustomerInfo>
    * @Author: Mr.Cheng
    * @Date: 2019/4/2 8:26 PM
    */
    List<CustomerInfo> findByCustomerName(String customerName);


    List<CustomerInfo> findCustomerInfoByCustomerPhone(String customerPhone);

    List<CustomerInfo> findCustomerInfoByCustomerID(Long customerId);

}
