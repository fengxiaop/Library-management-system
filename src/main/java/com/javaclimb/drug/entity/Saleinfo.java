package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.javaclimb.drug.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 销售记录
 */
@Data
@TableName(value = "saleinfo")
public class Saleinfo implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /*药品名称*/
    private String dname;

    /*药品编号*/
    private String dnumber;

    /*数量*/
    private Integer count;

    /*金额*/
    private Float total;

    /*操作人*/
    private String operator;

    /*操作时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatetime;

    /*操作时间转换成年月日*/
    public String getOperatetimeStr(){
        return DateUtil.dateConvert(operatetime);
    }
}
