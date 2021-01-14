package com.dc.order.biz.controller;

import com.dc.api.member.client.MemberClient;
import com.dc.api.member.cnd.MemberCnd;
import com.dc.api.member.dto.MemberDto;
import com.dc.framework.controller.GenericController;
import com.dc.framework.exception.BizException;
import com.dc.framework.model.entity.Result;
import com.dc.order.biz.enums.OrderErrorCodeEnum;
import com.dc.order.biz.model.entity.Order;
import com.dc.order.biz.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dc.framework.model.entity.Result.success;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController extends GenericController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberClient memberClient;

    @PostMapping("/queryList")
    public Result<String> queryList() {
//        List<Order> orderList = orderService.queryList();
//        MemberDto memberDto = memberClient.queryUserById(new MemberCnd());
//        if (1 == 1) {
//            throw new BizException(OrderErrorCodeEnum.FAIL);
//        }
        return success("ok");
    }

}
