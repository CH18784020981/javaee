package club.banyuan.servlet.file;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/6 8:08 上午
 **/
@WebServlet(name = "FileDownloadServlet", urlPatterns = "/file/download")
public class FileDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException,
            IOException {
        String fileName = request.getParameter("file");

        File file = new File(Constraint.FILE_STORE_PATH, fileName);

        long fileLength = file.length();
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setHeader("Content_Length", fileLength + "");
        try (FileInputStream inputStream = new FileInputStream(file); OutputStream out = response.getOutputStream()) {

            int readBytes = 0;
            byte[] buffer = new byte[512];
            while ((readBytes = inputStream.read(buffer)) > 0) {
                out.write(buffer, 0, readBytes);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        doPost(request, response);
    }
}
