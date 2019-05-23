package com.yinxiang.customer;

import com.yinxiang.enums.ResultEnums;
import com.yinxiang.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ordering
 * @Description: support API of customer for the service
 * @author: Mr.Cheng
 * @date: 2019/5/13 3:04 PM
 */
@RestController
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerResultViewService customerResultViewService;

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResultView getCustomerList(){
        return customerResultViewService.getCustomerListView();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public ResultView getCustomer(
            @RequestParam(required = false, value = "none") String customerEmail,
            @RequestParam(required = false, value = "none") String customerName,
            @RequestParam(required = false, value = "none") String customerPhone){
        if(!customerEmail.toString().equals(ResultEnums.NONE.getMessage())){

        }
        return null;
    }
}
