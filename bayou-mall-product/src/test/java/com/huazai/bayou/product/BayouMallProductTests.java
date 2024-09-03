package com.huazai.bayou.product;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.Credentials;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentials;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.exceptions.ClientException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * ClassName: BayouMallProductTests
 * Package: com.huazai.bayou.product
 * Description:
 *
 * @Author huazai
 * @Create 2024-08-28 14:42
 * @Version 1.0
 */
@SpringBootTest
public class BayouMallProductTests {

    @Test
    void uploadFile() throws ClientException, FileNotFoundException {
        CredentialsProvider credentialsProvider01 = new CredentialsProvider() {
            // 初始化变量
            String accessKeyId = "";
            // 初始化变量
            String accessKeySecrect = "";

            // 初始化变量
            // String token = null;
            @Override
            public void setCredentials(Credentials credentials) {

            }

            @Override
            public Credentials getCredentials() {
                // 返回长期凭证 access_key_id, access_key_secrect
                return new DefaultCredentials(accessKeyId, accessKeySecrect);
                // 返回 临时凭证 access_key_id, access_key_secrect, token
                // 对于临时凭证，需要根据过期时间，刷新凭证。
                // return new DefaultCredentials(accessKeyId, accessKeySecrect, token);
            }
        };
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "";
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        // EnvironmentVariableCredentialsProvider credentialsProvider02 = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "bayou-bucket";
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "product/my-product-06.png";
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String filePath = "F:\\图片1.png";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider01);

        try {
            InputStream inputStream = new FileInputStream(filePath);
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
                System.out.println("文件上传完成。。。。。。");
            }
        }
    }
}
