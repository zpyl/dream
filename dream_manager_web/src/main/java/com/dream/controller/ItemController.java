package com.dream.controller;

import com.dream.common.pojo.DreamResult;
import com.dream.common.pojo.EasyUiDataGridResult;
import com.dream.pojo.TbItem;
import com.dream.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/selectByKey/{itemId}")
    public TbItem selectByKey(@PathVariable long itemId){
        return itemService.selectByKey(itemId);
    }

    @RequestMapping("/list")
    public EasyUiDataGridResult list(@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize){
        return itemService.list(pageNum,pageSize);
    }

    /**
     * 批量删除
     * @param ids 商品id
     * @return 状态码
     */
    @RequestMapping("/delete")
    public DreamResult delete(Long[] ids){
        return itemService.delete(ids);
    }

    /**
     * 增加商品信息
     * @param tbItem 商品信息
     * @param desc 商品描述
     * @return
     */
    @RequestMapping("/add")
    public DreamResult add(TbItem tbItem,String desc){
        System.out.println("img:"+tbItem.getImage());
        return itemService.add(tbItem,desc);
    }
}
