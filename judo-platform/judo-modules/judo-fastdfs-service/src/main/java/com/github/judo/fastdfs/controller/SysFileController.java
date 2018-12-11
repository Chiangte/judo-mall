package com.github.judo.fastdfs.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.judo.common.util.Query;
import com.github.judo.common.util.R;
import com.github.judo.common.web.BaseController;
import com.github.judo.fastdfs.model.entity.SysFile;
import com.github.judo.fastdfs.service.SysFileService;
import com.github.judo.fastdfs.utils.FastDFSClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @Auther: judo
 * @Description: 公用文件 前端控制器
 * @Date 2018-10-11 21:43:36
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sys/file")
@Api(tags = "公用文件")
public class SysFileController extends BaseController {

    @Autowired
    private SysFileService sysFileService;

    @Autowired
    private FastDFSClient fastDFSClient;

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("通过ID查询")
    public SysFile sysFile(@PathVariable Integer id) {
        return sysFileService.selectById(id);
    }

    /**
     * 分页查询公用文件
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @GetMapping("/sysFilePage")
    @ApiOperation("分页查询公用文件")
    public Page sysFilePage(@RequestParam Map<String, Object> params) {
        return sysFileService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加公用文件
     *
     * @param sysFile 公用文件
     * @return success、false
     */
    @PostMapping
    @ApiOperation("添加公用文件")
    public R<Boolean> sysFile(@RequestBody SysFile sysFile) {
        return new R<>(sysFileService.insert(sysFile));
    }

    /**
     * 修改公用文件
     *
     * @param sysFile 公用文件
     * @return success/false
     */
    @PutMapping
    @ApiOperation("修改公用文件")
    public R<Boolean> editSysFile(@RequestBody SysFile sysFile) {
        return new R<>(sysFileService.updateById(sysFile));
    }

    /**
     * 删除公用文件
     *
     * @param id   ID
     * @param type 类型
     * @return R
     */
    @DeleteMapping("/{id}/{type}")
    @ApiOperation("删除公用文件")
    public R<Boolean> deleteDict(@PathVariable Integer id, @PathVariable String type) {
        return new R<>(sysFileService.deleteById(id));
    }

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
    @PostMapping("/upload/bytes/{id}")
    @ApiOperation("文件上传 文件字节")
    public String uploadFile(@PathVariable("id") String id, @RequestParam("bytes") byte[] bytes, @RequestParam("fileName") String fileName, @RequestParam("fileSize") long fileSize, @RequestParam("extension") String extension) {
        String filePath = fastDFSClient.uploadFile(bytes, fileSize, extension);
        SysFile sysFile = new SysFile(fileName, extension, null, fileSize, filePath, id);
        sysFileService.insert(sysFile);
        return filePath;
    }

    /**
     * 文件上传
     *
     * @param: multipartFile 表单提交文件
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:40
     * @return: java.lang.String
     */
    @PostMapping("/upload/file/{id}")
    @ApiOperation("文件上传 表单提交文件")
    public String uploadFile(@PathVariable("id") String id, @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String filePath = fastDFSClient.uploadFile(file, extension);
        SysFile sysFile = new SysFile(fileName, extension, null, file.getSize(), filePath, id);
        sysFileService.insert(sysFile);
        return filePath;
    }

    /**
     * 文件下载
     *
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:43
     * @return: byte[]
     */
    @GetMapping("/download/byte")
    @ApiOperation("文件下载 byte[]")
    public byte[] downloadFileByte(@RequestParam("fileUrl") String fileUrl) {
        return fastDFSClient.downloadFileByte(fileUrl);
    }

    /**
     * 文件下载
     *
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:45
     * @return: java.io.InputStream
     */
    @GetMapping("/download/input/stream")
    @ApiOperation("文件下载 InputStream")
    public InputStream downloadFileInputStream(@RequestParam("fileUrl") String fileUrl) {
        return fastDFSClient.downloadFileInputStream(fileUrl);
    }

    /**
     * 文件下载
     *
     * @return
     */
    @ApiOperation("文件下载")
    @GetMapping("/download")
    public void downLoad(@RequestParam("fileUrl") String fileUrl, @RequestParam("fileName") String fileName, HttpServletResponse response) throws IOException {

        // 获取文件
        byte[] bytes = fastDFSClient.downloadFileByte(fileUrl);

        //设置相应类型application/octet-stream        （注：applicatoin/octet-stream 为通用，一些其它的类型苹果浏览器下载内容可能为空）
        response.reset();
        response.setContentType("applicatoin/octet-stream");
        //设置头信息                 Content-Disposition为属性名  附件形式打开下载文件   指定名称  为 设定的fileName
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 写入到流
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes);
        out.close();
    }

    /**
     * 删除文件
     *
     * @param: fileUrl 文件URL
     * @auther: xiangjunzhong@qq.com
     * @date: 2018/10/13 11:47
     * @return: boolean
     */
    @DeleteMapping("/delete/file/{id}")
    @ApiOperation("删除文件")
    public boolean deleteFile(@PathVariable("id") String id, @RequestParam("fileUrl") String fileUrl) {
        fastDFSClient.deleteFile(fileUrl);
        sysFileService.delete(new EntityWrapper<SysFile>().eq("service_id", id).eq("file_path", fileUrl));
        return true;
    }
}