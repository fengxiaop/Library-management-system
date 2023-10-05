package com.javaclimb.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.book.entity.Supplier;

import java.util.List;

public interface ISupplierService extends IService<Supplier> {
    public IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param);

    public int addSupplier(Supplier supplier);

    public int editSupplier(Supplier supplier);

    public Supplier querySupplierById(Integer id);

    public int delSupplierById(Integer id);

    public List<Supplier> querySupplierList();
}
