package com.yinxiang.exceptionhandler;

import com.yinxiang.enums.ResultEnums;
import com.yinxiang.result.ResultView;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: ordering
 * @Description:
 * @author: Mr.Cheng
 * @date: 2019/5/28 7:52 PM
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultView defaultExceptionHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {

        ResultView resultView = new ResultView();
        resultView.setCode(33);
        resultView.setMsg(ResultEnums.SYSTEM_EXCEPTION.getMessage());
        resultView.setData(e.getMessage());

        if(e instanceof MethodArgumentNotValidException){

            FieldError fieldError = ((MethodArgumentNotValidException)e).getBindingResult().getFieldError();
            resultView.setMsg(String.format("%s(%s)",fieldError.getDefaultMessage(),fieldError.getField()));

        } else if(e instanceof ConstraintViolationException){

            String message = ((ConstraintViolationException) e).getConstraintViolations().iterator().next().getMessage();
            resultView.setCode(Integer.valueOf(message.substring(0, 5)));
            resultView.setMsg(message.substring(6));
            resultView.setData(message);

        } else {
            log.error(e.getMessage(),e);
        }

        return resultView;

    }

}
