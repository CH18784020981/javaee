package club.banyuan.servlet.file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static club.banyuan.servlet.file.Constraint.FILE_STORE_PATH;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/6 8:08 上午
 **/
@WebServlet(name = "FileUploadServlet", urlPatterns = "/file/upload")
public class FileUploadServlet extends HttpServlet {

    private static final int MAX_FILE_SIZE = 50 * 1024 * 1024; // 50M

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException,
            IOException {
        try {
            if (!ServletFileUpload.isMultipartContent(request)) {
                System.out.println("表单必须包含 enctype=multipart/form-data");
                return;
            }
            File file = new File(FILE_STORE_PATH);
            if (!file.isDirectory() || !file.exists()) {
                file.mkdirs();
            }

            List<FileItem> formItems = parseFileItems(request);

            FileItem item = formItems.get(0);
            if (!item.isFormField()) {
                String fileName = item.getName();
                String filePath = FILE_STORE_PATH + fileName;

                saveFile(item, filePath);
                response.getWriter().println(fileName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveFile(FileItem item, String filePath) {
        File storeFile = new File(filePath);

        if (storeFile.exists()) {
            storeFile.delete();
        }

        try {
            System.out.println("文件大小:" + item.getSize());
            item.write(storeFile);
            System.out.println("保存文件成功,路径:" + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<FileItem> parseFileItems(HttpServletRequest request) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        servletFileUpload.setFileSizeMax(MAX_FILE_SIZE);
        servletFileUpload.setHeaderEncoding("UTF-8");
        try {
            return servletFileUpload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {

    }
}
