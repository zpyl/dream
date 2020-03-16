package com.dream.content.service.impl;

import com.dream.common.pojo.DreamResult;
import com.dream.common.pojo.EasyUiDataGridResult;
import com.dream.content.service.TbContentService;
import com.dream.mapper.TbContentMapper;
import com.dream.pojo.TbContent;
import com.dream.pojo.TbContentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    /**
     * 查询
     * @param page 当前页码
     * @param rows 查询条数
     * @param categoryld 门户管理的内容id
     * @return
     */
    @Override
    public EasyUiDataGridResult list(Integer page, Integer rows, Long categoryld) {
        //分页
        PageHelper.startPage(page, rows);
        TbContentExample tbContentExample =new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryld);
        List<TbContent> tbContents = tbContentMapper.selectByExample(tbContentExample);
        PageInfo pageInfo=new PageInfo(tbContents);
        return new EasyUiDataGridResult(pageInfo.getTotal(), tbContents);
    }

    /**
     * 增加
     * @param tbContent 增加的参数
     * @return
     */
    @Override
    public DreamResult save(TbContent tbContent) {
        tbContent.setCreated(new Date());
        tbContent.setUpdated(tbContent.getCreated());
        tbContentMapper.insertSelective(tbContent);
        return DreamResult.ok();
    }

    @Override
    public List<TbContent> selectContentByCategoryId(Long categoryId) {
        TbContentExample tbContentExample =new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        return tbContentMapper.selectByExample(tbContentExample);
    }

    @Override
    public DreamResult edit(TbContent tbContent) {
        tbContentMapper.updateByPrimaryKey(tbContent);
        return DreamResult.ok();
    }

    @Override
    public DreamResult delete(Long[] ids) {
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        tbContentMapper.deleteByExample(tbContentExample);
        return DreamResult.ok();
    }
}
