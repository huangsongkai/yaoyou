package com.yaoyou.service;

import com.yaoyou.dao.ShopCommentMapper;
import com.yaoyou.dao.ShopInfoMapperExt;
import com.yaoyou.model.dataObject.ShopComment;
import com.yaoyou.model.dataObject.ShopCommentExample;
import com.yaoyou.model.dataObject.ShopInfo;
import com.yaoyou.model.dataObject.ShopInfoExample;
import com.yaoyou.model.dto.ShopActivityDTO;
import com.yaoyou.util.IdGenrator;
import com.yaoyou.util.PageUtil;
import com.yaoyou.util.StringUtil;
import com.yaoyou.util.gps.GPSComparator;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by song on 16/7/20.
 */
@Service
public class ShopCommentService extends BaseService{

    @Resource
    ShopCommentMapper shopCommentMapper;

    public List<ShopComment> getCommentsByShopId(String id, int pageNum){
        ShopCommentExample shopCommentExample = new ShopCommentExample();
        return shopCommentMapper.selectByLimit(id, (pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public int addComment(ShopComment shopComment) {
        shopComment.setCommentId(IdGenrator.next());
        try {
            return shopCommentMapper.insert(shopComment);
        }catch (Exception e){
            logger.error(e);
            return -1;
        }
    }

    public int getCommentsTotalPage(String ShopId) {
        ShopCommentExample shopCommentExample = new ShopCommentExample();
        shopCommentExample.or().andShopInfoIdEqualTo(ShopId);
        int total = shopCommentMapper.countByExample(shopCommentExample);
        return PageUtil.getPageNum(total);
    }

    public int delComment(ShopComment shopComment) {
            return 0;
    }

    public int updateComment(ShopComment shopComment) {
        return 0;
    }

}
