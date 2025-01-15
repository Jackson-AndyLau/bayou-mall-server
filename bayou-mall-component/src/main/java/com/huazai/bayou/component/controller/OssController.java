package com.huazai.bayou.component.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.huazai.bayou.component.common.utils.DateUtils;
import com.huazai.bayou.component.common.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ClassName: OssController
 * Package: com.huazai.bayou.component.controller
 * Description:
 *
 * @Author huazai
 * @Create 2024-09-04 10:25
 * @Version 1.0
 */
@RequestMapping("/component/oss")
@RestController
public class OssController {

    private final OSS ossClient;

    public OssController(OSS ossClient) {
        this.ossClient = ossClient;
    }

    @Value("${alibaba.cloud.oss.bucket.name}")
    private String bucketName;

    @GetMapping("/getSignature")
    public R getSignature() {
        // 映射实现类，取值
        OSSClient ossClientImpl = (OSSClient) ossClient;
        String endPoint = String.valueOf(ossClientImpl.getEndpoint().getHost());
        String host = "https://" + bucketName + "." + endPoint;
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        // EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // Endpoint以华东1（杭州）为例，其他Region请按实际情况填写。
        // String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        // 填写Bucket名称，例如examplebucket。
        // String bucket = "examplebucket";
        // 填写Host名称，格式为https://bucketname.endpoint。
        // String host = "https://examplebucket.oss-cn-hangzhou.aliyuncs.com";
        // 设置上传回调URL，即回调服务器地址，用于处理应用服务器与OSS之间的通信。OSS会在文件上传完成后，把文件上传信息通过此回调URL发送给应用服务器。
        // String callbackUrl = "https://192.168.0.0:8888";
        // 设置上传到OSS文件的前缀，可置空此项。置空后，文件将上传至Bucket的根目录下。
        // String dir = "exampledir/";
        String dir = DateUtils.format(Calendar.getInstance().getTime()) + "/";

        // 创建OSSClient实例。
        // OSS ossClient = new OSSClientBuilder().build(ossImpl.getEndpoint(), credentialsProvider);
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String accessId = ossClientImpl.getCredentialsProvider().getCredentials().getAccessKeyId();
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);

            Map<String, String> respMap = new LinkedHashMap<String, String>();
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            // respMap.put("expire", formatISO8601Date(expiration));

            //JSONObject jasonCallback = new JSONObject();
            //jasonCallback.put("callbackUrl", callbackUrl);
            //jasonCallback.put("callbackBody",
            //        "filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
            //jasonCallback.put("callbackBodyType", "application/x-www-form-urlencoded");
            //String base64CallbackBody = BinaryUtil.toBase64String(jasonCallback.toString().getBytes());
            //respMap.put("callback", base64CallbackBody);

            //JSONObject ja1 = JSONObject.parseObject(respMap);
            //// System.out.println(ja1.toString());
            //response.setHeader("Access-Control-Allow-Origin", "*");
            //response.setHeader("Access-Control-Allow-Methods", "GET, POST");
            //response(request, response, ja1.toString());

            return R.ok().put("data", respMap);
        } catch (Exception e) {
            // Assert.fail(e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            ossClient.shutdown();
        }
        return null;
    }

}
