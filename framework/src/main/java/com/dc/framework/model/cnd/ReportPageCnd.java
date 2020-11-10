package com.dc.framework.model.cnd;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReportPageCnd extends PageCnd {
    /**
     * 开始时间
     */
    private Timestamp startDate;
    /**
     * 结束时间
     */
    private Timestamp endDate;
}
