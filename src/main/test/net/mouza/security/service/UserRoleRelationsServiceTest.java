package net.mouza.security.service;

import net.mouza.security.entity.ResourceInfo;
import net.mouza.security.entity.RoleInfo;
import net.mouza.security.entity.UserInfo;
import net.mouza.security.entity.UserRoleRelations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MouZa on 16/5/20.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//指定juit的spring运行器
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})//指定spring的文件
public class UserRoleRelationsServiceTest {
    @Autowired
    private UserRoleRelationsService userRoleRelationsService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RoleInfoService roleInfoService;

    @Test
    public void testInsert() throws Exception {
        UserRoleRelations userRoleRelations = new UserRoleRelations();
        List<UserInfo> userInfos = userInfoService.userInfos();
        UserInfo userInfo = userInfos.get(1);
        RoleInfo roleInfo = roleInfoService.lists().get(0);
        userRoleRelations.setUserUuid(userInfo.getUserUuid());
        userRoleRelations.setRoleUuid(roleInfo.getRoleUuid());
        userRoleRelationsService.insert(userRoleRelations);
    }

    @Test
    public void testLists() throws Exception {

    }
}