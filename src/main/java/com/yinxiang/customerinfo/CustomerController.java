package com.yinxiang.customerinfo;

import com.yinxiang.enums.ResultEnums;
import com.yinxiang.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
    public ResultView getCustomerList() throws Exception{
        return customerResultViewService.getCustomerListView().get();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public ResultView getCustomer(
            @RequestParam(required = false, name = "email", defaultValue = "none") String customerEmail,
            @RequestParam(required = false, name = "name", defaultValue = "none") String customerName,
            @RequestParam(required = false, name = "phone", defaultValue = "none") String customerPhone) throws Exception{

        ResultView resultView = new ResultView();
        resultView.setCode(2);
        resultView.setMsg(ResultEnums.FAILURE.getMessage());

        if(!ResultEnums.NONE.getMessage().equals(customerPhone)){
            resultView = customerResultViewService.getCustomerViewByPhone(customerPhone).get();
        } else {
            if(!ResultEnums.NONE.getMessage().equals(customerEmail)){
                resultView = customerResultViewService.getCustomerViewByEmail(customerEmail).get();
            } else {
                if(!ResultEnums.NONE.getMessage().equals(customerName)) {
                    resultView = customerResultViewService.getCustomerViewByName(customerName).get();
                }
            }
        }

        return resultView;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResultView saveCustomer(@RequestBody @Valid CustomerInfo customerInfo) throws Exception{

        ResultView resultView = customerResultViewService.saveCustomerView(customerInfo).get();

        return resultView;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResultView changeCustomer(@RequestBody @Valid CustomerInfo customerInfo,
                                     @PathVariable("id") @Validated @NotBlank Long customerId) throws Exception{

        ResultView resultView = customerResultViewService.changeCustomerView(customerInfo,customerId).get();

        return resultView;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @Validated
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResultView removeCustomerById(@PathVariable("id") @NotBlank Long customerId) throws Exception{

        ResultView resultView = customerResultViewService.removeCustomerView(customerId).get();

        return resultView;
    }
}
