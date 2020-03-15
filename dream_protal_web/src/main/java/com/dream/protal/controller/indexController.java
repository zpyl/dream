package com.dream.protal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**'
 * 门户网站
 */
@Controller
public class indexController {
    /**
     * 展示首页
     * 访问从web.xml中找index.html，没有找到，或默认访问/index
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
