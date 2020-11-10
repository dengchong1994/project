package com.dc.order.biz.service.impl;

import com.dc.framework.service.impl.GenericServiceImpl;
import com.dc.order.biz.model.entity.Order;
import com.dc.order.biz.mapper.OrderMapper;
import com.dc.order.biz.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl extends GenericServiceImpl<OrderMapper> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;



    @Override
    public List<Order> queryList() {
        return orderMapper.queryList();
    }
}
