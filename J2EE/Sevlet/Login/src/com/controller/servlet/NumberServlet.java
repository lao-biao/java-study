package com.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.*;

/**
 * @author 周
 * @title NumberServlet
 * @date 2020/6/15 11:44
 * @description 网站浏览量计数器
 */
public class NumberServlet extends HttpServlet {

    // 覆写init初始化方法，将数据读取到ServletContext对象中
    @Override
    public void init() throws ServletException {
        // 获取文件中的计数器数据
        // 获取文件路径
        String path = this.getServletContext().getRealPath("/nums/number.txt");
        // 声明流对象
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String num = br.readLine();
            this.getServletContext().setAttribute("number", Integer.parseInt(num));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 覆写销毁方法，存储计数器到文件中
    @Override
    public void destroy() {
        // 获取网页计数器
        int num = (int) this.getServletContext().getAttribute("number");

        // 获取文件路径
        String path = this.getServletContext().getRealPath("/nums/number.txt");
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);

            bw.write(num + "");
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
