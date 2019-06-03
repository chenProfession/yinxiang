package com.yinxiang.customerinfo;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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
    private CustomerInfoRepository customerInfoRepository;

    /**
     * @Description: to get the list of all the customers
     * @return: customer list
     * @Author: Mr.Cheng
     * @Date: 2019/3/27 8:36 PM
     */
    @Override
    public List<CustomerInfo> findAllCustomers() {

        Iterable<CustomerInfo> customerInfoIterable = customerInfoRepository.findAll();

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
    public List<CustomerInfo> getCustomerByName(String name) {
        return customerInfoRepository.findByCustomerName(name);
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
        List<CustomerInfo> customerInfoList = customerInfoRepository.findCustomerInfoByCustomerID(id);
        if(customerInfoList.size() > 0){
            return customerInfoList.get(0);
        }
        return null;
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
    public List<CustomerInfo> getCustomerByPhone(String phone) {
        List<CustomerInfo> customerInfoList = customerInfoRepository.findCustomerInfoByCustomerPhone(phone);
//        if(customerInfoList.size() > 0){
//            return customerInfoList;
//        }
        return customerInfoList;
    }

    /**
     * @param email
     * @Description: to get the information of the customer by email
     * @Param: phone
     * @return: Customer Information
     * @Author: Mr.Cheng
     * @Date: 2019/3/27 8:53 PM
     */
    @Override
    public List<CustomerInfo> getCustomerByEmail(String email) {
        List<CustomerInfo> customerInfoList = customerInfoRepository.findCustomerInfoByCustomerEmail(email);
//        if(customerInfoList.size() > 0){
//            return customerInfoList;
//        }
        return customerInfoList;
    }

    /**
     * @Description: count the number of the customers
     * @return: java.lang.Long
     * @Author: Mr.Cheng
     * @Date: 2019/5/13 4:05 PM
     */
    @Override
    public Long countAllCustomer() {
        return customerInfoRepository.count();
    }

    /**
    * @Description: to delete the customer by id, 0-failure 1-success
    * @Param: [id]
    * @return: int
    * @Author: Mr.Cheng
    * @Date: 2019/5/13 4:17 PM
    */
    @Override
    public int removeCustomerByID(Long id) {
        int deleted = 0;
        if(customerInfoRepository.existsById(id)){
            customerInfoRepository.deleteById(id);
            if(!customerInfoRepository.existsById(id)) {
                deleted = 1;
            }
        }
        return deleted;
    }

    /**
    * @Description: to save the customer information
    * @Param: [customerInfo]
    * @return: int
    * @Author: Mr.Cheng
    * @Date: 2019/5/14 11:28 AM
    */
    @Override
    public int saveCustomer(CustomerInfo customerInfo) {
        int saved = 0;
        if (getCustomerByPhone(customerInfo.getCustomerPhone()) == null
                && getCustomerByEmail(customerInfo.getCustomerEmail()) == null) {
            if (customerInfoRepository.existsById(customerInfoRepository.save(customerInfo).getCustomerID())) {
                saved = 1;
            }
        }
        return saved;
    }

    /**
     * @param customerInfo
     * @Description: to change the data of customer
     * @Param: [customerInfo]
     * @return: int
     * @Author: Mr.Cheng
     * @Date: 2019/5/29 7:41 PM
     */
    @Override
    public int changeCustomer(CustomerInfo customerInfo) {
        int changed = 0;
        if(customerInfoRepository.existsById(customerInfo.getCustomerID())
                && getCustomerByPhone(customerInfo.getCustomerPhone()).size() <= 1
                && getCustomerByEmail(customerInfo.getCustomerEmail()).size() <= 1){
            customerInfoRepository.save(customerInfo);
            changed = 1;
        }
        return changed;
    }

    /**
    * @Description: to save all the customers informations
    * @Param: [customerInfoIterable]
    * @return: java.lang.Iterable<com.yinxiang.customer.CustomerInfo>
    * @Author: Mr.Cheng
    * @Date: 2019/5/23 8:40 AM
    */
    @Override
    public List<CustomerInfo> saveAllCustomers(Iterable<CustomerInfo> customerInfoIterable) {
        Iterator iterator = customerInfoIterable.iterator();
        while(iterator.hasNext()){
            CustomerInfo customerInfo = (CustomerInfo) iterator.next();
            if(getCustomerByPhone(customerInfo.getCustomerPhone()) != null
                    || getCustomerByEmail(customerInfo.getCustomerEmail()) != null){
                iterator.remove();
            }
        }
        return Lists.newArrayList(customerInfoRepository.saveAll(customerInfoIterable));
    }

}
