package com.fileoprations;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

class SAXHandler extends DefaultHandler {

    private List<String> nameList;

    private boolean isName = false;

    public List<String> getNameList() {
        return nameList;
    }

    //xml文档加载时
    @Override
    public void startDocument() throws SAXException {
        System.out.println("start document");
        nameList = new ArrayList<String>();
    }

    //xml文档解析结束
    @Override
    public void endDocument() throws SAXException {
        System.out.println("end document");
    }

    //访问某一个元素
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("start element");
        if (qName.equals("name")) {
            isName = true;
        }
    }

    //结束访问某一个元素
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("end element");
        if (isName) {
            isName = false;
        }
    }

    //访问元素正文
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            String name = new String(ch, start, length);
            nameList.add(name);
        }
    }
}
