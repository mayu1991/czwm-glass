package com.czwm.imp.cust;

/**
 * Created by apple on 2017/5/21.
 */
public enum SexEnum {
    UNKNOWN(0, "未知"),
    FEMALE(2, "女"),
    MALE(1, "男"),
    OTHERS(3, "其他");

    private int key;
    private String desc;

    SexEnum(int key, String desc) {
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
        SexEnum[] sexEnums = SexEnum.values();
        for (SexEnum sexEnum : sexEnums) {
            if (sexEnum.getKey() == key) {
                return sexEnum.getDesc();
            }
        }
        return UNKNOWN.getDesc();
    }
}
