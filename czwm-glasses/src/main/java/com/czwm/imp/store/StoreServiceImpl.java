package com.czwm.imp.store;

import com.czwm.dto.store.StoreDto;
import com.czwm.dto.store.StoreExample;
import com.czwm.intf.store.IStoreService;
import com.czwm.dao.store.IStoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by apple on 2017/5/18.
 */
@Service
public class StoreServiceImpl implements IStoreService {

    @Autowired
    private IStoreDao storeDao;

    public List<StoreDto> getStoreAll() {
        StoreExample example = new StoreExample();
        StoreExample.Criteria criteria = example.createCriteria();

        List<StoreDto> storeDbs = storeDao.selectByExample(example);
        return storeDbs;
    }
}
