package com.czwm.imp.cust;

/**
 * Created by apple on 2017/5/21.
 */
public enum DealFlagEnum {
    UNKNOWN(-1, "未知"),
    UN_SUBMIT(0, "未成交"),
    SUBMIT(1, "成交");

    private int key;
    private String desc;

    DealFlagEnum(int key, String desc) {
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
        DealFlagEnum[] dealEnums = DealFlagEnum.values();
        for (DealFlagEnum dealEnum : dealEnums) {
            if (dealEnum.getKey() == key) {
                return dealEnum.getDesc();
            }
        }
        return UNKNOWN.getDesc();
    }
}
