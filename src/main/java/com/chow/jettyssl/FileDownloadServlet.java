package com.chow.jettyssl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: 周海明
 * Date: 2017/3/3
 * Time: 18:11
 */
public class FileDownloadServlet extends HttpServlet {
    private String enc = "utf-8";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = new File("E:\\Serv-U.zip");
        if (file.exists())  {
            int fileLength = (int) file.length();
            String filename = URLEncoder.encode(file.getName(), enc);//filename="Serv-U.zip"
            response.reset();
            response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            response.setContentLength(fileLength);//设置内容长度
            response.setCharacterEncoding("utf-8");//设置响应的编码为“utf-8”
            response.setContentType("application/octet-stream");//设置内容类型 。  .*（ 二进制流，不知道下载文件类型）
            FileInputStream inputStream = new FileInputStream(file);
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] buf = new byte[2048];
            int readLength;
            while ((readLength = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, readLength);
            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();
            response.sendRedirect("/helloworld");
        }
    }
}
