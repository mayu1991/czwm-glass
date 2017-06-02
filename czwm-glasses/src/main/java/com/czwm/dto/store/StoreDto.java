package com.czwm.dto.store;

import com.czwm.dto.BaseDto;

/**
 * 门店bean
 * Created by apple on 2017/5/16.
 */
public class StoreDto extends BaseDto {
    private Integer id;
    private String storeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
