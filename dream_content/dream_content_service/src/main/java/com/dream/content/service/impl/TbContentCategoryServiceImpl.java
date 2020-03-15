package com.dream.content.service.impl;

import com.dream.common.pojo.DreamResult;
import com.dream.common.pojo.EasyUiTreeNode;
import com.dream.content.service.TbContentCategoryService;
import com.dream.mapper.TbContentCategoryMapper;
import com.dream.pojo.TbContentCategory;
import com.dream.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 门户网站的实现
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    /**
     * 操作门户网站的数据库
     */
    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    /**
     * 门户网站表
     * @return
     * @param id
     */
    @Override
    public List<EasyUiTreeNode> list(Long id) {
        List<EasyUiTreeNode> list=new ArrayList<>();
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(tbContentCategoryExample);
        for (TbContentCategory tbContentCategory : tbContentCategories) {
            list.add(new EasyUiTreeNode(tbContentCategory.getId(),tbContentCategory.getName(),tbContentCategory.getIsParent()?"closed":"open"));
        }
        return list;
    }

    /**
     * 添加
     * @param parentId id
     * @param name 名称
     * @return
     */
    @Override
    public DreamResult creat(Long parentId, String name) {
        Boolean isParent = tbContentCategoryMapper.selectByPrimaryKey(parentId).getIsParent();
        TbContentCategory tbContentCategory = new TbContentCategory();
       if(!isParent){
            //如果不是根节点
            //修改此节点为父节点
            tbContentCategory.setIsParent(true);
            //要修改的id
            tbContentCategory.setId(parentId);
            //修改时间
            tbContentCategory.setUpdated(new Date());
            tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
        }
        //增加新的节点
        tbContentCategory.setId(null);
        //父节点
        tbContentCategory.setParentId(parentId);
        //状态
        tbContentCategory.setStatus(1);
        //排列序号
        tbContentCategory.setSortOrder(1);
        //是否为根节点
        tbContentCategory.setIsParent(false);
        //创建时间
        tbContentCategory.setCreated(new Date());
        //修改时间
        tbContentCategory.setUpdated(tbContentCategory.getCreated());
        //名称
        tbContentCategory.setName(name);
        tbContentCategoryMapper.insert(tbContentCategory);
        return DreamResult.ok(tbContentCategory);
    }
    @Override
    public DreamResult update(Long parentId, String name) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(parentId);
        tbContentCategory.setName(name);
        tbContentCategory.setUpdated(new Date());
        tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
        return DreamResult.ok();
    }
    @Override
    public DreamResult delete(Long id) {
        //先查出所在父类的parentId
        Long parentId = tbContentCategoryMapper.selectByPrimaryKey(id).getParentId();
        //删除该子类的id
        tbContentCategoryMapper.deleteByPrimaryKey(id);
        //查看该父类是否还有其他的子类
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(tbContentCategoryExample);
        if(tbContentCategories==null){
            //如果没有子类，则修改该父类为普通目录
            TbContentCategory tbContentCategory = new TbContentCategory();
            tbContentCategory.setId(parentId);
            tbContentCategory.setIsParent(false);
            tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
        }
        return DreamResult.ok();
    }
}
