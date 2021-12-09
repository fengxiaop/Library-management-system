package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.User;
import com.javaclimb.drug.service.ISupplierService;
import com.javaclimb.drug.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class User2Controller {
@Autowired
    private IUserService iUserService;
    private ISupplierService supplierService;
    @RequestMapping
    public String user2(){
        return "/user";
    }
    @RequestMapping(value = "/userQueryPage")
    @ResponseBody
    public Object supplierQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<User> iPage = iUserService.selectUserPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向出版社新增页面
     */
    @RequestMapping(value = "/userPage")
    public String userPage(){
        return "/userPage";
    }

    /**
     * 添加一个出版社
     */
    @RequestMapping(value = "/userAdd")
    @ResponseBody
    public Object userAdd(User user){
        try{
            int i = iUserService.addUser(user);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向出版社编辑页面
     */
    @RequestMapping(value = "/userQueryById")
    public String userQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        User user = iUserService.queryUserById(id);
        model.addAttribute("obj",user);
        return "/userPage";
    }

    /**
     * 修改一个出版社
     */
    @RequestMapping(value = "/userEdit")
    @ResponseBody
    public Object userEdit(User user){
        try{
            int i = iUserService.editUser(user);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个出版社
     */
    @RequestMapping(value = "/userDelById")
    @ResponseBody
    public Object userDelById(Integer id){
        try{
            int i = iUserService.delUserById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有出版社
     */
    @RequestMapping(value = "/userList")
    @ResponseBody
    public Object userList(){
        List<User> userList = iUserService.queryUserList();
        return ResultMapUtil.getHashMapList(userList);
    }

}
