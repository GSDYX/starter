package com.gsdyx.starter.common.exception;

import com.gsdyx.starter.common.enums.ResultEnum;
import lombok.Data;

@Data
public class StarterException extends RuntimeException {

    private String code;

    private String msg;


    public StarterException(ResultEnum resultEnum) {
        super(getErrorMsg(resultEnum));

        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    /**
     * 只指定结果码的业务异常抛出，通常是业务性检查异常
     * @param resultEnum 结果码
     * @param errorTip 结果信息追加提示信息
     */
    public StarterException(ResultEnum resultEnum, String errorTip) {
        super(getErrorMsg(resultEnum, errorTip));

        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg(errorTip);
    }

    /**
     * 指定捕捉到的异常类抛出特定异常
     * @param throwable 异常对象
     * @param resultEnum 结果码
     */
    public StarterException(Throwable throwable, ResultEnum resultEnum) {
        super(getErrorMsg(resultEnum), throwable);

        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    /**
     * 指定捕捉到的异常类抛出特定异常
     * @param throwable 异常对象
     * @param resultEnum 结果码
     * @param appendTip 结果提示追加信息
     */
    public StarterException(Throwable throwable, ResultEnum resultEnum, String appendTip) {
        super(getErrorMsg(resultEnum, appendTip), throwable);

        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg(appendTip);
    }

    private static String getErrorMsg(ResultEnum resultEnum) {
        return String.format("错误码：%s。错误信息：%s", resultEnum.getCode(), resultEnum.getMsg());
    }

    private static String getErrorMsg(ResultEnum resultEnum, String appendTip) {
        return String.format("错误码：%s。错误信息：%s", resultEnum.getCode(), resultEnum.getMsg(appendTip));
    }
}