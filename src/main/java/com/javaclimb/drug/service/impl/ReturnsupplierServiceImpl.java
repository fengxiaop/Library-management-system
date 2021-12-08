package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Returnsupplier;
import com.javaclimb.drug.mapper.ReturnsupplierMapper;
import com.javaclimb.drug.service.IReturnsupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 退货给供应商service实现类
 */
@Service
public class ReturnsupplierServiceImpl extends ServiceImpl<ReturnsupplierMapper, Returnsupplier> implements IReturnsupplierService {

    @Autowired
    private ReturnsupplierMapper returnsupplierMapper;

    /**
     * 分页查询退货给供应商数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-退货给供应商名称
     * @return
     */
    @Override
    public IPage<Returnsupplier> selectReturnsupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Returnsupplier> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Returnsupplier> page = new Page<>(pageNum,pageSize);
        return returnsupplierMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条退货给供应商信息
     *
     * @param returnsupplier
     */
    @Override
    public int addReturnsupplier(Returnsupplier returnsupplier) {
        return returnsupplierMapper.insert(returnsupplier);
    }

    /**
     * 修改一条退货给供应商信息
     *
     * @param returnsupplier
     */
    @Override
    public int editReturnsupplier(Returnsupplier returnsupplier) {
        return returnsupplierMapper.updateById(returnsupplier);
    }

    /**
     * 根据主键id查询一个退货给供应商对象
     *
     * @param id
     * @return
     */
    @Override
    public Returnsupplier queryReturnsupplierById(Integer id) {
        return returnsupplierMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个退货给供应商对象
     *
     * @param id
     * @return
     */
    @Override
    public int delReturnsupplierById(Integer id) {
        return returnsupplierMapper.deleteById(id);
    }

}
