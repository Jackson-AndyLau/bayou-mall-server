package com.huazai.bayou.member;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huazai.bayou.member.entity.MemberReceiveAddressEntity;
import com.huazai.bayou.member.service.MemberReceiveAddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BayouMallMemberApplicationTests {

    @Autowired
    private MemberReceiveAddressService memberReceiveAddressService;

    @Test
    void contextLoads() {
        // 新增
/*        MemberReceiveAddressEntity memberReceiveAddressEntity = new MemberReceiveAddressEntity();
        memberReceiveAddressEntity.setMemberId(100001L);
        memberReceiveAddressEntity.setName("华仔");
        memberReceiveAddressEntity.setPhone("1582826");
        memberReceiveAddressEntity.setPostCode("4000102");
        memberReceiveAddressEntity.setProvince("四川省");
        memberReceiveAddressEntity.setCity("成都市");
        memberReceiveAddressEntity.setRegion("武侯区");

        memberReceiveAddressService.save(memberReceiveAddressEntity);*/

        // 查询
        QueryWrapper<MemberReceiveAddressEntity> memberReceiveAddressEntityQueryWrapper = new QueryWrapper<>();
        memberReceiveAddressEntityQueryWrapper.lambda().eq(MemberReceiveAddressEntity::getCity, "成都市");

        List<MemberReceiveAddressEntity> memberReceiveAddressEntityList = memberReceiveAddressService.list(memberReceiveAddressEntityQueryWrapper);
        memberReceiveAddressEntityList.forEach(memberReceiveAddressEntity -> {
            System.out.println(memberReceiveAddressEntity.toString());

        });
    }

}
