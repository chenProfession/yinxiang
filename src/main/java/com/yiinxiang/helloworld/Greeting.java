package com.yiinxiang.helloworld;

/**
 * @program: ordering
 * @Description: testing api
 * @author: Mr.Cheng
 * @date: 2019/3/12 4:09 PM
 */
public class Greeting {

    private final long id;
    private final String content;

   /**
    * @Description: testing the greeting api
    * @Param: id and content
    * @Author: Mr.Cheng
    * @Date: 2019/3/12 4:55 PM
    */

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
