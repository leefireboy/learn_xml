/*
 * Copyright (c) 2016 Sohu TV. All rights reserved.
 */
package com.libing.util.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.libing.util.XmlDocument;

/**
 * <P>
 * Description:使用 dom4j 生成或解析 XML 文件
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年2月17日下午4:12:29
 */
public class Dom4jDemo implements XmlDocument {

    @Override
    public void createXml(String fileName) {
        /** 建立document对象 */
        Document document = DocumentHelper.createDocument();
        /** 建立XML文档的根books */
        Element booksElement = document.addElement("books");
        /** 加入一行注释 */
        booksElement.addComment("This is a test for dom4j, holen, 2004.9.11");
        /** 加入第一个book节点 */
        Element bookElement = booksElement.addElement("book");
        /** 加入show属性内容 */
        bookElement.addAttribute("show", "yes");
        /** 加入title节点 */
        Element titleElement = bookElement.addElement("title");
        /** 为title设置内容 */
        titleElement.setText("Dom4j Tutorials");
        /** 类似的完成后两个book */
        bookElement = booksElement.addElement("book");
        bookElement.addAttribute("show", "yes");
        titleElement = bookElement.addElement("title");
        titleElement.setText("Lucene Studing");
        bookElement = booksElement.addElement("book");
        bookElement.addAttribute("show", "no");
        titleElement = bookElement.addElement("title");
        titleElement.setText("Lucene in Action");
        /** 加入owner节点 */
        Element ownerElement = booksElement.addElement("owner");
        ownerElement.setText("O'Reilly");
        try {
            Writer fileWriter = new FileWriter(fileName);
            XMLWriter xmlWriter = new XMLWriter(fileWriter);
            xmlWriter.write(document);
            xmlWriter.close();
            OutputFormat format = OutputFormat.createCompactFormat();
            XMLWriter writer = new XMLWriter(System.out, format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("rawtypes")
    public void parseXml(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputXml);
            Element employees = document.getRootElement();
            for (Iterator i = employees.elementIterator(); i.hasNext();) {
                Element employee = (Element) i.next();
                for (Iterator j = employee.elementIterator(); j.hasNext();) {
                    Element node = (Element) j.next();
                    System.out.println(node.getName() + ":" + node.getText());
                }
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("dom4j parserXml");
    }

}
