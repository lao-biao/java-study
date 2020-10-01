package com.fileoprations;

import javax.xml.stream.*;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class StaxReader {
    public static void main(String[] args) {
        staxReaderByStream();
        System.out.println("-------------分割线-------------");
        staxReaderByEvent();
    }

    /**
     * 事件模式
     */
    private static void staxReaderByEvent() {
        String xmlFile = "fonts.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        boolean isName = false;
        try {
            //创建基于迭代器的事件读取器对象
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileReader(xmlFile));
            //遍历event迭代器
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                //事件对象是元素的开始
                if (xmlEvent.isStartElement()) {
                    //转换为开始元素事件对象
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("name"))
                        isName = true;
                    //获取所有属性
                    Iterator attr = startElement.getAttributes();
                    while (attr.hasNext())
                        System.out.println(attr.next());
                }
                //事件对象是正文
                if (xmlEvent.isCharacters()) {
                    //获取正文内容
                    String data = xmlEvent.asCharacters().getData();
                    //打印内容
                    if (isName && data != null && data.trim().length() != 0)
                        System.out.println(data);
                }
                //事件对象是元素结束
                if (xmlEvent.isEndElement()) {
                    //将事件对象转换成元素结束
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("name"))
                        isName = false;
                }
            }
            //结束
            xmlEventReader.close();
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    /**
     * 流模式
     */
    private static void staxReaderByStream() {
        String xmlFile = "fonts.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = null;

        try {
            xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileReader(xmlFile));
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
        //基于指针的遍历
        try {
            if (xmlStreamReader != null) {
                while (xmlStreamReader.hasNext()) {
                    int event = xmlStreamReader.next();
                    //元素的开始
                    if (event == XMLStreamConstants.START_ELEMENT)
                        //打印<font>的name标签的内容
                        if ("name".equals(xmlStreamReader.getLocalName()))
                            System.out.println("name:" + xmlStreamReader.getElementText());
                }
                //关流
                xmlStreamReader.close();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
