package com.javaclimb.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.book.entity.Saleinfo;
import com.javaclimb.book.mapper.SaleinfoMapper;
import com.javaclimb.book.service.ISaleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleinfoServiceImpl extends ServiceImpl<SaleinfoMapper, Saleinfo> implements ISaleinfoService {

    @Autowired
    private SaleinfoMapper saleinfoMapper;
    @Override
    public IPage<Saleinfo> selectSaleinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Saleinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Saleinfo> page = new Page<>(pageNum,pageSize);
        return saleinfoMapper.selectPage(page,queryWrapper);
    }
    @Override
    public int addSaleinfo(Saleinfo saleinfo) {
        return saleinfoMapper.insert(saleinfo);
    }

    @Override
    public int editSaleinfo(Saleinfo saleinfo) {
        return saleinfoMapper.updateById(saleinfo);
    }

    @Override
    public Saleinfo querySaleinfoById(Integer id) {
        return saleinfoMapper.selectById(id);
    }

    @Override
    public int delSaleinfoById(Integer id) {
        return saleinfoMapper.deleteById(id);
    }

}
