package com.dream.content.service;

import com.dream.common.pojo.DreamResult;
import com.dream.common.pojo.EasyUiTreeNode;

import java.util.List;

/**
 * 门户网站的接口
 */
public interface TbContentCategoryService {
    /**
     * 查询门户网站
     * @return
     * @param id
     */
    List<EasyUiTreeNode> list(Long id);

    /**
     * 添加门户网站
     * @return
     */
    DreamResult creat(Long parentId, String name);

    /**
     * 修改
     * @param parentId id
     * @param name 名称
     * @return
     */
    DreamResult update(Long parentId, String name);

    /**
     * 删除
     * @param id id
     * @return
     */
    DreamResult delete(Long id);

    /**
     * 删除
     * @param parentId 父类的id
     * @param id 删除的id
     * @param isParentAfterDelete 父类是否还有其他子类
     * @return
     */
    DreamResult delete(Long parentId, Long id, Boolean isParentAfterDelete);
}
