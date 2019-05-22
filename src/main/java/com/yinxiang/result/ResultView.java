package com.yinxiang.result;

import lombok.Data;

/**
 * @program: ordering
 * @Description: return the result according to the service
 * @author: Mr.Cheng
 * @date: 2019/3/29 8:34 AM
 */
@Data
public class ResultView<T> {
    /** code */
    private Integer code;

    /** message */
    private String msg;

    /** content of data */
    private T data;
}
