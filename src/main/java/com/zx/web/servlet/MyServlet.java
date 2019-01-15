package com.zx.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 11790 on 2019/1/8.
 */
@WebServlet(urlPatterns = "/my/servlet",
        asyncSupported=true)
//为什么需要继承HttpServlet呢，因为这是Servlet3.0规范规定的
public class MyServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext=req.startAsync();
        asyncContext.start(()->{
            try {
                resp.getWriter().println("Hello,world");
            } catch (IOException e) {
                e.printStackTrace();
            }
            asyncContext.complete();
        });
    }
}
