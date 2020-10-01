package com.fileoprations;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomReader {
    public static void main(String[] args) {
        recursiveTraverse();
        System.out.println("--------------------分割线--------------------");
        traverseBySearch();
    }

    /**
     * 遍历xml文档
     */
    public static void recursiveTraverse() {
        try {
            //采用DOM解析xml文件
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("fonts.xml");

            //获取所有一级子节点
            NodeList childNodes = document.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) { //1=<fonts>
                Node font = childNodes.item(i);
                NodeList fontList = font.getChildNodes();   //获取所有二级子节点
                for (int j = 0; j < fontList.getLength(); j++) {    //7=4个空格+3*<font>
                    Node fontItem = fontList.item(j);
                    if (font.getNodeType() == Node.ELEMENT_NODE) {  //获取内容
                        NodeList fontChildNodes = fontItem.getChildNodes();
                        for (int k = 0; k < fontChildNodes.getLength(); k++) {  //5=3个空格+<name>+<size>
                            Node fontNode = fontChildNodes.item(k);
                            if (fontNode.getNodeType() == Node.ELEMENT_NODE) {  //获取内容
                                System.out.println(fontNode.getNodeName() + ":" + fontNode.getTextContent());
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过标签名查找元素
     */
    public static void traverseBySearch() {
        try {
            //采用DOM解析xml文件
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("fonts.xml");

            Element rootElement = document.getDocumentElement();
            NodeList nodeList = rootElement.getElementsByTagName("name");

            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element element = (Element) nodeList.item(i);
                    System.out.println(element.getNodeName() + ":" + element.getTextContent());
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
