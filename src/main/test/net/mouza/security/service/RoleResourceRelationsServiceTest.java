package net.mouza.security.service;

import net.mouza.security.entity.ResourceInfo;
import net.mouza.security.entity.RoleInfo;
import net.mouza.security.entity.RoleResourceRelations;
import net.mouza.security.service.impl.RoleResourceRelationsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by MouZa on 16/5/21.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//指定juit的spring运行器
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})//指定spring的文件
public class RoleResourceRelationsServiceTest {


    @Autowired
    private RoleResourceRelationsService roleResourceRelationsService;

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private ResourceInfoService resourceInfoService;

    @Test
    public void testInsert() throws Exception {
        RoleResourceRelations rrrs = new RoleResourceRelations();
        RoleInfo roleInfo = roleInfoService.lists().get(0);
        ResourceInfo resourceInfo = resourceInfoService.lists().get(0);
        rrrs.setRoleUuid(roleInfo.getRoleUuid());
        rrrs.setResourceUuid(resourceInfo.getResourceUuid());
        roleResourceRelationsService.insert(rrrs);
    }

    @Test
    public void testLists() throws Exception {

    }
}