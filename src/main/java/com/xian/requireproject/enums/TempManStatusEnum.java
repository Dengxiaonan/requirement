package com.xian.requireproject.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 模板状态0正常1删除
 * @author zw
 * @date 2019/9/17 18:02
 */
public enum TempManStatusEnum {

    NOT_DEL(0,"正常"),
    IS_DEL(1,"删除");
    private final Integer code;
    private  final String name;

    TempManStatusEnum(Integer code, String name){
        this.name = name;
        this.code = code;
    };

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public static Integer getCode(TempManStatusEnum riskEnum) {
        for (TempManStatusEnum m : TempManStatusEnum.values()) {
            if (m.equals(riskEnum)) {
                return m.getCode();
            }
        }
        return null;
    }

    public static String getName(Integer code) {
        for (TempManStatusEnum m : TempManStatusEnum.values()) {
            if (m.getCode().equals(code)) {
                return m.getName();
            }
        }
        return null;
    }

    public static Map<String, String> toMap = new HashMap<String, String>();

    static {
        TempManStatusEnum[] types = TempManStatusEnum.values();
        for (TempManStatusEnum type : types) {
            toMap.put(String.valueOf(type.code), type.name);
        }
    }
}
