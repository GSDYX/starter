package com.gsdyx.starter.common.enums;

public enum ResultEnum {
    SUCCESS("SUCCESS", "成功"),
    SYS_ERROR("ERROR", "系统异常"),
    ;

    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 指定追加信息
     *
     * @param appendTip 追加提示信息
     * @return 结果信息
     */
    public String getMsg(String appendTip) {
        if (appendTip != null) {
            return msg + "。" + appendTip;
        }
        return msg;
    }
}