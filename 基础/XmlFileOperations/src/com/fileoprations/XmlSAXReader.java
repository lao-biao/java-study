package com.fileoprations;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.lang.*;

public class XmlSAXReader {
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        SAXHandler handler = new SAXHandler();
        parser.setContentHandler(handler);
        parser.parse("fonts.xml");
        System.out.println(handler.getNameList());
    }
}

