package com.dream.content.service;

import com.dream.common.pojo.DreamResult;
import com.dream.common.pojo.EasyUiDataGridResult;
import com.dream.pojo.TbContent;

import java.util.List;

public interface TbContentService {
    /**
     * 查询门户管理的页面
     * @param page 当前页码
     * @param rows 查询条数
     * @param categoryld 门户管理的内容id
     * @return
     */
    EasyUiDataGridResult list(Integer page, Integer rows, Long categoryld);

    /**
     * 增加
     * @param tbContent 增加的参数
     * @return
     */
    DreamResult save(TbContent tbContent);

    /**
     * 根据categoryId进行查找
     * @param categoryId 内容类目id
     * @return
     */
    List<TbContent> selectContentByCategoryId(Long categoryId);

    /**
     * 修改
     * @param tbContent 修改的信息
     * @return
     */
    DreamResult edit(TbContent tbContent);

    /**
     * 删除
     * @param ids 删除的信息
     * @return
     */
    DreamResult delete(Long[] ids);
}
