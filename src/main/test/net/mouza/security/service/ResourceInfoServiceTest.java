package net.mouza.security.service;

import net.mouza.security.common.Operation;
import net.mouza.security.entity.ResourceInfo;
import net.mouza.security.utils.UUIDGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by MouZa on 16/5/19.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//指定juit的spring运行器
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})//指定spring的文件
public class ResourceInfoServiceTest {

    @Autowired
    private ResourceInfoService resourceInfoService;

    @Autowired
    private MockHttpServletRequest request;

    @Autowired
    private MockHttpSession session;

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        ResourceInfo r = new ResourceInfo();
        r.setResourceUuid("0f0a271ca5b24e8da2cfd00341589706");
        r.setResourceCode("admin");
        r.setResourceName("系统管理");
        r.setResourceUri("/system/manager");
        r.setResourceMethod(Operation.DELETE);
        r.setOrganizeUuid(UUIDGenerator.getUUID());
        int insert = resourceInfoService.insert(r);
        System.out.println("----------------------------" + insert);
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        String ruid = "0f0a271ca5b24e8da2cfd00341589706";
        ResourceInfo resourceInfo = resourceInfoService.selectByPrimaryKey(ruid);
        System.out.println(resourceInfo);
    }

    @Test
    public void testGeneratorResourceInfo() {

        resourceInfoService.generatorResourceInfo(request);
    }
}