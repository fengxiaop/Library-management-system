package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书出入库
 */
@Data
@TableName(value = "owinfo")
public class Owinfo implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /*药品名称*/
    private String dname;

    /*出库/入库*/
    private String type;

    /*数量*/
    private Integer count;

    /*操作人*/
    private String operator;

    /*操作时间*/
    private Date createtime;
}
