package net.mouza.security.controller;

import net.mouza.security.service.ResourceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MouZa on 16/5/20.
 */
@Controller
@RequestMapping(value = "resource")
public class ResourceInfoController {

    @Autowired
    ResourceInfoService resourceInfoService;

    @RequestMapping(value = "lists")
    public String lists(Model model) {
        model.addAttribute("resourceInfos",resourceInfoService.lists());
        return "system/lists";
    }

}
