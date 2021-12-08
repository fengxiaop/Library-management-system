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
 * 账单信息
 */
@Data
@TableName(value = "billinfo")
public class Billinfo implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /*供应商名称*/
    private String sname;

    /*药品名称*/
    private String dname;

    /*数量*/
    private Integer count;

    /*总金额*/
    private Float total;

    /*进货时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buytime;

    /*操作时间转换成年月日*/
    public String getBuytimeStr(){
        return DateUtil.dateConvert(buytime);
    }
}
