package com.github.judo.fastdfs.utils;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: FastDFS客户端
 * @Date: 2018/10/13 11:23
 * @Version: 1.0
 */
@Component
public class FastDFSClient {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /**
     * 文件上传
     *
     * @param: bytes 文件字节
     * @param: fileSize 文件大小
     * @param: extension 文件扩展名
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:33
     * @return: java.lang.String
     */
    public String uploadFile(byte[] bytes, long fileSize, String extension) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        StorePath storePath = fastFileStorageClient.uploadFile(byteArrayInputStream, fileSize, extension, null);
        System.out.println(storePath.getFullPath());
        return storePath.getFullPath();
    }

    /**
     * 文件上传
     *
     * @param: multipartFile 表单提交文件
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:40
     * @return: java.lang.String
     */
    public String uploadFile(MultipartFile multipartFile, String extension) throws IOException {
        return uploadFile(multipartFile.getBytes(), multipartFile.getSize(), extension);
    }

    /**
     * 文件下载
     *
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:43
     * @return: byte[]
     */
    public byte[] downloadFileByte(String fileUrl) {
        String group = fileUrl.substring(0, fileUrl.indexOf("/"));
        String path = fileUrl.substring(fileUrl.indexOf("/") + 1);
        DownloadByteArray downloadByteArray = new DownloadByteArray();
        byte[] bytes = fastFileStorageClient.downloadFile(group, path, downloadByteArray);
        return bytes;
    }

    /**
     * 文件下载
     *
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:45
     * @return: java.io.InputStream
     */
    public InputStream downloadFileInputStream(String fileUrl) {
        return new ByteArrayInputStream(downloadFileByte(fileUrl));
    }

    /**
     * 删除文件
     *
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:47
     * @return: boolean
     */
    public boolean deleteFile(String fileUrl) {
        String group = fileUrl.substring(0, fileUrl.indexOf("/"));
        String path = fileUrl.substring(fileUrl.indexOf("/") + 1);
        fastFileStorageClient.deleteFile(group, path);
        return true;
    }
}
