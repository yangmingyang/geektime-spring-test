package cn.mingyang.web.w05_servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 案例：
 * 文件下载需求：
 * 1.页面显示超链接
 * 2.点击超链接后弹出下载提示框
 * 3.完成图片文件下载
 *
 *  还要注意一个问题：中文乱码问题
 */
@WebServlet("/Demo03_servletContext_download")
public class Demo03_servletContext_download extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");

        String agent = req.getHeader("user-agent");
        //避免中文乱码
        fileName = DownLoadUtils.getFileName(agent, fileName);

        ServletContext servletContext = req.getServletContext();
        String mimeType = servletContext.getMimeType(fileName);
        if ("image/jpeg".equals(mimeType)) {
            System.out.println("该下载图片了");
        }
        //2.点击超链接后弹出下载提示框
        //设置响应头类型
        resp.setHeader("content-type", mimeType);
        //设置响应头打开的方式
        resp.setHeader("content-disposition", "attachment;filename=" + fileName);
        //获取文件的路径
        String realPath = servletContext.getRealPath("\\WEB-INF\\image\\" + fileName);
        System.out.println(realPath);

        FileInputStream fis = new FileInputStream(realPath);
        int len = 0;
        byte[] bytes = new byte[1024 * 8];
        ServletOutputStream ops = resp.getOutputStream();

        while ((len = fis.read(bytes)) != -1) {
            ops.write(bytes, 0, len);
        }

        fis.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
