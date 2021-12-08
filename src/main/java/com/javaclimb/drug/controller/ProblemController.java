package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Problem;
import com.javaclimb.drug.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 问题药品相关的controller
 */
@Controller
@RequestMapping(value = "/problem")
public class ProblemController {

    @Autowired
    private IProblemService problemService;

    /**
     * 转向问题药品页面
     */
    @RequestMapping
    public String problem(){
        return "/problem";
    }

    /**
     * 分页查询问题药品列表
     */
    @RequestMapping(value = "/problemQueryPage")
    @ResponseBody
    public Object problemQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<Problem> iPage = problemService.selectProblemPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向问题药品新增页面
     */
    @RequestMapping(value = "/problemPage")
    public String problemPage(){
        return "/problemPage";
    }

    /**
     * 添加一个问题药品
     */
    @RequestMapping(value = "/problemAdd")
    @ResponseBody
    public Object problemAdd(Problem problem){
        try{
            problem.setCreatetime(new Date());
            int i = problemService.addProblem(problem);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向问题药品编辑页面
     */
    @RequestMapping(value = "/problemQueryById")
    public String problemQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Problem problem = problemService.queryProblemById(id);
        model.addAttribute("obj",problem);
        return "/problemPage";
    }

    /**
     * 修改一个问题药品
     */
    @RequestMapping(value = "/problemEdit")
    @ResponseBody
    public Object problemEdit(Problem problem){
        try{
            int i = problemService.editProblem(problem);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个问题药品
     */
    @RequestMapping(value = "/problemDelById")
    @ResponseBody
    public Object problemDelById(Integer id){
        try{
            int i = problemService.delProblemById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















