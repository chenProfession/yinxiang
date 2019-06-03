package com.yinxiang.customerinfo;

import com.yinxiang.enums.ResultEnums;
import com.yinxiang.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @program: ordering
 * @Description: Implement the service of customer result view
 * @author: Mr.Cheng
 * @date: 2019/5/13 3:28 PM
 */
@Service
@Async("taskExecutor")
public class CustomerResultViewServiceImpl implements CustomerResultViewService{

    @Autowired
    private CustomerService customerService;

    /**
     * @Description: to give the view of the customer list
     * @return: the view of the customer list
     * @Author: Mr.Cheng
     * @Date: 2019/3/29 8:42 AM
     */
    @Override
    public CompletableFuture<ResultView> getCustomerListView() throws InterruptedException{

        List<CustomerInfo> customerInfoList = customerService.findAllCustomers();

        /** make the result view **/
        ResultView resultView = new ResultView();
        if(customerInfoList.size() > 0){
            resultView.setCode(0);
            resultView.setMsg(ResultEnums.SUCCESS.getMessage());
            resultView.setData(customerInfoList);
        } else {
            resultView.setCode(2);
            resultView.setMsg(ResultEnums.FAILURE.getMessage());
            resultView.setData(ResultEnums.CUSTOMER_NOT_EXIST.getMessage());
        }

        return CompletableFuture.completedFuture(resultView);
    }

    /**
     * @Description: to give the view of the customer by Id
     * @Param: customer id
     * @return: the view of the customer
     * @Author: Mr.Cheng
     * @Date: 2019/3/29 8:45 AM
     */
    @Override
    public CompletableFuture<ResultView> getCustomerViewByEmail(String customerEmail) throws InterruptedException{

        CustomerInfo customerInfo = customerService.getCustomerByEmail(customerEmail).get(0);

        /** make the result view **/
        ResultView resultView = new ResultView();
        if(customerInfo != null ){
            resultView.setCode(0);
            resultView.setMsg(ResultEnums.SUCCESS.getMessage());
            resultView.setData(customerInfo);
        } else {
            resultView.setCode(10);
            resultView.setMsg(ResultEnums.FAILURE.getMessage());
            resultView.setData(ResultEnums.CUSTOMER_NOT_EXIST.getMessage());
        }
        return CompletableFuture.completedFuture(resultView);
    }

    /**
     * @param customerName
     * @Description: to give the view of the customer by name
     * @Param: [customerName]
     * @return: com.yiinxiang.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2019/4/4 6:36 PM
     */
    @Override
    public CompletableFuture<ResultView> getCustomerViewByName(String customerName) throws InterruptedException{

        List<CustomerInfo> customerInfoList = customerService.getCustomerByName(customerName);

        /** make the result view **/
        ResultView resultView = new ResultView();
        if (customerInfoList.size() > 0) {
            resultView.setCode(0);
            resultView.setMsg(ResultEnums.SUCCESS.getMessage());
            resultView.setData(customerInfoList);
        } else {
            resultView.setCode(11);
            resultView.setMsg(ResultEnums.FAILURE.getMessage());
            resultView.setData(ResultEnums.CUSTOMER_NOT_FOUND_BY_NAME.getMessage());
        }

        return CompletableFuture.completedFuture(resultView);
    }

    /**
     * @param customerPhone
     * @Description: to give the view of the customer by phone
     * @Param: [customerPhone]
     * @return: com.yiinxiang.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2019/4/4 6:37 PM
     */
    @Override
    public CompletableFuture<ResultView> getCustomerViewByPhone(String customerPhone) throws InterruptedException{

        CustomerInfo customerInfo = customerService.getCustomerByPhone(customerPhone).get(0);

        /** make the result view **/
        ResultView resultView = new ResultView();

        if(customerInfo != null ){
            resultView.setCode(0);
            resultView.setMsg(ResultEnums.SUCCESS.getMessage());
            resultView.setData(customerInfo);
        } else {
            resultView.setCode(12);
            resultView.setMsg(ResultEnums.FAILURE.getMessage());
            resultView.setData(ResultEnums.CUSTOMER_NOT_FOUND_BY_PHONE.getMessage());
        }

        return CompletableFuture.completedFuture(resultView);
    }

    /**
     * @param customerInfo
     * @Description: to save the information of the customer and give the result view
     * @Param: [customerInfo]
     * @return: java.util.concurrent.CompletableFuture<com.yinxiang.result.ResultView>
     * @Author: Mr.Cheng
     * @Date: 2019/6/1 10:11 PM
     */
    @Override
    public CompletableFuture<ResultView> saveCustomerView(CustomerInfo customerInfo) throws InterruptedException {

        /** make the result view **/
        ResultView resultView = new ResultView();
        resultView.setCode(34);
        resultView.setMsg(ResultEnums.FAILURE.getMessage());
        resultView.setData(ResultEnums.CUSTOMER_CAN_NOT_SAVE.getMessage());

        if(customerInfo != null && customerInfo.getCustomerID() == null){
            if(customerService.saveCustomer(customerInfo) == 1){
                resultView.setCode(0);
                resultView.setMsg(ResultEnums.SUCCESS.getMessage());
                resultView.setData(customerInfo);
            }
        }
        return CompletableFuture.completedFuture(resultView);
    }

    /**
     * @param customerInfo
     * @Description: to change the information of the customer and give the result view
     * @Param: [customerInfo]
     * @return: java.util.concurrent.CompletableFuture<com.yinxiang.result.ResultView>
     * @Author: Mr.Cheng
     * @Date: 2019/6/1 10:13 PM
     */
    @Override
    public CompletableFuture<ResultView> changeCustomerView(CustomerInfo customerInfo,
                                                            Long customerId) throws InterruptedException {

        /** make the result view **/
        ResultView resultView = new ResultView();
        resultView.setCode(35);
        resultView.setMsg(ResultEnums.FAILURE.getMessage());
        resultView.setData(ResultEnums.CUSTOMER_CAN_NOT_CHANGE.getMessage());

        if(customerInfo != null && customerInfo.getCustomerID() != null
                && customerService.getCustomerByID(customerId) != null){
            if(customerService.changeCustomer(customerInfo) == 1){
                resultView.setCode(0);
                resultView.setMsg(ResultEnums.SUCCESS.getMessage());
                resultView.setData(customerInfo);
            }
        }
        return CompletableFuture.completedFuture(resultView);
    }

    /**
     * @param customerId
     * @Description: to remove the customer and give the result view
     * @Param: [customerId]
     * @return: java.util.concurrent.CompletableFuture<com.yinxiang.result.ResultView>
     * @Author: Mr.Cheng
     * @Date: 2019/6/1 10:27 PM
     */
    @Override
    public CompletableFuture<ResultView> removeCustomerView(Long customerId) throws InterruptedException {

        /** make the result view **/
        ResultView resultView = new ResultView();
        resultView.setCode(35);
        resultView.setMsg(ResultEnums.FAILURE.getMessage());
        resultView.setData(ResultEnums.CUSTOMER_CAN_NOT_REMOVE.getMessage());

        if(customerId != null){
            if(customerService.removeCustomerByID(customerId) == 1){
                resultView.setCode(0);
                resultView.setMsg(ResultEnums.SUCCESS.getMessage());
                resultView.setData(customerId);
            }
        }
        return CompletableFuture.completedFuture(resultView);
    }

}
