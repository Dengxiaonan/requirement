package com.xian.requireproject.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 用户删除状态
 * @author zw
 * @date 2019/9/17 18:02
 */
public enum UserStatusEnum {

    NOT_DEL(0,"正常"),
    IS_DEL(1,"已删除");
    private final Integer code;
    private  final String name;

    UserStatusEnum(Integer code, String name){
        this.name = name;
        this.code = code;
    };

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public static Integer getCode(UserStatusEnum riskEnum) {
        for (UserStatusEnum m : UserStatusEnum.values()) {
            if (m.equals(riskEnum)) {
                return m.getCode();
            }
        }
        return null;
    }

    public static String getName(Integer code) {
        for (UserStatusEnum m : UserStatusEnum.values()) {
            if (m.getCode().equals(code)) {
                return m.getName();
            }
        }
        return null;
    }

    public static Map<String, String> toMap = new HashMap<String, String>();

    static {
        UserStatusEnum[] types = UserStatusEnum.values();
        for (UserStatusEnum type : types) {
            toMap.put(String.valueOf(type.code), type.name);
        }
    }
}
