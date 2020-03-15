package com.dream.test;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FastDFS {
    //客户端配置文件
    public String conf_filename="D:\\桌面\\IDEA\\dream\\dream_manager_web\\src\\test\\resources\\fdfs_client.conf";
    //要上传的文件
    public String local_filename="D:\\桌面\\IDEA\\dream\\dream_manager_web\\src\\test\\resources\\img7.jpg";

    @Test
    public void testUpload() {
        for (int i = 0; i < 5; i++) {
            try {
                ClientGlobal.init(conf_filename);
                TrackerClient tracker = new TrackerClient();
                //运行测试，控制台：
                //注意：组名+路径就是图片在服务器中的访问地址 到服务器中查看
                TrackerServer trackerServer = tracker.getConnection();
                StorageServer storageServer = null;
                StorageClient storageClient = new StorageClient(trackerServer,storageServer);

                NameValuePair nvp[] = new NameValuePair[]{
                        new NameValuePair("item_id", "100010"),

                new NameValuePair("width", "80"),
                        new NameValuePair("height", "90")
                }
                ;
                String fileIds[] = storageClient.upload_file(local_filename, null,nvp);
                System.out.println(fileIds.length);
                System.out.println("组名：" + fileIds[0]);
                System.out.println("路径: " + fileIds[1]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
