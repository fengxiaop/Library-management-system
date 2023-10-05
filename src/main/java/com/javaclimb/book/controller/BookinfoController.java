package com.javaclimb.book.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.book.common.ResultMapUtil;
import com.javaclimb.book.entity.Bookinfo;
import com.javaclimb.book.service.IbookinfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 图书管理页面
 */
@Controller
@Slf4j
@RequestMapping(value = "/bookinfo")
public class BookinfoController {

    @Autowired
    private IbookinfoService bookinfoService;

    /**
     * 转向图书页面
     */
    @RequestMapping
    public String bookInfo() {
        return "/bookinfo";
    }

    /**
     * 分页查询图书列表
     */
    @RequestMapping(value = "/bookinfoQueryPage")
    @ResponseBody
    public Object bookinfoQueryPage(String param, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        try {
            IPage<Bookinfo> iPage = bookinfoService.selectbookinfoPage(page, limit, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向图书新增页面
     */
    @RequestMapping(value = "/bookinfoPage")
    public String bookinfoPage() {
        return "/bookinfoPage";
    }

    /**
     * 添加一个图书
     */
    @RequestMapping(value = "/bookinfoAdd")
    @ResponseBody
    public Object bookinfoAdd(Bookinfo bookinfo) {
        try {
            int i = bookinfoService.addbookinfo(bookinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 通过id查询图书相关信息
     * 转向图书编辑页面
     */
    @RequestMapping(value = "/bookinfoQueryById")
    public String bookinfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Bookinfo bookinfo = bookinfoService.querybookinfoById(id);
        log.debug("bookinfo:"+bookinfo.toString());
        model.addAttribute("obj", bookinfo);
        return "/bookinfoPage";
    }

    /**
     * 修改一个图书
     */
    @RequestMapping(value = "/bookinfoEdit")
    @ResponseBody
    public Object bookinfoEdit(Bookinfo bookinfo) {
        try {
            int i = bookinfoService.editbookinfo(bookinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个图书
     */
    @RequestMapping(value = "/bookinfoDelById")
    @ResponseBody
    public Object bookinfoDelById(Integer id) {
        try {
            int i = bookinfoService.delbookinfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有图书
     */
    @RequestMapping(value = "/bookinfoList")
    @ResponseBody
    public Object bookinfoList() {
        List<Bookinfo> bookinfoList = bookinfoService.querybookinfoList();
        return ResultMapUtil.getHashMapList(bookinfoList);
    }
}



















