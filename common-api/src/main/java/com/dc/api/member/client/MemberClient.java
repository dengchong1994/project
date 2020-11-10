package com.dc.api.member.client;

import com.dc.api.ServiceNameConstant;
import com.dc.api.member.cnd.MemberCnd;
import com.dc.api.member.dto.MemberDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = ServiceNameConstant.SERVICE_USER, path = "/member")
public interface MemberClient {

    @PostMapping(value = "/api/user/queryUserById")
    MemberDto queryUserById(@RequestBody MemberCnd userCnd);

}
