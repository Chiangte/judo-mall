package com.github.judo.admin.feign.fallback;

import com.github.judo.admin.feign.SysFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 公用文件 服务实现类
 * @Date: 2018/10/13 14:48
 * @Version: 1.0
 */
@Slf4j
@Service
public class SysFileServiceFallback implements SysFileService {
    /**
     * 文件上传
     *
     * @param id
     * @param bytes
     * @param fileName
     * @param fileSize
     * @param extension
     * @param: bytes 文件字节
     * @param: fileName  文件名称
     * @param: fileSize 文件大小
     * @param: extension 文件扩展名
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:33
     * @return: java.lang.String
     */
    @Override
    public String uploadFile(String id, byte[] bytes, String fileName, long fileSize, String extension) {
        log.error("调用{}异常{}", "uploadFile", id);
        return null;
    }

    /**
     * 文件上传
     *
     * @param id
     * @param file
     * @param: multipartFile 表单提交文件
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:40
     * @return: java.lang.String
     */
    @Override
    public String uploadFile(String id, MultipartFile file) throws IOException {
        log.error("调用{}异常{},{}", "uploadFile", id, file);
        return null;
    }

    /**
     * 文件下载
     *
     * @param fileUrl
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:43
     * @return: byte[]
     */
    @Override
    public byte[] downloadFileByte(String fileUrl) {
        log.error("调用{}异常{}", "downloadFileByte", fileUrl);
        return new byte[0];
    }

    /**
     * 文件下载
     *
     * @param fileUrl
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:45
     * @return: java.io.InputStream
     */
    @Override
    public InputStream downloadFileInputStream(String fileUrl) {
        log.error("调用{}异常{}", "downloadFileInputStream", fileUrl);
        return null;
    }

    /**
     * 删除文件
     *
     * @param id
     * @param fileUrl
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:47
     * @return: boolean
     */
    @Override
    public boolean deleteFile(String id, String fileUrl) {
        log.error("调用{}异常{},{}", "deleteFile", id, fileUrl);
        return false;
    }
}
