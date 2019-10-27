package com.wyu160802.controller;

import com.alibaba.fastjson.JSON;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Files;
import com.wyu160802.service.FilesService;
import com.wyu160802.utils.FileDownloadUtil;
import com.wyu160802.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/5-0:22
 */
@Controller
@RequestMapping("file")
public class FilesController {

    @Autowired
    private FilesService filesService;

    @ResponseBody
    @PostMapping  (value = "/uploadMul", produces = "application/json; charset=utf-8")
    public String uploadFileList(@RequestParam(value = "file") MultipartFile[] files, HttpServletRequest request) {
        //多个文件上传，返回文件上传后的名字
        BaseResult baseResult ;
        List<String> stringList = FileUploadUtil.uploadFileList(files, request);
        if (stringList != null) {
            for (String fileName : stringList) {
                String fileTitle = fileName.substring(fileName.lastIndexOf("wyu"));
                Files uploadFile = new Files();
                uploadFile.setFileName(fileName);
                uploadFile.setFileTitle(fileTitle);
                filesService.insert(uploadFile);
            }
            baseResult = BaseResult.success("上传成功");
            return JSON.toJSONString(baseResult);
        } else {
            return  null;
        }
    }

    @ResponseBody
    @GetMapping (value = "/lists", produces = "application/json; charset=utf-8")
    public String list(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                               @RequestParam(value = "pageSize",defaultValue = "6")int pageSize) {
        int page=(pageNumber - 1) * pageSize;
        List<Files> files = filesService.filesPage(page,pageSize);
        return JSON.toJSONString(files);
    }

    /**
     * 下载文件
     * @param fileName
     * @param request
     * @param response
     */
    @RequestMapping("/download")
    public String download(String fileName, HttpServletRequest request, HttpServletResponse response){
        //文件在项目的相对位置
        String filePath = "static/upload/";
        String s = FileDownloadUtil.downloadFile(fileName, filePath, request, response);
        return s;
    }

    /**
     * 上传文件页面
     * @return
     */
    @GetMapping("upload")
    public String uploadFile() {
        return "uploadFile";
    }

    /**
     * 下载文件页面
     * @param pageNumber
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("downloadLists")
    public String page(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                           @RequestParam(value = "pageSize",defaultValue = "6")int pageSize, Model model) {
        int page=(pageNumber - 1) * pageSize;
        List<Files> files = filesService.filesPage(page,pageSize);
        int filesNum = filesService.filesNum();
        model.addAttribute("total", filesNum);
        model.addAttribute("files",files);
        model.addAttribute("page", pageNumber);
        return "downloadFile";
    }

}
