package com.yaoyou.interfaces.controller;

import com.yaoyou.service.BaseService;
import com.yaoyou.util.ObjectNullCheck;
import com.yaoyou.util.PageUtil;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by song on 16/7/22.
 */
public class BaseController2 extends BaseController{

    BaseService baseService;

    public BaseController2(BaseService baseService){
        this.baseService = baseService;
    }

}
