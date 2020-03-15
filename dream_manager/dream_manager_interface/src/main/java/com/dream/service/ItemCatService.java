package com.dream.service;

import com.dream.common.pojo.EasyUiTreeNode;

import java.util.List;

public interface ItemCatService {
    /**
     * 返回树的结点
     * @return
     * @param id
     */
    List<EasyUiTreeNode> catList(Long id);
}
