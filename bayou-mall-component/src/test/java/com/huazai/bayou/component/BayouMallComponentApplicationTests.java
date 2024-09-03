package com.huazai.bayou.component;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class BayouMallComponentApplicationTests {

    @Autowired
    private OSS ossClient;

    @Test
    void contextLoads() {
    }

    @Test
    public void uploadFile() throws FileNotFoundException {
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "bayou-bucket";
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "product/my-product-03.png";
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String filePath = "F:\\图片1.png";
        InputStream inputStream = new FileInputStream(filePath);

        PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, inputStream);

        System.out.println("文件上传完成。。。。。。");
    }

}
