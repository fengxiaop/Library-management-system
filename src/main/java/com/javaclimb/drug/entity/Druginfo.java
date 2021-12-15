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
 * 药品
 */
@Data
@TableName(value = "druginfo")
public class Druginfo implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String supplier;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date producttime;

    private String warrenty;

    private String number;

    private Float price;

    private Integer stock;

    public String getProducttimeStr(){
        return DateUtil.dateConvert(producttime);
    }
}
