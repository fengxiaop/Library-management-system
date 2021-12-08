package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.mapper.SupplierMapper;
import com.javaclimb.drug.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 供应商service实现类
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 分页查询供应商数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-供应商名称
     * @return
     */
    @Override
    public IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Supplier> page = new Page<>(pageNum,pageSize);
        return supplierMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条供应商信息
     *
     * @param supplier
     */
    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    /**
     * 修改一条供应商信息
     *
     * @param supplier
     */
    @Override
    public int editSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }

    /**
     * 根据主键id查询一个供应商对象
     *
     * @param id
     * @return
     */
    @Override
    public Supplier querySupplierById(Integer id) {
        return supplierMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个供应商对象
     *
     * @param id
     * @return
     */
    @Override
    public int delSupplierById(Integer id) {
        return supplierMapper.deleteById(id);
    }

    /**
     * 查询所有供应商
     *
     * @return
     */
    @Override
    public List<Supplier> querySupplierList() {
        return supplierMapper.selectList(null);
    }
}
