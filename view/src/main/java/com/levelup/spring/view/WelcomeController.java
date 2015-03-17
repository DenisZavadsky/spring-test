package com.levelup.spring.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by denis_zavadsky on 3/17/15.
 */
@Controller
@RequestMapping("/index")
public class WelcomeController {

    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("test","Test Attribute");
        return "welcome";
    }

    @RequestMapping(value = "/custom",method = RequestMethod.GET)
    public ModelAndView getCustomIndex(@RequestParam("name") String userName){
        ModelAndView result = new ModelAndView();
        result.addObject("userName",userName);
        result.setViewName("custom");
        return result;
    }
}
