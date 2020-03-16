package com.dream.controller;

import com.dream.common.pojo.DreamResult;
import com.dream.common.pojo.EasyUiDataGridResult;
import com.dream.common.pojo.EasyUiTreeNode;
import com.dream.content.service.TbContentService;
import com.dream.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 内容管理（网站的页面显示的内容）
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private TbContentService tbContentService;
    /**
     * 查看
     * @param page 开始页面
     * @param rows 查询条数
     * @param categoryId 内容分类id
     * @return
     */
    @RequestMapping("/query/list")
    public EasyUiDataGridResult list(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "1") Integer rows, Long categoryId){
        return tbContentService.list(page,rows,categoryId);
    }

    /**
     * 增加
     * @param tbContent 增加的参数
     * @return
     */
    @RequestMapping("/save")
    public DreamResult save(TbContent tbContent){
        return tbContentService.save(tbContent);
    }
}
