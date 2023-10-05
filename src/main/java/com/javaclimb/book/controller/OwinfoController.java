package com.javaclimb.book.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.book.common.ResultMapUtil;
import com.javaclimb.book.entity.Owinfo;
import com.javaclimb.book.service.IOwinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 图书出入库相关的controller
 */
@Controller
@RequestMapping(value = "/owinfo")
public class OwinfoController {

    @Autowired
    private IOwinfoService owinfoService;

    /**
     * 转向图书出入库页面
     */
    @RequestMapping
    public String owinfo() {
        return "/owinfo";
    }

    /**
     * 分页查询图书出入库列表
     */
    @PostMapping(value = "/owinfoQueryPage")
    @ResponseBody
    public Object owinfoQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum,
        @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<Owinfo> iPage = owinfoService.selectOwinfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向图书出入库新增页面
     */
    @RequestMapping(value = "/owinfoPage")
    public String owinfoPage() {
        return "/owinfoPage";
    }

    /**
     * 添加一个图书出入库
     */
    @RequestMapping(value = "/owinfoAdd")
    @ResponseBody
    public Object owinfoAdd(Owinfo owinfo) {
        try {
            owinfo.setCreatetime(new Date());
            int i = owinfoService.addOwinfo(owinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向图书出入库编辑页面
     */
    @RequestMapping(value = "/owinfoQueryById")
    public String owinfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Owinfo owinfo = owinfoService.queryOwinfoById(id);
        model.addAttribute("obj", owinfo);
        return "/owinfoPage";
    }

    /**
     * 修改一个图书出入库
     */
    @RequestMapping(value = "/owinfoEdit")
    @ResponseBody
    public Object owinfoEdit(Owinfo owinfo) {
        try {
            int i = owinfoService.editOwinfo(owinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个图书出入库
     */
    @GetMapping(value = "/owinfoDelById")
    @ResponseBody
    public Object owinfoDelById(@RequestParam Integer id) {

        try {
            int i = owinfoService.delOwinfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}
