package com.atguigu.gulimall.product;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class GulimallProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("保存成功......");
        brandEntity.setDescript("华为");
        brandService.updateById(brandEntity);
    }


    @Test
    public void testOssUpload() {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tCEkzWKq2nJPjqkaicd";
        String accessKeySecret = "lxxtvBIYfjZdv2P3cpfu4pvyR69Pbz";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "gulimallupload2";
        // 填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
        String objectName = "fengjing.jpg";  // 就是文件的名字 一般用日期或者时间戳表示

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\111.jpg");
            ossClient.putObject(bucketName, objectName, inputStream);

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

}
