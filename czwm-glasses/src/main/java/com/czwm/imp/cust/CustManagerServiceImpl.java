package com.czwm.imp.cust;

import com.czwm.common.page.Pagination;
import com.czwm.dao.cust.ICustDealResultDao;
import com.czwm.dao.cust.ICustDetailDao;
import com.czwm.dao.cust.ICustExperienceResultDao;
import com.czwm.dao.cust.ICustOptometryResultDao;
import com.czwm.dto.cust.CustDto;
import com.czwm.dto.cust.deal.CustDealResultDto;
import com.czwm.dto.cust.detail.CustDetailDto;
import com.czwm.dto.cust.detail.CustDetailExample;
import com.czwm.dto.cust.experience.CustExperienceResultDto;
import com.czwm.dto.cust.experience.CustExperienceResultExample;
import com.czwm.dto.cust.experience.CustExperienceResultRequest;
import com.czwm.dto.cust.optometry.CustOptometryResultDto;
import com.czwm.intf.cust.ICustManagerService;
import com.czwm.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 客户管理service
 * Created by apple on 2017/5/19.
 */
@Service
public class CustManagerServiceImpl implements ICustManagerService {

    @Autowired
    private ICustDetailDao custDetaiDao;

    @Autowired
    private ICustDealResultDao dealResultDao;

    @Autowired
    private ICustOptometryResultDao optometryResultDao;

    @Autowired
    private ICustExperienceResultDao experienceResultDao;

    /**
     * 新增客户信息
     *
     * @param custDetailDto 客户入参
     * @return 新增结果条数
     */
    public int insertCustDetail(CustDetailDto custDetailDto) {
        custDetailDto.setCreatedTime(new Date());
        custDetailDto.setLastUpdatedTime(new Date());
        return custDetaiDao.insertSelective(custDetailDto);
    }

    /**
     * 新增客户客户成交信息
     *
     * @param custDealResultDto 客户成交信息入参
     * @return 新增结果条数
     */
    public int insertCustDealResult(CustDealResultDto custDealResultDto) {
        custDealResultDto.setCreatedTime(new Date());
        custDealResultDto.setLastUpdatedTime(new Date());
        return dealResultDao.insertSelective(custDealResultDto);
    }

    /**
     * 更新客户客户成交信息
     *
     * @param custDealResultDto 客户成交信息入参
     * @return 新增结果条数
     */
    public int updateCustDealResult(CustDealResultDto custDealResultDto) {
        custDealResultDto.setLastUpdatedTime(new Date());
        return dealResultDao.updateByPrimaryKeySelective(custDealResultDto);
    }

    /**
     * 保存客户客户成交信息
     *
     * @param custDealResultDto 客户成交信息入参
     * @return 新增结果条数
     */
    public void saveCustDealResult(CustDealResultDto custDealResultDto) {
        if (custDealResultDto.getId() != null && custDealResultDto.getId() > -1) {
            updateCustDealResult(custDealResultDto);
        } else {
            insertCustDealResult(custDealResultDto);
        }
        CustDetailDto custDetailDto = new CustDetailDto();
        custDetailDto.setId(custDealResultDto.getCustId());
        custDetailDto.setDealFlag(custDealResultDto.getDealResultType());//0：否 1：是
        //更新客户详情中的成交记录
        custDetaiDao.updateByPrimaryKeySelective(custDetailDto);
    }

    /**
     * 查询客户列表
     *
     * @param custDetailDto 客户查询条件
     * @param pagination    分页属性
     * @return 客户列表
     */
    public List<CustDetailDto> selectCustsByConditionPaging(CustDetailDto custDetailDto,
            Pagination pagination) {
        List<CustDetailDto> custDetailDbs = custDetaiDao
                .selectByConditionPaging(custDetailDto, pagination);
        if (!CollectionUtils.isEmpty(custDetailDbs)) {
            for (CustDetailDto custDetailDb : custDetailDbs) {
                custDetailDb.setSexDesc(SexEnum.getDescByKey(custDetailDb.getSex()));
            }
        }
        return custDetailDbs;
    }

    /**
     * 查询客户列表
     *
     * @param custDetailDto 客户查询条件
     * @return 客户列表
     */
    public List<CustDetailDto> selectCustsByCondition(CustDetailDto custDetailDto) {
        List<CustDetailDto> custDetailDbs = custDetaiDao.selectByCondition(custDetailDto);
        if (!CollectionUtils.isEmpty(custDetailDbs)) {
            for (CustDetailDto custDetailDb : custDetailDbs) {
                custDetailDb.setSexDesc(SexEnum.getDescByKey(custDetailDb.getSex()));
                custDetailDb.setDealFlagDesc(DealFlagEnum.getDescByKey(custDetailDb.getDealFlag()));
            }
        }
        return custDetailDbs;
    }

    /**
     * 查询客户成交记录
     *
     * @param custId 客户ID
     * @return 客户列表
     */
    public CustDealResultDto selectCustDealResultById(Integer custId) {
        return dealResultDao.selectByCustId(custId);
    }

    /**
     * 查询客户成交记录
     *
     * @param tratorName 成交员姓名
     * @return 客户列表
     */
    public List<CustDealResultDto> selectCustDealResultByTratorName(String tratorName) {
        CustDealResultDto custDealResultDto = new CustDealResultDto();
        custDealResultDto.setDealTratorName(tratorName);
        custDealResultDto.setDelFlag((byte) 0);
        return dealResultDao.selectByConditions(custDealResultDto);
    }

    /**
     * {@inheritDoc}
     */
    public int insertCustOptometryResult(CustOptometryResultDto custOptometryResultDto) {
        custOptometryResultDto.setCreatedTime(new Date());
        custOptometryResultDto.setLastUpdatedTime(new Date());
        return optometryResultDao.insertSelective(custOptometryResultDto);
    }

    /**
     * {@inheritDoc}
     */
    public int updateCustOptometryResult(CustOptometryResultDto custOptometryResultDto) {
        custOptometryResultDto.setLastUpdatedTime(new Date());
        return optometryResultDao.updateByPrimaryKeySelective(custOptometryResultDto);
    }

    /**
     * {@inheritDoc}
     */
    public int saveCustOptometryResult(CustOptometryResultDto custOptometryResultDto) {
        if (!StringUtils.isBlank(custOptometryResultDto.getAppointmentTimeStr())) {
            custOptometryResultDto.setAppointmentTime(DateUtils
                    .formatDateFromYYYY_MM_DD_T_HH_MM(
                            custOptometryResultDto.getAppointmentTimeStr()));
        }
        if (!StringUtils.isBlank(custOptometryResultDto.getOptometryTimeStr())) {
            custOptometryResultDto.setOptometryTime(DateUtils
                    .formatDateFromYYYY_MM_DD_T_HH_MM(
                            custOptometryResultDto.getOptometryTimeStr()));
        }
        if (!StringUtils.isBlank(custOptometryResultDto.getExperienceTimeStr())) {
            custOptometryResultDto.setExperienceTime(DateUtils
                    .formatDateFromYYYY_MM_DD_T_HH_MM(
                            custOptometryResultDto.getExperienceTimeStr()));
        }
        if (custOptometryResultDto.getId() != null && custOptometryResultDto.getId() > -1) {
            return updateCustOptometryResult(custOptometryResultDto);
        } else {
            return insertCustOptometryResult(custOptometryResultDto);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void insertCustExperienceResult(CustExperienceResultDto custExperienceResultDto) {
        custExperienceResultDto.setCreatedTime(new Date());
        custExperienceResultDto.setLastUpdatedTime(new Date());
        experienceResultDao.insertSelective(custExperienceResultDto);
    }

    /**
     * {@inheritDoc}
     */
    public void updateCustExperienceResult(CustExperienceResultDto custExperienceResultDto) {
        custExperienceResultDto.setCreatedTime(new Date());
        custExperienceResultDto.setLastUpdatedTime(new Date());
        experienceResultDao.updateByPrimaryKeySelective(custExperienceResultDto);
    }

    /**
     * {@inheritDoc}
     */
    public void saveCustExperienceResult(CustExperienceResultRequest custExperienceResultRequest) {

        List<CustExperienceResultDto> custExperienceResults = custExperienceResultRequest
                .getExperiences();

        if (!CollectionUtils.isEmpty(custExperienceResults)) {
            //先删除客户体验记录
            deleteCustExperienceResult(custExperienceResultRequest.getCustId());

            for (CustExperienceResultDto custExperienceResultDto : custExperienceResults) {

                if (StringUtils.isNotBlank(custExperienceResultDto.getAppointmentTimeStr())) {
                    custExperienceResultDto.setAppointmentTime(DateUtils
                            .formatDateFromYYYY_MM_DD_T_HH_MM(
                                    custExperienceResultDto.getAppointmentTimeStr()));
                }
                if (StringUtils.isNotBlank(custExperienceResultDto.getExperienceTimeStr())) {
                    custExperienceResultDto.setExperienceTime(DateUtils
                            .formatDateFromYYYY_MM_DD_T_HH_MM(
                                    custExperienceResultDto.getExperienceTimeStr()));
                }

                //再重新保存客户体验记录
                if (custExperienceResultDto.getId() != null
                        && custExperienceResultDto.getId() > -1) {
                    updateCustExperienceResult(custExperienceResultDto);
                } else {
                    insertCustExperienceResult(custExperienceResultDto);
                }
            }

        }

        //保存第一次体检记录
        saveCustOptometryResult(custExperienceResultRequest.getOptometry());

    }

    /**
     * {@inheritDoc}
     */
    public List<CustOptometryResultDto> selectCustOptometryResultByCondition(
            CustOptometryResultDto custOptometryResultDto) {
        custOptometryResultDto.setDelFlag((byte) 0);
        return optometryResultDao.selectByConditions(custOptometryResultDto);
    }

    /**
     * {@inheritDoc}
     */
    public CustOptometryResultDto selectCustOptometryResult(Integer custId, Byte experienceType) {
        CustOptometryResultDto custOptometryResultDto = new CustOptometryResultDto();
        custOptometryResultDto.setCustId(custId);
        custOptometryResultDto.setExperienceType(experienceType);
        //查询检测记录
        List<CustOptometryResultDto> optometryResultDbs = selectCustOptometryResultByCondition(
                custOptometryResultDto);
        if (!CollectionUtils.isEmpty(optometryResultDbs)) {
            CustOptometryResultDto optometryResultDb = optometryResultDbs.get(0);
            optometryResultDb.setOptometryTimeStr(DateUtils
                    .formatDate2YYYY_MM_DD_T_HH_MM(optometryResultDb.getOptometryTime()));
            optometryResultDb.setExperienceTimeStr(DateUtils
                    .formatDate2YYYY_MM_DD_T_HH_MM(optometryResultDb.getExperienceTime()));
            optometryResultDb.setAppointmentTimeStr(DateUtils
                    .formatDate2YYYY_MM_DD_T_HH_MM(optometryResultDb.getAppointmentTime()));
            return optometryResultDb;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void deleteCustExperienceResult(Integer custId) {
        CustExperienceResultExample example = new CustExperienceResultExample();
        CustExperienceResultExample.Criteria criteria = example.createCriteria();
        criteria.andCustIdEqualTo(custId);
        experienceResultDao.deleteByExample(example);
    }

    /**
     * {@inheritDoc}
     */
    public List<CustExperienceResultDto> selectCustExperienceResult(Integer custId) {
        CustExperienceResultExample experienceResultExample = new CustExperienceResultExample();
        experienceResultExample.createCriteria().andCustIdEqualTo(custId);
        return experienceResultDao.selectByExample(experienceResultExample);
    }

    /**
     * {@inheritDoc}
     */
    public List<CustExperienceResultDto> selectCustExperienceResultByTratorName(
            String tratorName) {
        CustExperienceResultDto custExperienceResultDto = new CustExperienceResultDto();
        custExperienceResultDto.setReceptionName(tratorName);
        custExperienceResultDto.setDelFlag((byte) 0);
        return experienceResultDao.selectByConditions(custExperienceResultDto);
    }

    /**
     * {@inheritDoc}
     */
    public CustDto selectCustExperienceAndOptometry(Integer custId) {
        CustExperienceResultExample experienceResultExample = new CustExperienceResultExample();
        experienceResultExample.createCriteria().andCustIdEqualTo(custId);
        List<CustExperienceResultDto> custExperienceResultDbs = experienceResultDao
                .selectByExample(experienceResultExample);

        //体验记录
        CustDto custDto = new CustDto();
        if (!CollectionUtils.isEmpty(custExperienceResultDbs)) {
            for (CustExperienceResultDto custExperienceResultDto : custExperienceResultDbs) {
                custExperienceResultDto.setAppointmentTimeStr(DateUtils
                        .formatDate2YYYY_MM_DD_T_HH_MM(
                                custExperienceResultDto.getAppointmentTime()));
                custExperienceResultDto.setExperienceTimeStr(DateUtils
                        .formatDate2YYYY_MM_DD_T_HH_MM(
                                custExperienceResultDto.getExperienceTime()));
                switch (custExperienceResultDto.getExperienceFrequency()) {
                case 1:
                    custDto.setFirstExperienceResult(custExperienceResultDto);
                    break;
                case 2:
                    custDto.setSecondExperienceResult(custExperienceResultDto);
                    break;
                case 3:
                    custDto.setThirdExperienceResult(custExperienceResultDto);
                    break;
                }
            }
        }
        //首次检测数据
//        CustOptometryResultExample custOptometryResultExample = new CustOptometryResultExample();
//        custOptometryResultExample.createCriteria().andExperienceTypeEqualTo((byte)1);
        CustOptometryResultDto custOptometryResultDb = selectCustOptometryResult(custId, (byte) 1);
        custDto.setFirstOptometryResult(custOptometryResultDb);
        return custDto;
    }

    /**
     * 删除客户信息
     *
     * @param custId 客户信息
     */
    public void deleteByCustId(Integer custId) {
        custDetaiDao.deleteByCustId(custId);
        dealResultDao.deleteByCustId(custId);
        optometryResultDao.deleteByCustId(custId);
        experienceResultDao.deleteByCustId(custId);
    }

    public List<CustDetailDto> selectCustsByIds(List<Integer> ids) {
        CustDetailExample custDetailExample = new CustDetailExample();
        custDetailExample.createCriteria().andIdIn(ids);
        return custDetaiDao.selectByExample(custDetailExample);
    }

    public List<CustDetailDto> selectCustsByIdsAndStore(List<Integer> ids, List<String> storeIds) {
        CustDetailExample custDetailExample = new CustDetailExample();
        custDetailExample.createCriteria().andIdIn(ids).andStoreIdIn(storeIds);
        return custDetaiDao.selectByExample(custDetailExample);
    }

}
