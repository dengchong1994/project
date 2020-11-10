package com.dc.framework.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GenericEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 是否删除
     */
    private Integer deleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

}
