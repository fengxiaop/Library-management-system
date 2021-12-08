package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题药品
 */
@Data
@TableName(value = "problem")
public class Problem implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /*药品名称*/
    private String dname;

    /*问题药品数量*/
    private Integer dcount;

    /*药品单价*/
    private Float dprice;

    /*问题原因*/
    private String reason;

    /*操作时间*/
    private Date createtime;
}
