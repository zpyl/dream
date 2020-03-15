package com.dream.controller;

import com.alibaba.fastjson.JSON;
import com.dream.web.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ImageController {
    //给属性注入值
    @Value("${DREAM_IMAGE_SERVER_URL}")
    //服务器的ip
    private String DREAM_IMAGE_SERVER_URL;

    /**
     * @param uploadFile 前端发来的是一个文件，则需要使用这个对象来接收
     * MediaType.TEXT_PLAIN_VALUE+";charset=utf-8"指定前端发来的数据格式，前端发送的是一个文件格式，
     *                   不是string也不是json ajax发送文件时，后台通过定义接收方式来获取完整的文件
     * @return 因为前端使用的是富文本编辑器 有特定的返回格式
     * 成功是返回"error":0,"url":路径
     * 失败是返回"error":1,"message":"错误信息"
     *
     */

    @RequestMapping(value = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    public String uploading(MultipartFile uploadFile){
        Map map=new HashMap();
        try {
            //先获取文件的名称
            String originalFilename = uploadFile.getOriginalFilename();
            //获取文件的扩展名
            String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //获取文件的字节数组
            byte[] bytes = uploadFile.getBytes();
            //通过FastDFSClient来实现上传图片(需要提供字节数组、扩展名)
            FastDFSClient fastDFSClient=new FastDFSClient("classpath:resource/fastdfs.conf");
            //返回值 group1/M00/00/00/图片地址  分组
            String file = fastDFSClient.uploadFile(bytes, substring);
            //再根据服务器的ip地址组合成一个完整的url
            String url=DREAM_IMAGE_SERVER_URL+file;
            System.out.println(url);
            map.put("error", 0);
            map.put("url", url);
            return  JSON.toJSONString(map);

        } catch (Exception e) {
            System.out.println("搞笑");
            e.printStackTrace();
            map.put("error", 1);
            map.put("message", "上传失败");
            return JSON.toJSONString(map);
        }
    }

}
