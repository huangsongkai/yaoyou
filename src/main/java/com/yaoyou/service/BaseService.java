package com.yaoyou.service;

import com.yaoyou.util.PageUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by song on 16/7/26.
 */
@Service
public abstract class BaseService {
    protected final Logger logger = Logger.getLogger(this.getClass());
    final int PAGE_SIZE = PageUtil.PAGE_SIZE;
    public int getTotalPage(){
        return 0;
    }


}
