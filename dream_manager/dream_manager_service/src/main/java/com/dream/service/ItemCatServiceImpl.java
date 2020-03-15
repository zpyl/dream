package com.dream.service;

import com.dream.common.pojo.EasyUiTreeNode;
import com.dream.mapper.TbItemCatMapper;
import com.dream.pojo.TbItemCat;
import com.dream.pojo.TbItemCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    /**
     * 浏览树的结点
     * @return
     * @param id
     */
    @Override
    public List<EasyUiTreeNode> catList(Long id) {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(tbItemCatExample);
        List<EasyUiTreeNode> list=new ArrayList<>();
        for (TbItemCat tbItemCat : tbItemCats) {
            EasyUiTreeNode easyUiTreeNode=new EasyUiTreeNode();
            easyUiTreeNode.setId(tbItemCat.getId());
            easyUiTreeNode.setText(tbItemCat.getName());
            easyUiTreeNode.setState(tbItemCat.getIsParent()?"closed":"open");
            list.add(easyUiTreeNode);
        }
        return list;
    }
}
