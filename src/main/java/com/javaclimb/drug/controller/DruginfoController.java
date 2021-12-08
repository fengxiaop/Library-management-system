package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.service.IDruginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 药品相关的controller
 */
@Controller
@RequestMapping(value = "/druginfo")
public class DruginfoController {

    @Autowired
    private IDruginfoService druginfoService;

    /**
     * 转向药品页面
     */
    @RequestMapping
    public String druginfo(){
        return "/druginfo";
    }

    /**
     * 分页查询药品列表
     */
    @RequestMapping(value = "/druginfoQueryPage")
    @ResponseBody
    public Object druginfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<Druginfo> iPage = druginfoService.selectDruginfoPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品新增页面
     */
    @RequestMapping(value = "/druginfoPage")
    public String druginfoPage(){
        return "/druginfoPage";
    }

    /**
     * 添加一个药品
     */
    @RequestMapping(value = "/druginfoAdd")
    @ResponseBody
    public Object druginfoAdd(Druginfo druginfo){
        try{
            int i = druginfoService.addDruginfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品编辑页面
     */
    @RequestMapping(value = "/druginfoQueryById")
    public String druginfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Druginfo druginfo = druginfoService.queryDruginfoById(id);
        model.addAttribute("obj",druginfo);
        return "/druginfoPage";
    }

    /**
     * 修改一个药品
     */
    @RequestMapping(value = "/druginfoEdit")
    @ResponseBody
    public Object druginfoEdit(Druginfo druginfo){
        try{
            int i = druginfoService.editDruginfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品
     */
    @RequestMapping(value = "/druginfoDelById")
    @ResponseBody
    public Object druginfoDelById(Integer id){
        try{
            int i = druginfoService.delDruginfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有药品
     */
    @RequestMapping(value = "/druginfoList")
    @ResponseBody
    public Object druginfoList(){
        List<Druginfo> druginfoList = druginfoService.queryDruginfoList();
        return ResultMapUtil.getHashMapList(druginfoList);
    }

    /**
     * 转向药品保质期检查页面
     */
    @RequestMapping(value = "/warranty")
    public String warranty(){
        return "/warranty";
    }
}





















