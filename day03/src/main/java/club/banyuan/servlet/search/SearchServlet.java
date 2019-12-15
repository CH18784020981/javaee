package club.banyuan.servlet.search;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/5 8:50 上午
 **/
public class SearchServlet extends HttpServlet {

    private static String[] WORDS = {"南京市", "南京大学", "南京邮电大学", "南京半圆"};

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws
            IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(),
                StandardCharsets.UTF_8));
        String target = reader.readLine();
        System.out.println(target);

        // String s = "{\"input\":\"123\"}";
        // String target = request.getParameter("input");
        JSONObject obj = JSON.parseObject(target);
        String input = obj.getString("input");
        List<String> keywords = new ArrayList<>();
        for (String s : WORDS) {
            if (s.contains(input)) {
                keywords.add(s);
            }
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().println(JSON.toJSONString(keywords));
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        doPost(request, response);
    }

}
