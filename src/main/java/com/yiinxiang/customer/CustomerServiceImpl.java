package com.yiinxiang.customer;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ordering
 * @Description: to implement customer service
 * @author: Mr.Cheng
 * @date: 2019/4/2 5:50 PM
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * @Description: to get the list of all the customers
     * @return: customer list
     * @Author: Mr.Cheng
     * @Date: 2019/3/27 8:36 PM
     */
    @Override
    public List<CustomerInfo> findAllCustomers() {

        Iterable<CustomerInfo> customerInfoIterable = customerRepository.findAll();

        return Lists.newArrayList(customerInfoIterable);
    }

    /**
     * @param name
     * @Description: to get the information of the customer by name
     * @Param: name
     * @return: Customer Information
     * @Author: Mr.Cheng
     * @Date: 2019/3/27 8:42 PM
     */
    @Override
    public CustomerInfo getCustomerByName(String name) {
        return customerRepository.findByCustomerName(name).get(0);
    }

    /**
     * @param id
     * @Description: to get the information of the customer by id
     * @Param: id
     * @return: Customer Information
     * @Author: Mr.Cheng
     * @Date: 2019/3/27 8:53 PM
     */
    @Override
    public CustomerInfo getCustomerByID(Long id) {
        return customerRepository.findCustomerInfoByCustomerID(id).get(0);
    }

    /**
     * @param phone
     * @Description: to get the information of the customer by phone
     * @Param: phone
     * @return: Customer Information
     * @Author: Mr.Cheng
     * @Date: 2019/3/27 8:53 PM
     */
    @Override
    public CustomerInfo getCustomerByPhone(String phone) {
        return customerRepository.findCustomerInfoByCustomerPhone(phone).get(0);
    }
}
