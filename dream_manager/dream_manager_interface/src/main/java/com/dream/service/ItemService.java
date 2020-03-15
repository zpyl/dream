package com.dream.service;

import com.dream.common.pojo.DreamResult;
import com.dream.common.pojo.EasyUiDataGridResult;
import com.dream.pojo.TbItem;



public interface ItemService {
    /**
     * 根据商品id查找商品
     * @param itemId 商品id
     * @return 查找的商品信息
     */
    TbItem selectByKey(long itemId);

    /**
     * 查询商品的所有信息
     * @param pageNum 开始页面
     * @param pageSize 查询条数
     * @return 商品结果
     */
    EasyUiDataGridResult list(Integer pageNum, Integer pageSize);

    /**
     * 批量删除
     * @param ids 删除的商品id
     * @return 状态
     */
    DreamResult delete(Long[] ids);

    /**
     * 增加商品信息
     * @param tbItem 商品信息
     * @param desc 商品描述
     * @return 状态
     */
    DreamResult add(TbItem tbItem, String desc);
}
