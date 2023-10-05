package com.javaclimb.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.book.entity.Bookinfo;
import com.javaclimb.book.mapper.BookInfoMapper;
import com.javaclimb.book.service.IbookinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookinfoServiceImpl extends ServiceImpl<BookInfoMapper, Bookinfo> implements IbookinfoService {

    @Autowired
    private BookInfoMapper bookinfoMapper;

    @Override
    public IPage<Bookinfo> selectbookinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Bookinfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<Bookinfo> page = new Page<>(pageNum, pageSize);
        return bookinfoMapper.selectPage(page, queryWrapper);
    }

    @Override
    public int addbookinfo(Bookinfo bookinfo) {
        return bookinfoMapper.insert(bookinfo);
    }

    @Override
    public int editbookinfo(Bookinfo bookinfo) {
        return bookinfoMapper.updateById(bookinfo);
    }

    @Override
    public Bookinfo querybookinfoById(Integer id) {
        return bookinfoMapper.selectById(id);
    }

    @Override
    public int delbookinfoById(Integer id) {
        return bookinfoMapper.deleteById(id);
    }

    @Override
    public List<Bookinfo> querybookinfoList() {
        return bookinfoMapper.selectList(null);
    }
}
