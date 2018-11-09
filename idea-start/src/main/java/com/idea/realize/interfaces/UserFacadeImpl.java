package com.idea.realize.interfaces;

import org.springframework.stereotype.Component;

@Component("userFacade")
public class UserFacadeImpl implements UserFacade {

    @Override
    public String getUserNameById(String id) {
        return "sfsdfsfsdf"+id;
    }
}
