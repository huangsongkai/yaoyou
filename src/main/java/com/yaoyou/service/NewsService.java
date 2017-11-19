package com.yaoyou.service;

import com.yaoyou.dao.NewsMapper;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.News;
import com.yaoyou.model.dataObject.NewsExample;
import com.yaoyou.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song.
 */
@Service
public class NewsService extends BaseService{
    @Resource
    NewsMapper newsMapper;

    public Result add(News news) {
        return new Result(newsMapper.insert(news),"",news);
    }

    public int update(News news) {
        return newsMapper.updateByPrimaryKey(news);
    }

    public int delete(News news) {
        return newsMapper.deleteByPrimaryKey(news.getNewsId());
    }

    public News get(int id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    public List<News> getList(int pageNum) {
        NewsExample activityExample = new NewsExample();
        activityExample.setOrderByClause("CREATE_TIME DESC "+ PageUtil.genPaginationClause(pageNum));
        return newsMapper.selectByExample(activityExample);
    }

    public int totalPage() {
        return PageUtil.getPageNum(newsMapper.countByExample(null));
    }

}
