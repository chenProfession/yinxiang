package com.yinxiang.customerinfo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @program: ordering
 * @Description: Customer Repository
 * @author: Mr.Cheng
 * @date: 2019/3/28 12:32 AM
 */
public interface CustomerInfoRepository extends CrudRepository<CustomerInfo, Long> {

    /**
    * fetch the data of customer from database by name
    * @Param: [customerName]
    * @return: java.util.List<com.yiinxiang.customer.CustomerInfo>
    * @Author: Mr.Cheng
    * @Date: 2019/4/2 8:26 PM
    */
    List<CustomerInfo> findByCustomerName(String customerName);

    /**
    * @Description: fetch the data of customer from database by phone
    * @Param: [customerPhone]
    * @return: java.util.List<com.yinxiang.customer.CustomerInfo>
    * @Author: Mr.Cheng
    * @Date: 2019/5/13 4:00 PM
    */
    List<CustomerInfo> findCustomerInfoByCustomerPhone(String customerPhone);

    /**
     * @Description: fetch the data of customer from database by email
     * @Param: [customerPhone]
     * @return: java.util.List<com.yinxiang.customer.CustomerInfo>
     * @Author: Mr.Cheng
     * @Date: 2019/5/13 4:00 PM
     */
    List<CustomerInfo> findCustomerInfoByCustomerEmail(String customerEmail);

    /**
    * @Description: fetch the data of customer from databse by cutomerId
    * @Param: [customerId]
    * @return: java.util.List<com.yinxiang.customer.CustomerInfo>
    * @Author: Mr.Cheng
    * @Date: 2019/5/13 4:00 PM
    */
    List<CustomerInfo> findCustomerInfoByCustomerID(Long customerId);



}
