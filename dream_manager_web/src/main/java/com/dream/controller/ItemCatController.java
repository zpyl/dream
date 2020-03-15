package com.dream.controller;

import com.dream.common.pojo.EasyUiTreeNode;
import com.dream.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类目
 */
@RestController
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    public List<EasyUiTreeNode> catList(@RequestParam(defaultValue = "0") Long id){
        return itemCatService.catList(id);
    }
}
