package club.banyuan.user.util;

import club.banyuan.user.module.UserVo;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/4 1:46 下午
 **/
public class JsonUtil {

    public static <T> T parseReq(HttpServletRequest request, Class<T> module) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(),
                StandardCharsets.UTF_8))) {
            String s = reader.readLine();
            return JSON.parseObject(s, module);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
