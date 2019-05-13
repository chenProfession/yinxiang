package com.yiinxiang.result;

import com.yiinxiang.enums.ResultEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ordering
 * @Description:
 * @author: Mr.Cheng
 * @date: 2019/4/2 8:54 PM
 */

@RestController
@Slf4j
public class ResultViewController {

    @Autowired
    private ResultViewService resultViewService;

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResultView getCustomerList(){
        return resultViewService.getCustomerListView();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public ResultView getCustomer(
            @RequestParam(required = false, value = "none") Long customerId,
            @RequestParam(required = false, value = "none") String customerName,
            @RequestParam(required = false, value = "none") String customerPhone){
        if(!customerId.toString().equals(ResultEnums.NONE.getMessage())){

        }
        return null;
    }

}
