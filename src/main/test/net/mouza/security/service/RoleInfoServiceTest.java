package net.mouza.security.service;

import net.mouza.security.entity.RoleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by MouZa on 16/5/20.
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//指定juit的spring运行器
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})//指定spring的文件
public class RoleInfoServiceTest {

    @Autowired
    RoleInfoService roleInfoService;

    @Test
    public void testInsert() throws Exception {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleCode("system");
        roleInfo.setRoleName("机构管理");
        roleInfo.setRoleDesc("管理系统中机构的所有操作,有最高权限,对系统有最大的能力");
        roleInfoService.insert(roleInfo);
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        RoleInfo roleInfo = roleInfoService.selectByPrimaryKey("660d61c21c09425485a4696c2a17f2f6");
        System.out.println(roleInfo);
    }

    @Test
    public void testLists() throws Exception {
        System.out.println(roleInfoService.lists().toString());
    }
}