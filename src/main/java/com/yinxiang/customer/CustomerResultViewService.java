package com.yinxiang.customer;

import com.yinxiang.result.ResultView;

import java.util.List;

/**
 * @program: ordering
 * @Description: support service for the view of customer
 * @author: Mr.Cheng
 * @date: 2019/5/13 3:25 PM
 */
public interface CustomerResultViewService {

    /**
     * @Description: to give the view of the customer list
     * @return: the view of the customer list
     * @Author: Mr.Cheng
     * @Date: 2019/3/29 8:42 AM
     */
    ResultView getCustomerListView();

    /**
     * @Description: to give the view of the customer by Email
     * @Param: customer id
     * @return: the view of the customer
     * @Author: Mr.Cheng
     * @Date: 2019/3/29 8:45 AM
     */
    ResultView getCustomerViewByEmail(String customerEmail);

    /**
     * @Description: to give the view of the customer by name
     * @Param: [customerName]
     * @return: com.yiinxiang.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2019/4/4 6:36 PM
     */
    ResultView getCustomerViewByName(String customerName);

    /**
     * @Description: to give the view of the customer by phone
     * @Param: [customerPhone]
     * @return: com.yiinxiang.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2019/4/4 6:37 PM
     */
    ResultView getCustomerViewByPhone(String customerPhone);

}
