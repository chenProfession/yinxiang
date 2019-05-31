package com.yinxiang.customer;

import com.alibaba.fastjson.JSON;
import com.yinxiang.enums.ResultEnums;
import com.yinxiang.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class CustomerControllerTest {

    @MockBean
    private CustomerResultViewService customerResultViewService;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCustomerList() throws Exception {

        List<CustomerInfo> customerInfoList = new ArrayList<>();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerID(Long.valueOf(0));
        customerInfo.setCustomerName("test");
        customerInfo.setCustomerGender("men");
        customerInfo.setCustomerPhone("12345678913");
        customerInfo.setCustomerEmail("test@test.com");
        customerInfo.setCustomerAddress("this is a test address");
        customerInfoList.add(customerInfo);

        given(this.customerResultViewService.getCustomerListView())
                .willReturn(new ResultView(0, ResultEnums.SUCCESS.getMessage(),customerInfoList));

        String result = this.mvc.perform(get("/customers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info(result);
    }

    @Test
    public void getCustomer() throws Exception {

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerID(Long.valueOf(0));
        customerInfo.setCustomerName("test");
        customerInfo.setCustomerGender("men");
        customerInfo.setCustomerPhone("12345678913");
        customerInfo.setCustomerEmail("test@test.com");
        customerInfo.setCustomerAddress("this is a test address");

        given(this.customerResultViewService.getCustomerViewByEmail("test@test.163.com"))
                .willReturn(new ResultView(0, ResultEnums.SUCCESS.getMessage(),customerInfo));
        given(this.customerResultViewService.getCustomerViewByName("test"))
                .willReturn(new ResultView(0, ResultEnums.SUCCESS.getMessage(),customerInfo));
        given(this.customerResultViewService.getCustomerViewByPhone("12345678913"))
                .willReturn(new ResultView(0, ResultEnums.SUCCESS.getMessage(),customerInfo));

        String result1 = this.mvc.perform(get("/customer").accept(MediaType.APPLICATION_JSON).param("email","test@test.163.com"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        String result2 = this.mvc.perform(get("/customer").accept(MediaType.APPLICATION_JSON).param("name","test"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        String result3 = this.mvc.perform(get("/customer").accept(MediaType.APPLICATION_JSON).param("phone","12345678913"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info(result1);
        log.info(result2);
        log.info(result3);
    }

    @Test
    public void saveCustomer() throws Exception {

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerName("test");
        customerInfo.setCustomerGender("men");
        customerInfo.setCustomerPhone("12345678913");
        customerInfo.setCustomerEmail("test@test.com");
        customerInfo.setCustomerAddress("this is a test address");

        given(this.customerService.saveCustomer(customerInfo)).willReturn(1);
        String result = this.mvc.perform(post("/customers").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(customerInfo)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        log.info(result);
    }

    @Test
    public void changeCustomer() throws Exception {

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerID(Long.valueOf(0));
        customerInfo.setCustomerName("test");
        customerInfo.setCustomerGender("men");
        customerInfo.setCustomerPhone("12345678913");
        customerInfo.setCustomerEmail("test@test.com");
        customerInfo.setCustomerAddress("this is a test address");

        given(customerService.changeCustomer(customerInfo)).willReturn(1);
        given(customerService.getCustomerByID(Long.valueOf(0))).willReturn(customerInfo);

        String result = this.mvc.perform(put("/customer/0").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(customerInfo)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        log.info(result);
    }

    @Test
    public void removeCustomerById() throws Exception {

        given(customerService.removeCustomerByID(Long.valueOf(0))).willReturn(1);

        String result = this.mvc.perform(delete("/customer/0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        log.info(result);
    }

}