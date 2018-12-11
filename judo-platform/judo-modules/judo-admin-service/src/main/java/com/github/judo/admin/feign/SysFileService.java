package com.github.judo.admin.feign;

import com.github.judo.admin.feign.fallback.SysFileServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 公用文件 服务类
 * @Date: 2018/10/13 14:48
 * @Version: 1.0
 */
@FeignClient(name = "judo-fastdfs-service", fallback = SysFileServiceFallback.class)
public interface SysFileService {
    /**
     * 文件上传
     *
     * @param: bytes 文件字节
     * @param: fileName  文件名称
     * @param: fileSize 文件大小
     * @param: extension 文件扩展名
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:33
     * @return: java.lang.String
     */
    @PostMapping("/sys/file/upload/bytes/{id}")
    String uploadFile(@PathVariable("id") String id, @RequestParam("bytes") byte[] bytes, @RequestParam("fileName") String fileName, @RequestParam("fileSize") long fileSize, @RequestParam("extension") String extension);

    /**
     * 文件上传
     *
     * @param: multipartFile 表单提交文件
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:40
     * @return: java.lang.String
     */
    @PostMapping(value = "/sys/file/upload/file/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadFile(@PathVariable("id") String id, @RequestPart("file") MultipartFile file) throws IOException;

    /**
     * 文件下载
     *
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:43
     * @return: byte[]
     */
    @GetMapping("/sys/file/download/byte")
    byte[] downloadFileByte(@RequestParam("fileUrl") String fileUrl);

    /**
     * 文件下载
     *
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:45
     * @return: java.io.InputStream
     */
    @GetMapping("/sys/file/download/input/stream")
    InputStream downloadFileInputStream(@RequestParam("fileUrl") String fileUrl);

    /**
     * 删除文件
     *
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:47
     * @return: boolean
     */
    @DeleteMapping("/sys/file/delete/file/{id}")
    boolean deleteFile(@PathVariable("id") String id, @RequestParam("fileUrl") String fileUrl);
}
