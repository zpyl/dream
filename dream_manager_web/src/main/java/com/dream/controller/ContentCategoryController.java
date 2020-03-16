package com.dream.controller;

import com.dream.common.pojo.DreamResult;
import com.dream.common.pojo.EasyUiTreeNode;
import com.dream.content.service.TbContentCategoryService;
import com.dream.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 门户网站的管理
 */
@RestController
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    /**
     * 只有当父节点被点击时会进入此方法，并且返回此id
     * @param id
     * @return
     */
    @RequestMapping("/list")
    public List<EasyUiTreeNode> list(@RequestParam(defaultValue = "0") Long id){
        return tbContentCategoryService.list(id);
    }

    /**
     * 增加
     * @param parentId id
     * @param name 名称
     * @return
     */
    @RequestMapping("/create")
    public DreamResult create(Long parentId,String name){
        return tbContentCategoryService.creat(parentId,name);
    }
    /**
     * 修改
     * @param parentId id
     * @param name 名称
     * @return
     */
    @RequestMapping("/update")
    public DreamResult update(@RequestParam(value = "id") Long parentId,String name){
        return tbContentCategoryService.update(parentId,name);
    }

    /**
     * 删除
     * @param parentId 父类的id
     * @param id 删除的id
     * @param isParentAfterDelete 父类下面是否还有子类
     * @return
     */
    @RequestMapping("/delete")
    public DreamResult delete(Long parentId,Long id,Boolean isParentAfterDelete){
        return tbContentCategoryService.delete(parentId,id,isParentAfterDelete);
    }
}
