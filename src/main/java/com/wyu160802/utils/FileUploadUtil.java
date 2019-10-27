package com.wyu160802.utils;



import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SuppressWarnings({"ALL", "AlibabaClassMustHaveAuthor"})
public class FileUploadUtil {

    /**
     * 上传单个文件例子，返回上传后的文件名，上传失败则返回null
     * @param file
     * @param request
     * @return
     */
    public static String uploadFile(MultipartFile file,HttpServletRequest request){
        String fileName = "";
        String filePath = "";
        try {
            if (file != null) {
                String picture = file.getOriginalFilename();
                filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");
                fileName = UUID.randomUUID() + picture.substring(picture.lastIndexOf("."));
                // 新建文件
                File targetFile = new File(filePath, fileName);
                // 判断文件的路径是否存在
                if (!targetFile.exists()) {
                    // 如果文件不存在 在目录中创建文件夹 这里要注意mkdir()和mkdirs()的区别
                    targetFile.mkdirs();
                }
                // 保存 失败就抛异常
                file.transferTo(targetFile);

                // 执行更新图片在服务器的地址
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return fileName;
    }

    /**
     * 上传多个文件例子，返回上传后的文件名列表，上传失败则返回null
     * 单个上传错误还没处理，待更新
     * @param file
     * @param request
     * @return
     */
    public static List<String> uploadFileList(MultipartFile[] file, HttpServletRequest request){
        List<String> stringList = new ArrayList<>();
        try {
            if (file != null) {
                for (int i = 0; i < file.length; i++) {
                    String picture = file[i].getOriginalFilename();
                    String filePath = request.getSession().getServletContext().getRealPath("/static/upload/");
                    String fileName = UUID.randomUUID()+"-wyu-"+picture;
                    // 新建文件
                    File targetFile = new File(filePath, fileName);
                    // 判断文件的路径是否存在
                    if (!targetFile.exists()) {
                        // 如果文件不存在 在目录中创建文件夹 这里要注意mkdir()和mkdirs()的区别
                        targetFile.mkdirs();
                    }
                    // 传送 失败就抛异常
                    file[i].transferTo(targetFile);
                    // 执行更新图片在服务器的地址
                    stringList.add(fileName);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return stringList;
    }


}
