package com.czwm.intf.cust;

import com.czwm.common.page.Pagination;
import com.czwm.dto.cust.CustDto;
import com.czwm.dto.cust.deal.CustDealResultDto;
import com.czwm.dto.cust.detail.CustDetailDto;
import com.czwm.dto.cust.experience.CustExperienceResultDto;
import com.czwm.dto.cust.experience.CustExperienceResultRequest;
import com.czwm.dto.cust.optometry.CustOptometryResultDto;

import java.util.List;

/**
 * Created by apple on 2017/5/19.
 */
public interface ICustManagerService {
    int insertCustDetail(CustDetailDto custDetailDto);

    int insertCustDealResult(CustDealResultDto custDealResultDto);

    int updateCustDealResult(CustDealResultDto custDealResultDto);

    void saveCustDealResult(CustDealResultDto custDealResultDto);

    CustDealResultDto selectCustDealResultById(Integer custId);

    List<CustDealResultDto> selectCustDealResultByTratorName(String tratorName);

    List<CustDetailDto> selectCustsByConditionPaging(CustDetailDto custDetailDto,
            Pagination pagination);

    List<CustDetailDto> selectCustsByCondition(CustDetailDto custDetailDto);

    List<CustDetailDto> selectCustsByIds(List<Integer> ids);

    List<CustDetailDto> selectCustsByIdsAndStore(List<Integer> ids, List<String> storeIds);

    /**
     * 新增客户检测结果
     *
     * @param custOptometryResultDto 需要录入的客户检测信息
     * @return 插入记录条数
     */
    int insertCustOptometryResult(CustOptometryResultDto custOptometryResultDto);

    /**
     * 保存客户检测结果
     *
     * @param custOptometryResultDto 需要保存的客户检测信息
     * @return 插入记录条数
     */
    int updateCustOptometryResult(CustOptometryResultDto custOptometryResultDto);

    /**
     * 保存客户检测结果（有ID就是编辑，ID为null就是新增）
     *
     * @param custOptometryResultDto 需要录入的客户检测信息
     * @return 插入记录条数
     */
    int saveCustOptometryResult(CustOptometryResultDto custOptometryResultDto);

    /**
     * 根据条件查询客户检测结果（客户检测的次数、客户ID等）
     *
     * @param custOptometryResultDto 查询条件
     * @return 客户检测结果
     */
    List<CustOptometryResultDto> selectCustOptometryResultByCondition(
            CustOptometryResultDto custOptometryResultDto);

    /**
     * 根据条件查询客户检测结果（客户检测的次数、客户ID等）
     *
     * @param custId         客户ID
     * @param experienceType 体验次数
     * @return 客户检测结果
     */
    CustOptometryResultDto selectCustOptometryResult(Integer custId, Byte experienceType);

    /**
     * 新增客户体验结果
     *
     * @param custExperienceResultDto 需要录入的客户体验信息
     */
    void insertCustExperienceResult(CustExperienceResultDto custExperienceResultDto);

    /**
     * 编辑客户体验结果
     *
     * @param custExperienceResultDto 需要录入的客户体验信息
     */
    void updateCustExperienceResult(CustExperienceResultDto custExperienceResultDto);

    /**
     * 保存客户体验结果
     *
     * @param custExperienceResultRequest (1)需要录入的三次客户体验信息
     *                                    (2)客户首日检测数据
     */
    void saveCustExperienceResult(CustExperienceResultRequest custExperienceResultRequest);

    /**
     * 删除客户体验结果
     *
     * @param custId 客户ID
     */
    void deleteCustExperienceResult(Integer custId);

    /**
     * 查询客户体验结果
     *
     * @param custId 客户ID
     * @return 体验结果
     */
    List<CustExperienceResultDto> selectCustExperienceResult(Integer custId);

    /**
     * 查询客户体验结果
     *
     * @param tratorName 接待员姓名
     * @return 体验结果
     */
    List<CustExperienceResultDto> selectCustExperienceResultByTratorName(
            String tratorName);

    /**
     * 查询客户的三次体验记录和第一次检测数据
     *
     * @param custId 客户ID
     * @return 客户的三次体验记录和第一次检测数据
     */
    CustDto selectCustExperienceAndOptometry(Integer custId);

    /**
     * 根据会员ID删除客户信息
     *
     * @param custId 客户信息
     * @return 删除结果
     */
    void deleteByCustId(Integer custId);
}
