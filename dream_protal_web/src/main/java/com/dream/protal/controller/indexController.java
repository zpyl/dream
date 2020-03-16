package com.dream.protal.controller;

import com.alibaba.fastjson.JSON;
import com.dream.content.service.TbContentService;
import com.dream.pojo.TbContent;
import com.dream.protal.pojo.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**'
 * 门户网站
 */
@Controller
public class indexController {
    @Value("${categoryId}")
    private Long categoryId;
    //图片1的尺寸
    @Value("${heightA}")
    private Integer height;
    @Value("${widthA}")
    private Integer width;
    //图片2的尺寸
    @Value("${heightB}")
    private Integer heightB;
    @Value("${widthB}")
    private Integer widthB;

    @Autowired
    private TbContentService tbContentService;


    /**
     * 展示首页
     * 访问从web.xml中找index.html，没有找到，或默认访问/index
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        //展示大广告
        List<TbContent> tbContents=tbContentService.selectContentByCategoryId(categoryId);
        System.out.println("c"+categoryId+":"+tbContents.size());
        List<Image> list =new ArrayList<>();
        for (TbContent tbContent : tbContents) {
           Image node = new Image();
           //设置轮播标题            
           node.setAlt(tbContent.getTitle());
           //设置连接
            node.setUrl(tbContent.getUrl());
            node.setSrc(tbContent.getPic());
            node.setSrcB(tbContent.getPic2());
            //宽高  
            node.setWidth(width);
            node.setWidthB(widthB);
            node.setHeight(height);
            node.setHeightB(heightB);
            //把转换过的对象加入到集合中
            list.add(node);
        }
        //将集合转为json对象
        String json = JSON.toJSONString(list);
        System.out.println(json);
        model.addAttribute("ad1", json);
        return "index";
    }

}
