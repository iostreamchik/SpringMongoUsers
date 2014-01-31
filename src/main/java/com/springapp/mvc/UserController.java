package com.springapp.mvc;

import com.springapp.entitys.User;
import com.springapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getCollection(ModelMap map) {
        map.addAttribute("userCollection", userRepo.getCollection());
        return "hello";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public View create(@ModelAttribute User user, ModelMap map) {
        if (StringUtils.hasText(user.getId())) {
            userRepo.update(user);
        } else {
            userRepo.add(user);
        }
        return new RedirectView("/SpringMongoUsers/user");
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public View delete(@ModelAttribute User user, ModelMap map) {
        userRepo.delete(user);
        return new RedirectView("/SpringMongoUsers/user");
    }
}