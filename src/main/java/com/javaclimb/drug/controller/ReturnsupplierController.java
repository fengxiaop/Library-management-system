package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Returnsupplier;
import com.javaclimb.drug.service.IReturnsupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 退货给供应商相关的controller
 */
@Controller
@RequestMapping(value = "/returnsupplier")
public class ReturnsupplierController {

    @Autowired
    private IReturnsupplierService returnsupplierService;

    /**
     * 转向退货给供应商页面
     */
    @RequestMapping
    public String returnsupplier(){
        return "/returnsupplier";
    }

    /**
     * 分页查询退货给供应商列表
     */
    @RequestMapping(value = "/returnsupplierQueryPage")
    @ResponseBody
    public Object returnsupplierQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<Returnsupplier> iPage = returnsupplierService.selectReturnsupplierPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向退货给供应商新增页面
     */
    @RequestMapping(value = "/returnsupplierPage")
    public String returnsupplierPage(){
        return "/returnsupplierPage";
    }

    /**
     * 添加一个退货给供应商
     */
    @RequestMapping(value = "/returnsupplierAdd")
    @ResponseBody
    public Object returnsupplierAdd(Returnsupplier returnsupplier){
        try{
            int i = returnsupplierService.addReturnsupplier(returnsupplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向退货给供应商编辑页面
     */
    @RequestMapping(value = "/returnsupplierQueryById")
    public String returnsupplierQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Returnsupplier returnsupplier = returnsupplierService.queryReturnsupplierById(id);
        model.addAttribute("obj",returnsupplier);
        return "/returnsupplierPage";
    }

    /**
     * 修改一个退货给供应商
     */
    @RequestMapping(value = "/returnsupplierEdit")
    @ResponseBody
    public Object returnsupplierEdit(Returnsupplier returnsupplier){
        try{
            int i = returnsupplierService.editReturnsupplier(returnsupplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个退货给供应商
     */
    @RequestMapping(value = "/returnsupplierDelById")
    @ResponseBody
    public Object returnsupplierDelById(Integer id){
        try{
            int i = returnsupplierService.delReturnsupplierById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















