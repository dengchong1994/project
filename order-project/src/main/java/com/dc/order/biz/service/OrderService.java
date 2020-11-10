package com.dc.order.biz.service;

import com.dc.framework.service.GenericService;
import com.dc.order.biz.model.entity.Order;

import java.util.List;

public interface OrderService extends GenericService {

    List<Order> queryList();

}
