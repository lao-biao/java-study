package com.fileoprations;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomWriter {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();   //创建document结点
            if (document != null) {
                //通过document结点创建元素
                Element docx = document.createElement("document");
                Element element = document.createElement("element");
                element.setAttribute("type", "paragraph");  //设置属性
                element.setAttribute("alignment", "left");

                Element object = document.createElement("object");
                object.setAttribute("type", "text");

                Element text = document.createElement("text");
                text.appendChild(document.createTextNode("This is text node")); //元素赋值

                Element bold = document.createElement("bold");
                bold.appendChild(document.createTextNode("true"));  //元素赋值

                object.appendChild(text);   //挂载
                object.appendChild(bold);
                element.appendChild(object);
                docx.appendChild(element);
                document.appendChild(docx);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                DOMSource source = new DOMSource(document); //将结点转化成dom资源

                //创建目标文件
                File file = new File("dom.xml");
                StreamResult streamResult = new StreamResult(file);
                //将xml内容写入文件中
                transformer.transform(source, streamResult);
            }
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
