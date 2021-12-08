package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Problem;
import com.javaclimb.drug.mapper.ProblemMapper;
import com.javaclimb.drug.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 问题药品service实现类
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements IProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    /**
     * 分页查询问题药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-问题药品名称
     * @return
     */
    @Override
    public IPage<Problem> selectProblemPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Problem> page = new Page<>(pageNum,pageSize);
        return problemMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条问题药品信息
     *
     * @param problem
     */
    @Override
    public int addProblem(Problem problem) {
        return problemMapper.insert(problem);
    }

    /**
     * 修改一条问题药品信息
     *
     * @param problem
     */
    @Override
    public int editProblem(Problem problem) {
        return problemMapper.updateById(problem);
    }

    /**
     * 根据主键id查询一个问题药品对象
     *
     * @param id
     * @return
     */
    @Override
    public Problem queryProblemById(Integer id) {
        return problemMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个问题药品对象
     *
     * @param id
     * @return
     */
    @Override
    public int delProblemById(Integer id) {
        return problemMapper.deleteById(id);
    }

}
