package com.idea.realize;

import com.idea.realize.interfaces.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserFacade userFacade;


    @RequestMapping("/getUserNameById.do")
    public String getUserNameById(@RequestParam("id") String id) {
        return userFacade.getUserNameById(id);
    }


}
