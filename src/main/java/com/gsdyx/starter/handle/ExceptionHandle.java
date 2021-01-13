package com.gsdyx.starter.handle;

import com.gsdyx.starter.common.Response;
import com.gsdyx.starter.common.enums.ResultEnum;
import com.gsdyx.starter.common.exception.StarterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: GSDYX
 * @Date: 2018/8/29 18:30
 * @Description:
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response handle(Exception e) {
        if (e instanceof StarterException) {
            StarterException starterException = (StarterException) e;
            return new Response(starterException);
        }else {
            log.error("【系统异常】{}", e);
            return new Response(ResultEnum.SYS_ERROR);
        }
    }
}
