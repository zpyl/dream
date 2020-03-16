package com.dream.content.service;

import com.dream.common.pojo.DreamResult;
import com.dream.common.pojo.EasyUiDataGridResult;
import com.dream.pojo.TbContent;

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
}
