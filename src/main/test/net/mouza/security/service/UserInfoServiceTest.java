package net.mouza.security.service;

import net.mouza.security.entity.UserInfo;
import net.mouza.security.utils.UUIDGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MouZa on 16/5/17.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//指定juit的spring运行器
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})//指定spring的文件
public class UserInfoServiceTest {

    @Resource
    private UserInfoService userInfoService;

    @Test
    public void testAddUser() throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("admin");
        UserInfo userInfo = new UserInfo(UUIDGenerator.getUUID(),
                "system",
                "系统",
                password,
                "shaoqing.ren@yahoo.com",
                "13290909900",
                "010-54369870",
                "system"
        );
        userInfoService.addUser(userInfo);
    }

    @Test
    public void testUserInfos() throws Exception {
        List<UserInfo> userInfos = userInfoService.userInfos();
        for (UserInfo userInfo : userInfos) {
            System.out.println(userInfo);
        }
    }

    @Test
    public void testSelectByUserName() {
        UserInfo userInfo = userInfoService.selectByUserName("admin");
        System.out.println(userInfo);
    }
}