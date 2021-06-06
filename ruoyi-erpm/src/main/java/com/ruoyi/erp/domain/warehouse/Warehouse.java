package com.ruoyi.erp.domain.warehouse;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 仓库表 erp_warehouse
 *
 * @author 10525
 */
public class Warehouse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String number;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态 （1：未启用 2：已启用）
     */
    private Integer status;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("number", getNumber())
                .append("name", getName())
                .append("status", getStatus())
                .toString();
    }
}
