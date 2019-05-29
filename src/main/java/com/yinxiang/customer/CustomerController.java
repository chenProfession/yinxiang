package com.yinxiang.customer;

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

    @Autowired
    private CustomerService customerService;

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResultView getCustomerList(){
        return customerResultViewService.getCustomerListView();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public ResultView getCustomer(
            @RequestParam(required = false, name = "email", defaultValue = "none") String customerEmail,
            @RequestParam(required = false, name = "name", defaultValue = "none") String customerName,
            @RequestParam(required = false, name = "phone", defaultValue = "none") String customerPhone){

        ResultView resultView = new ResultView();
        resultView.setCode(2);
        resultView.setMsg(ResultEnums.FAILURE.getMessage());

        if(!ResultEnums.NONE.getMessage().equals(customerPhone)){
            resultView = customerResultViewService.getCustomerViewByPhone(customerPhone);
        } else {
            if(!ResultEnums.NONE.getMessage().equals(customerEmail)){
                resultView = customerResultViewService.getCustomerViewByEmail(customerEmail);
            } else {
                if(!ResultEnums.NONE.getMessage().equals(customerName)) {
                    resultView = customerResultViewService.getCustomerViewByName(customerName);
                }
            }
        }

        return resultView;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResultView saveCustomer(@RequestBody @Valid CustomerInfo customerInfo){

        ResultView resultView = new ResultView();
        resultView.setCode(2);
        resultView.setMsg("the information of the customer is illegal");

        if(customerInfo != null && customerInfo.getCustomerID() == null){
            if((customerService.saveCustomer(customerInfo)) == 1){
                resultView.setCode(0);
                resultView.setMsg("customer information has already saved ");
            }
        }
        return resultView;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResultView changeCustomer(@RequestBody @Valid CustomerInfo customerInfo,
                                     @PathVariable("id") @Validated @NotBlank Long customerId){

        ResultView resultView = new ResultView();
        resultView.setCode(2);
        resultView.setMsg("the information of the customer is illegal");

        if(customerInfo != null && customerInfo.getCustomerID() != null
                && customerService.getCustomerByID(customerId) != null){
            if(customerService.changeCustomer(customerInfo) == 1){
                resultView.setCode(0);
                resultView.setMsg("customer information has already changed");
            }
        }
        return resultView;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @Validated
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResultView removeCustomerById(@PathVariable("id") @NotBlank Long customerId){

        ResultView resultView = new ResultView();
        resultView.setCode(2);
        resultView.setMsg("the information of the customer is illegal");

        if(customerService.removeCustomerByID(customerId) == 1){
            resultView.setCode(0);
            resultView.setMsg("customer information has been already removed");
        }
        return resultView;
    }
}
