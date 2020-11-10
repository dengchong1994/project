package com.dc.framework.model.cnd;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class IdCnd extends GenericCnd {

    /**
     * 主键
     */
    @NotNull
    private Long id;

}
