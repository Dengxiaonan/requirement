package com.xian.requireproject.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 风险跑批-指标类型对应的枚举
 * @author zw
 * @date 2019/9/17 18:02
 */
public enum RequireStatusEnum {

    NO_COMMIT(0,"未提交"),
    WAIT_APPROVE(1,"待审批"),
    ALREADY_APPROVE(2,"已发布"),
    ALREADY_BACK(3,"已退回"),
    REFUSE(4,"拒绝");
    private final Integer code;
    private  final String name;

    RequireStatusEnum(Integer code, String name){
        this.name = name;
        this.code = code;
    };

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public static Integer getCode(RequireStatusEnum riskEnum) {
        for (RequireStatusEnum m : RequireStatusEnum.values()) {
            if (m.equals(riskEnum)) {
                return m.getCode();
            }
        }
        return null;
    }

    public static String getName(Integer code) {
        for (RequireStatusEnum m : RequireStatusEnum.values()) {
            if (m.getCode().equals(code)) {
                return m.getName();
            }
        }
        return null;
    }

    public static Map<String, String> toMap = new HashMap<String, String>();

    static {
        RequireStatusEnum[] types = RequireStatusEnum.values();
        for (RequireStatusEnum type : types) {
            toMap.put(String.valueOf(type.code), type.name);
        }
    }
}
