package com.czwm.controller.cust;

import com.czwm.common.HttpBaseResponse;
import com.czwm.dto.cust.CustDto;
import com.czwm.dto.cust.deal.CustDealResultDto;
import com.czwm.dto.cust.detail.CustDetailDto;
import com.czwm.dto.cust.detail.CustQueryRequest;
import com.czwm.dto.cust.experience.CustExperienceResultDto;
import com.czwm.dto.cust.experience.CustExperienceResultRequest;
import com.czwm.dto.cust.optometry.CustOptometryResultDto;
import com.czwm.imp.cust.UserTypeEnum;
import com.czwm.intf.cust.ICustManagerService;
import com.czwm.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 客户管理控制器
 * Created by apple on 2017/5/19.
 */
@Controller
@RequestMapping(value = "cust")
public class CustController {

    @Autowired
    private ICustManagerService custManagerService;

    /**
     * 保存客户详细信息
     */
    @RequestMapping(value = "/detail/save", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse saveDetail(CustDetailDto custDetailDto) {

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);
        //保存客户详细信息
        int result = custManagerService.insertCustDetail(custDetailDto);
        response.setData(result);
        return response;
    }

    /**
     * 查询客户列表
     */
    @RequestMapping(value = "/detail/list/query", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse queryList(HttpServletRequest request) {

        String requestStr = request.getParameter("custQueryRequest");

        CustQueryRequest custQueryRequest = JsonUtils.toBean(requestStr, CustQueryRequest.class);

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);
        //客户列表
        Set<Integer> custIdSet = new HashSet<Integer>();
        List<CustDetailDto> custDetailDbs = new ArrayList<CustDetailDto>();

        if (UserTypeEnum.TRATOR.getKey() == custQueryRequest.getCustType()) {
            //业务员
            CustDetailDto custDetailDto = new CustDetailDto();
            custDetailDto.setDealTratorName(custQueryRequest.getTratorName());
            custDetailDto.setDealFlag((byte) 0);
            custDetailDbs = custManagerService
                    .selectCustsByCondition(custDetailDto);
        } else if (UserTypeEnum.OPTOMETRY.getKey() == custQueryRequest.getCustType()) {
            //验光师
            CustOptometryResultDto custOptometryResultDto = new CustOptometryResultDto();
            custOptometryResultDto.setReceptionName(custQueryRequest.getTratorName());
            List<CustOptometryResultDto> optometryResultDtos = custManagerService
                    .selectCustOptometryResultByCondition(
                            custOptometryResultDto);
            if (!CollectionUtils.isEmpty(optometryResultDtos)) {
                for (CustOptometryResultDto custOptometryResultDb : optometryResultDtos) {
                    custIdSet.add(custOptometryResultDb.getCustId());
                }
            }

        } else if (UserTypeEnum.RECRPTION.getKey() == custQueryRequest.getCustType()) {
            //接待员
            List<CustExperienceResultDto> experienceResultDtos = custManagerService
                    .selectCustExperienceResultByTratorName(custQueryRequest.getTratorName());

            if (!CollectionUtils.isEmpty(experienceResultDtos)) {
                for (CustExperienceResultDto experienceResultDb : experienceResultDtos) {
                    custIdSet.add(experienceResultDb.getCustId());
                }
            }

        } else if (UserTypeEnum.DEAL.getKey() == custQueryRequest.getCustType()) {
            //成交员
            List<CustDealResultDto> dealResultDbs = custManagerService
                    .selectCustDealResultByTratorName(custQueryRequest.getTratorName());

            if (!CollectionUtils.isEmpty(dealResultDbs)) {
                for (CustDealResultDto custDealResultDto : dealResultDbs) {
                    custIdSet.add(custDealResultDto.getCustId());
                }
            }
        }
        if (!CollectionUtils.isEmpty(custIdSet)) {
            List<Integer> custIds = new ArrayList<Integer>();
            custIds.addAll(custIdSet);
            custDetailDbs = custManagerService
                    .selectCustsByIds(custIds);
        }

        response.setData(custDetailDbs);
        return response;
    }

    /**
     * 查询客户信息
     */
    @RequestMapping(value = "/all/get", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse getAll() {

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);
        //查询所有客户
        List<CustDetailDto> custDetailDbs = custManagerService
                .selectCustsByCondition(new CustDetailDto());
        if (!CollectionUtils.isEmpty(custDetailDbs)) {
            response.setData(custDetailDbs);
        }

        return response;
    }

    /**
     * 查询客户信息
     */
    @RequestMapping(value = "/detail/query/{custId}", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse queryDetail(@PathVariable Integer custId) {

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);
        //查询客户详细信息
        CustDetailDto custDetailDto = new CustDetailDto();
        custDetailDto.setId(custId);
        List<CustDetailDto> custDetailDbs = custManagerService
                .selectCustsByCondition(custDetailDto);
        if (!CollectionUtils.isEmpty(custDetailDbs)) {
            response.setData(custDetailDbs.get(0));
        }

        return response;
    }

    /**
     * 查询客户成交信息
     */
    @RequestMapping(value = "/deal/query/{custId}", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse queryDeal(@PathVariable Integer custId) {

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);
        //保存客户成交信息
        CustDealResultDto custDealResultDto = custManagerService.selectCustDealResultById(custId);
        response.setData(custDealResultDto);
        return response;
    }

    /**
     * 保存、提交客户体验信息
     */
    @RequestMapping(value = "/experience/save", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse saveExperience(HttpServletRequest request) {

        CustExperienceResultRequest custExperienceResultRequest = new CustExperienceResultRequest();
        String optometry = request.getParameter("optometry");
        String experiences = request.getParameter("experiences");
        String custId = request.getParameter("custId");

        CustOptometryResultDto optometryResultDto = JsonUtils
                .toBean(optometry, CustOptometryResultDto.class);
        List<CustExperienceResultDto> experienceDtos = JsonUtils
                .toList(experiences, CustExperienceResultDto.class);
        custExperienceResultRequest.setOptometry(optometryResultDto);
        custExperienceResultRequest.setExperiences(experienceDtos);
        custExperienceResultRequest.setCustId(Integer.parseInt(custId));

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);
        if (custExperienceResultRequest == null) {
            response.setSuccess(false);
            response.setMessage("入参不可为空");
            return response;
        }

        try {
            //保存客户体验信息
            custManagerService.saveCustExperienceResult(custExperienceResultRequest);
            response.setData(custExperienceResultRequest);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("系统异常");
        }
        return response;
    }

    /**
     * 查询客户三次体验信息和第一次检测信息
     */
    @RequestMapping(value = "/experience/query/{custId}", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse queryExperience(@PathVariable Integer custId) {

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);

        try {
            CustDto custDto = custManagerService.selectCustExperienceAndOptometry(custId);
            response.setData(custDto);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("系统异常");
        }
        return response;
    }

    /**
     * 查询客户检测结果
     */
    @RequestMapping(value = "/optometry/query", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse queryOptometry(CustOptometryResultDto custOptometryResultDto) {

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);

        try {
            CustOptometryResultDto optometryResultDto = custManagerService
                    .selectCustOptometryResult(custOptometryResultDto.getCustId(),
                            custOptometryResultDto.getExperienceType());

            response.setData(optometryResultDto);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("系统异常");
        }
        return response;
    }

    /**
     * 保存、提交客户检测信息
     */
    @RequestMapping(value = "/optometry/save", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse saveOptometry(HttpServletRequest request) {

        String params = request.getParameter("optometry");

        CustOptometryResultDto custOptometryResultDto = JsonUtils
                .toBean(params, CustOptometryResultDto.class);

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);
        if (custOptometryResultDto == null) {
            response.setSuccess(false);
            response.setMessage("入参不可为空");
            return response;
        }

        try {
            //保存客户检测信息
            custManagerService.saveCustOptometryResult(custOptometryResultDto);
            response.setData(custOptometryResultDto);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("系统异常");
        }
        return response;
    }

    /**
     * 保存、提交客户成交信息
     */
    @RequestMapping(value = "/deal/save", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody

    public HttpBaseResponse saveDeal(HttpServletRequest request) {
        String params = request.getParameter("deal");

        CustDealResultDto dealResultDto = JsonUtils.toBean(params, CustDealResultDto.class);
        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);
        if (dealResultDto == null) {
            response.setSuccess(false);
            response.setMessage("提交客户成交记录失败，入参不可为空");
            return response;
        }
        if (dealResultDto.getSubmitFlag() != null && StringUtils
                .isEmpty(dealResultDto.getDealTratorName())) {
            response.setSuccess(false);
            response.setMessage("请输入成交员姓名");
            return response;
        }
        if (dealResultDto.getSubmitFlag() != null && (dealResultDto.getDealResultType() == null
                || dealResultDto.getDealResultType() == -1)) {
            response.setSuccess(false);
            response.setMessage("成交情况必须要选择");
            return response;
        }
        //保存客户成交信息
        custManagerService.saveCustDealResult(dealResultDto);
        response.setData(dealResultDto);
        return response;
    }

    /**
     * 删除客户信息
     */
    @RequestMapping(value = "/delete/{custId}", method = {
            RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse deleteById(@PathVariable Integer custId) {

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);

        if (custId == null || custId.equals(-1)) {
            response.setSuccess(false);
            response.setMessage("删除失败，客户ID必须输入");
            return response;
        }

        //删除客户成交信息
        custManagerService.deleteByCustId(custId);
        response.setData(custId);
        return response;
    }

}
