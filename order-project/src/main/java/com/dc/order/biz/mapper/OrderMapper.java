package com.dc.order.biz.mapper;

import com.dc.framework.mapper.GenericMapper;
import com.dc.order.biz.model.entity.Order;

import java.util.List;

public interface OrderMapper extends GenericMapper {

    List<Order> queryList();

}
