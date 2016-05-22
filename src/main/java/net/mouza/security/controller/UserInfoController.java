package net.mouza.security.controller;


import net.mouza.security.entity.UserInfo;
import net.mouza.security.service.ResourceInfoService;
import net.mouza.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by MouZa on 16/5/17.
 */
@Controller
@RequestMapping(value = "user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ResourceInfoService resourceInfoService;

    @RequestMapping(value = "user_add")
    public String addUser(UserInfo userInfo) {
        userInfoService.addUser(userInfo);
        return "/user/user_add";
    }

    @RequestMapping(value = "login")
    public String login(){
        return "/user/login";
    }

    @RequestMapping(value = "user_list")
    public String userInfos(Model model) {
        List<UserInfo> userInfos = userInfoService.userInfos();
        model.addAttribute("userInfos", userInfos);
        return "/user/user_list";
    }

    @RequestMapping(value = "res_list")
    public String resourceInfos(HttpServletRequest request) {
        resourceInfoService.generatorResourceInfo(request);
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/resource/lists";
    }

}
