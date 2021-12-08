package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Returngoods;
import com.javaclimb.drug.service.IReturngoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 收到退货相关的controller
 */
@Controller
@RequestMapping(value = "/returngoods")
public class ReturngoodsController {

    @Autowired
    private IReturngoodsService returngoodsService;

    /**
     * 转向收到退货页面
     */
    @RequestMapping
    public String returngoods(){
        return "/returngoods";
    }

    /**
     * 分页查询收到退货列表
     */
    @RequestMapping(value = "/returngoodsQueryPage")
    @ResponseBody
    public Object returngoodsQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<Returngoods> iPage = returngoodsService.selectReturngoodsPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货新增页面
     */
    @RequestMapping(value = "/returngoodsPage")
    public String returngoodsPage(){
        return "/returngoodsPage";
    }

    /**
     * 添加一个收到退货
     */
    @RequestMapping(value = "/returngoodsAdd")
    @ResponseBody
    public Object returngoodsAdd(Returngoods returngoods){
        try{
            int i = returngoodsService.addReturngoods(returngoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货编辑页面
     */
    @RequestMapping(value = "/returngoodsQueryById")
    public String returngoodsQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Returngoods returngoods = returngoodsService.queryReturngoodsById(id);
        model.addAttribute("obj",returngoods);
        return "/returngoodsPage";
    }

    /**
     * 修改一个收到退货
     */
    @RequestMapping(value = "/returngoodsEdit")
    @ResponseBody
    public Object returngoodsEdit(Returngoods returngoods){
        try{
            int i = returngoodsService.editReturngoods(returngoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个收到退货
     */
    @RequestMapping(value = "/returngoodsDelById")
    @ResponseBody
    public Object returngoodsDelById(Integer id){
        try{
            int i = returngoodsService.delReturngoodsById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















