package club.banyuan;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws DocumentException, IOException {
        File file = new File("output.xml");
        if (!file.exists()) {
            file.createNewFile();
        }
        SAXReader reader = new SAXReader();
        Document document = reader.read(App.class.getClassLoader().getResourceAsStream("dev/student.xml"));
        Element school = document.getRootElement();

        Iterator<Element> iterator = school.elementIterator();
        while (iterator.hasNext()) {
            Element stu = iterator.next();
            Iterator<Element> stuNodeIterator = stu.elementIterator();
            while (stuNodeIterator.hasNext()) {
                Element elem = stuNodeIterator.next();
                System.out.println(elem.getName() + "," + elem.getText());
            }
        }
        Element newStudent = school.addElement("student");
        newStudent.addElement("name").addText("李四");
        newStudent.addElement("age").addText("12");
        XMLWriter writer = new XMLWriter(new FileWriter("output.xml"));
        writer.write(document);
        writer.close();
    }
}
