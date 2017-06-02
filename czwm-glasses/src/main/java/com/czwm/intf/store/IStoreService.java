package com.czwm.intf.store;

import com.czwm.dto.store.StoreDto;

import java.util.List;

/**
 * Created by apple on 2017/5/18.
 */
public interface IStoreService {
    List<StoreDto> getStoreAll();
}
