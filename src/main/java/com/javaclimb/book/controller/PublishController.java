package com.javaclimb.book.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.book.common.ResultMapUtil;
import com.javaclimb.book.entity.Supplier;
import com.javaclimb.book.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 出版社相关的controller
 */
@Controller
@RequestMapping(value = "/supplier")
public class PublishController {

    @Autowired
    private ISupplierService supplierService;

    /**
     * 转向出版社页面
     */
    @RequestMapping
    public String supplier(){
        return "/supplier";
    }

    /**
     * 分页查询出版社列表
     */
    @RequestMapping(value = "/supplierQueryPage")
    @ResponseBody
    public Object supplierQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<Supplier> iPage = supplierService.selectSupplierPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向出版社新增页面
     */
    @RequestMapping(value = "/supplierPage")
    public String supplierPage(){
        return "/supplierPage";
    }

    /**
     * 添加一个出版社
     */
    @RequestMapping(value = "/supplierAdd")
    @ResponseBody
    public Object supplierAdd(Supplier supplier){
        try{
            supplier.setCreatetime(new Date());
            int i = supplierService.addSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向出版社编辑页面
     */
    @RequestMapping(value = "/supplierQueryById")
    public String supplierQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Supplier supplier = supplierService.querySupplierById(id);
        model.addAttribute("obj",supplier);
        return "/supplierPage";
    }

    /**
     * 修改一个出版社
     */
    @RequestMapping(value = "/supplierEdit")
    @ResponseBody
    public Object supplierEdit(Supplier supplier){
        try{
            int i = supplierService.editSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个出版社
     */
    @RequestMapping(value = "/supplierDelById")
    @ResponseBody
    public Object supplierDelById(Integer id){
        try{
            int i = supplierService.delSupplierById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有出版社
     */
    @RequestMapping(value = "/supplierList")
    @ResponseBody
    public Object supplierList(){
        List<Supplier> supplierList = supplierService.querySupplierList();
        return ResultMapUtil.getHashMapList(supplierList);
    }

}





















