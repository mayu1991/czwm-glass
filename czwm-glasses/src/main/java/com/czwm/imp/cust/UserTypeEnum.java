package com.czwm.imp.cust;

/**
 * Created by apple on 2017/5/21.
 */
public enum UserTypeEnum {
    UNKNOWN(0, "未知"),
    ALL(1, "全部"),
    TRATOR(2, "业务员"),
    RECRPTION(3, "接待员"),
    OPTOMETRY(4, "验光师"),
    DEAL(5, "成交员");

    private int key;
    private String desc;

    UserTypeEnum(int key, String desc) {
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
        UserTypeEnum[] userTypeEnums = UserTypeEnum.values();
        for (UserTypeEnum userTypeEnum : userTypeEnums) {
            if (userTypeEnum.getKey() == key) {
                return userTypeEnum.getDesc();
            }
        }
        return UNKNOWN.getDesc();
    }
}
