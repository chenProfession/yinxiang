package com.yinxiang.customerinfo;

import com.yinxiang.result.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CustomerResultViewServiceImplTest {

    @Autowired
    private CustomerResultViewService customerResultViewService;

    public void displayResultView(ResultView resultView){
        log.info(resultView.getCode().toString());
        log.info(resultView.getMsg().toString());
        log.info(resultView.getData().toString());
    }

    @Test
    public void getCustomerListView() throws Exception {
        ResultView resultView = customerResultViewService.getCustomerListView().get();
        displayResultView(resultView);
        Assert.assertNotNull(resultView);
    }

    @Test
    public void getCustomerViewByEmail() throws Exception {
        String email = "helloworld@163.com";
        ResultView resultView = customerResultViewService.getCustomerViewByEmail(email).get();
        displayResultView(resultView);
        Assert.assertNotNull(resultView);
    }

    @Test
    public void getCustomerViewByName() throws Exception {
        String name = "hello world";
        ResultView resultView = customerResultViewService.getCustomerViewByName(name).get();
        displayResultView(resultView);
        Assert.assertNotNull(resultView);
    }

    @Test
    public void getCustomerViewByPhone() throws Exception {
        String phone = "123456789";
        ResultView resultView = customerResultViewService.getCustomerViewByPhone(phone).get();
        displayResultView(resultView);
        Assert.assertNotNull(resultView);
    }

}