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

    List<CustomerInfo> findByCustomerName(String customerName);
}
