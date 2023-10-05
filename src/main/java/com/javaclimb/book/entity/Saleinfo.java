package com.javaclimb.book.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.javaclimb.book.common.DateUtil;
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

    private String dname;

    private String dnumber;

    private Integer count;

    private Float total;

    private String operator;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatetime;

    public String getOperatetimeStr(){
        return DateUtil.dateConvert(operatetime);
    }
}
