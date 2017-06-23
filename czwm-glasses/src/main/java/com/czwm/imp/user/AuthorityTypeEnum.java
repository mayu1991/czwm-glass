package com.czwm.imp.user;

/**
 * Created by apple on 2017/5/21.
 */
public enum AuthorityTypeEnum {
    UNKNOWN(0, "未知"),
    EMPLOYEE(1, "雇员"),
    BOSS(2, "老板"),
    ADMIN(3, "管理员");

    private int key;
    private String desc;

    AuthorityTypeEnum(int key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public int getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByKey(int key) {
        AuthorityTypeEnum[] authorityTypeEnums = AuthorityTypeEnum.values();
        for (AuthorityTypeEnum sexEnum : authorityTypeEnums) {
            if (sexEnum.getKey() == key) {
                return sexEnum.getDesc();
            }
        }
        return UNKNOWN.getDesc();
    }
}
