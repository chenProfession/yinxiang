package com.yiinxiang.result;


import org.springframework.stereotype.Service;

/**
* @Description: to support the service of the result view
* @Author: Mr.Cheng
* @Date: 2019/3/29 8:40 AM
*/
public interface ResultViewService {

    /**
    * @Description: to give the view of the customer list
    * @return: the view of the customer list
    * @Author: Mr.Cheng
    * @Date: 2019/3/29 8:42 AM
    */
    ResultView getCustomerListView();

    /**
    * @Description: to give the view of the customer by Id
    * @Param: customer id
    * @return: the view of the customer
    * @Author: Mr.Cheng
    * @Date: 2019/3/29 8:45 AM
    */
    ResultView getCustomerViewById(Long customerId);

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
