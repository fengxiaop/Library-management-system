package com.javaclimb.book.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.book.common.ResultMapUtil;
import com.javaclimb.book.entity.Druginfo;
import com.javaclimb.book.service.IDruginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/druginfo")
public class BookinfoController {

    @Autowired
    private IDruginfoService druginfoService;

    /**
     * 转向图书页面
     */
    @RequestMapping
    public String druginfo() {
        return "/druginfo";
    }

    /**
     * 分页查询图书列表
     */
    @RequestMapping(value = "/druginfoQueryPage")
    @ResponseBody
    public Object druginfoQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<Druginfo> iPage = druginfoService.selectDruginfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向图书新增页面
     */
    @RequestMapping(value = "/druginfoPage")
    public String druginfoPage() {
        return "/druginfoPage";
    }

    /**
     * 添加一个图书
     */
    @RequestMapping(value = "/druginfoAdd")
    @ResponseBody
    public Object druginfoAdd(Druginfo druginfo) {
        try {
            int i = druginfoService.addDruginfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向图书编辑页面
     */
    @RequestMapping(value = "/druginfoQueryById")
    public String druginfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Druginfo druginfo = druginfoService.queryDruginfoById(id);
        model.addAttribute("obj", druginfo);
        return "/druginfoPage";
    }

    /**
     * 修改一个图书
     */
    @RequestMapping(value = "/druginfoEdit")
    @ResponseBody
    public Object druginfoEdit(Druginfo druginfo) {
        try {
            int i = druginfoService.editDruginfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个图书
     */
    @RequestMapping(value = "/druginfoDelById")
    @ResponseBody
    public Object druginfoDelById(Integer id) {
        try {
            int i = druginfoService.delDruginfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有图书
     */
    @RequestMapping(value = "/druginfoList")
    @ResponseBody
    public Object druginfoList() {
        List<Druginfo> druginfoList = druginfoService.queryDruginfoList();
        return ResultMapUtil.getHashMapList(druginfoList);
    }
}



















