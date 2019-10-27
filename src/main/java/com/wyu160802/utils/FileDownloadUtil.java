package com.wyu160802.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author 黄明潘
 * @date 2019/10/8-19:58
 */
public class FileDownloadUtil {

    /**
     * 文件下载
     * @param fileName 文件名
     * @param filePath 文件在项目的相对路径
     * @param request
     * @param response
     * @return
     */
    public static String downloadFile(String fileName,String filePath,HttpServletRequest request, HttpServletResponse response ){

        //fileName是需要下载的文件名字
        response.setContentType("text/html;charset=utf-8");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //输出输出流
        BufferedInputStream bis=null;
        BufferedOutputStream bio=null;

        //获取文件路径
        String ctxPath =request.getSession().getServletContext().getRealPath("/")+filePath;
//        String ctxPath =request.getSession().getServletContext().getRealPath("/static/upload/");
        //文件真是存放地址
        String downloadPath=ctxPath+fileName;
        System.out.println(downloadPath);
        try {
            //获取文件长度
            long fileLength = new File(downloadPath).length();
            //设置返回头
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Length", fileLength+"");
            response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes(),"iso8859-1"));
            //获取输入输出流
            bis = new BufferedInputStream(new FileInputStream(downloadPath));
            bio = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while((bytesRead = bis.read(buff, 0, buff.length)) != -1){
                bio.write(buff, 0 , bytesRead );
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            //关闭输入流
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //关闭输出流
            if(bio!=null){
                try {
                    bio.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
