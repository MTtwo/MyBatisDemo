package com.etc.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

@Controller
@RequestMapping(value = "/indexPage")
public class IndexController extends HttpServlet{
    @RequestMapping(value = "intoIndexPage")
    public String getIndexPage(Model model, HttpServletResponse response) throws Exception{

        try {
            URL resource = this.getClass().getClassLoader().getResource("");
            File file = new File("src/main/resources/properties/1/txt");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 1.获取要下载的文件的绝对路径
        String realPath = this.getServletContext().getRealPath("Z:\\"+"1.txt");
        System.out.println(realPath);
        // 2.获取要下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        // 3.设置content-disposition响应头控制浏览器弹出保存框，若没有此句则浏览器会直接打开并显示文件。中文名要经过URLEncoder.encode编码，否则虽然客户端能下载但显示的名字是乱码
        response.setHeader("content-disposition", "attachment;filename=hehe" + URLEncoder.encode(fileName, "UTF-8"));
        // 4.获取要下载的文件输入流
        InputStream in = new FileInputStream(realPath);
        int len = 0;
        // 5.创建数据缓冲区
        byte[] buffer = new byte[1024];
        // 6.通过response对象获取OutputStream流
        OutputStream out = response.getOutputStream();
        // 7.将FileInputStream流写入到buffer缓冲区
        while ((len = in.read(buffer)) > 0) {
            // 8.使用OutputStream将缓冲区的数据输出到客户端浏览器
            out.write(buffer, 0, len);
        }
        in.close();
        return "index/admin";
    }
}
