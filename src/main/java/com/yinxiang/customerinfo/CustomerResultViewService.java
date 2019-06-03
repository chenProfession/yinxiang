package com.yinxiang.customerinfo;

import com.yinxiang.result.ResultView;

import java.util.concurrent.CompletableFuture;

/**
 * @program: ordering
 * @Description: support service for the view of customer
 * @author: Mr.Cheng
 * @date: 2019/5/13 3:25 PM
 */
public interface CustomerResultViewService {

    /**
    * @Description: to give the view of the customer list
    * @Param: []
    * @return: java.util.concurrent.CompletableFuture<com.yinxiang.result.ResultView>
    * @Author: Mr.Cheng
    * @Date: 2019/6/1 10:11 PM
    */
    CompletableFuture<ResultView> getCustomerListView() throws InterruptedException;

    /**
    * @Description: to give the view of the customer by Email
    * @Param: [customerEmail]
    * @return: java.util.concurrent.CompletableFuture<com.yinxiang.result.ResultView>
    * @Author: Mr.Cheng
    * @Date: 2019/6/1 10:10 PM
    */
    CompletableFuture<ResultView> getCustomerViewByEmail(String customerEmail) throws InterruptedException;

    /**
    * @Description: to give the view of the customer by name
    * @Param: [customerName]
    * @return: java.util.concurrent.CompletableFuture<com.yinxiang.result.ResultView>
    * @Author: Mr.Cheng
    * @Date: 2019/6/1 10:10 PM
    */
    CompletableFuture<ResultView> getCustomerViewByName(String customerName) throws InterruptedException;

    /**
    * @Description: to give the view of the customer by phone
    * @Param: [customerPhone]
    * @return: java.util.concurrent.CompletableFuture<com.yinxiang.result.ResultView>
    * @Author: Mr.Cheng
    * @Date: 2019/6/1 10:09 PM
    */
    CompletableFuture<ResultView> getCustomerViewByPhone(String customerPhone) throws InterruptedException;

    /**
    * @Description: to save the information of the customer and give the result view
    * @Param: [customerInfo]
    * @return: java.util.concurrent.CompletableFuture<com.yinxiang.result.ResultView>
    * @Author: Mr.Cheng
    * @Date: 2019/6/1 10:11 PM
    */
    CompletableFuture<ResultView> saveCustomerView(CustomerInfo customerInfo) throws InterruptedException;

    /**
    * @Description: to change the information of the customer and give the result view
    * @Param: [customerInfo]
    * @return: java.util.concurrent.CompletableFuture<com.yinxiang.result.ResultView>
    * @Author: Mr.Cheng
    * @Date: 2019/6/1 10:13 PM
    */
    CompletableFuture<ResultView> changeCustomerView(CustomerInfo customerInfo,Long customerId) throws InterruptedException;

    /**
    * @Description: to remove the customer and give the result view
    * @Param: [customerId]
    * @return: java.util.concurrent.CompletableFuture<com.yinxiang.result.ResultView>
    * @Author: Mr.Cheng
    * @Date: 2019/6/1 10:27 PM
    */
    CompletableFuture<ResultView> removeCustomerView(Long customerId) throws InterruptedException;
}
