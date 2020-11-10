package com.dc.framework.model.cnd;

import lombok.Data;

@Data
public class PageCnd extends GenericCnd {
    /**
     * 当前第几页
     */
    private Integer page;
    /**
     * 每页显示多少行
     */
    private Integer limit;

}
