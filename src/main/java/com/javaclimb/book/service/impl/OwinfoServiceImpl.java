package com.javaclimb.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.book.entity.Owinfo;
import com.javaclimb.book.mapper.OwinfoMapper;
import com.javaclimb.book.service.IOwinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwinfoServiceImpl extends ServiceImpl<OwinfoMapper, Owinfo> implements IOwinfoService {

    @Autowired
    private OwinfoMapper owinfoMapper;

    @Override
    public IPage<Owinfo> selectOwinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Owinfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<Owinfo> page = new Page<>(pageNum, pageSize);
        return owinfoMapper.selectPage(page, queryWrapper);
    }

    @Override
    public int addOwinfo(Owinfo owinfo) {
        return owinfoMapper.insert(owinfo);
    }

    @Override
    public int editOwinfo(Owinfo owinfo) {
        return owinfoMapper.updateById(owinfo);
    }

    @Override
    public Owinfo queryOwinfoById(Integer id) {
        return owinfoMapper.selectById(id);
    }

    @Override
    public int delOwinfoById(Integer id) {
        return owinfoMapper.deleteById(id);
    }

}
