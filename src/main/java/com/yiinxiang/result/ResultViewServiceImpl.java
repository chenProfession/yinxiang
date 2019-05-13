package com.yiinxiang.result;

import com.yiinxiang.customer.CustomerInfo;
import com.yiinxiang.customer.CustomerService;
import com.yiinxiang.enums.ResultEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ordering
 * @Description: To implement Result Service
 * @author: Mr.Cheng
 * @date: 2019/4/2 4:45 PM
 */
@Service
public class ResultViewServiceImpl implements ResultViewService {

    @Autowired
    private CustomerService customerService;

    /**
     * @Description: to give the view of the customer list
     * @return: the view of the customer list
     * @Author: Mr.Cheng
     * @Date: 2019/3/29 8:42 AM
     */
    @Override
    public ResultView getCustomerListView() {

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

        return resultView;
    }

    /**
     * @Description: to give the view of the customer by Id
     * @Param: customer id
     * @return: the view of the customer
     * @Author: Mr.Cheng
     * @Date: 2019/3/29 8:45 AM
     */
    @Override
    public ResultView getCustomerViewById(Long customerId) {

        CustomerInfo customerInfo = customerService.getCustomerByID(customerId);

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
        return resultView;
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
    public ResultView getCustomerViewByName(String customerName) {

        CustomerInfo customerInfo = customerService.getCustomerByName(customerName);

        /** make the result view **/
        ResultView resultView = new ResultView();
        if (customerInfo != null) {
           resultView.setCode(0);
           resultView.setMsg(ResultEnums.SUCCESS.getMessage());
           resultView.setData(customerInfo);
        } else {
            resultView.setCode(11);
            resultView.setMsg(ResultEnums.FAILURE.getMessage());
            resultView.setData(ResultEnums.CUSTOMER_NOT_FOUND_BY_NAME.getMessage());
        }

        return resultView;
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
    public ResultView getCustomerViewByPhone(String customerPhone) {

        CustomerInfo customerInfo = customerService.getCustomerByPhone(customerPhone);

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

        return resultView;
    }

}