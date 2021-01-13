package com.gsdyx.starter.common;


import com.gsdyx.starter.common.enums.ResultEnum;
import com.gsdyx.starter.common.exception.StarterException;
import lombok.Data;

import java.io.Serializable;

/**
 * 封装结果对象基类
 *
 * @author liujian
 * @version 2019/11/7
 * @since
 */
@Data
public class Response<T> {
    private String code;
    private String message;
    private T data;

    private Response() {
    }

    public Response(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
    }

    /**
     * 构造方法
     * @param resultCode 结果码
     * @param data 结果数据对象
     */
    public Response(ResultEnum resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = data;
    }

    public Response(T data) {
        this.data = data;
        this.code = ResultEnum.SUCCESS.getCode();
        this.message = ResultEnum.SUCCESS.getMsg();
    }

    /**
     * 构造方法-自动解析异常对象错误信息
     * @param starterException 异常对象
     */
    public Response(StarterException starterException) {
        this.code = starterException.getCode();
        this.message = starterException.getMsg();
    }

}
