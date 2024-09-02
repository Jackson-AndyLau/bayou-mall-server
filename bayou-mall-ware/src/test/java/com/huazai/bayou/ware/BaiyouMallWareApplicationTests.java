package com.huazai.bayou.ware;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huazai.bayou.ware.entity.WareInfoEntity;
import com.huazai.bayou.ware.service.WareInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class BaiyouMallWareApplicationTests {

    @Autowired
    private WareInfoService wareInfoService;

    @Autowired
    private OSSClient ossClient;

    @Test
    void contextLoads() {
        // 新增仓库信息
/*        WareInfoEntity wareInfoEntity = new WareInfoEntity();
        wareInfoEntity.setAddress("四川省成都市武侯区");
        wareInfoEntity.setName("大合仓库");
        wareInfoEntity.setAreacode("100101");

        wareInfoService.save(wareInfoEntity);*/
        // 查询仓库信息
        QueryWrapper<WareInfoEntity> entityQueryWrapper = new QueryWrapper<>();
        entityQueryWrapper.lambda().eq(WareInfoEntity::getName, "大合仓库");
        List<WareInfoEntity> wareInfoEntityList = wareInfoService.list(entityQueryWrapper);
        wareInfoEntityList.stream().forEach(wareInfoEntity -> {
            System.out.println(wareInfoEntity.toString());

        });
    }

    @Test
    public void aliUploadFile() throws FileNotFoundException {
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "bayou-bucket";
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "product/my-product-04.png";
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String filePath = "F:\\图片1.png";
        InputStream inputStream = new FileInputStream(filePath);

        PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, inputStream);

        System.out.println("文件上传完成。。。。。。");
    }


}
