/*
 * Copyright (c) 2016 Sohu TV. All rights reserved.
 */
package com.libing.test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Ignore;
import org.junit.Test;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年2月18日上午10:17:19
 */
@SuppressWarnings("unchecked")
public class Dom4jforXML {

//    @Ignore
    @Test
    public void test() throws Exception {
        // 创建 SAXReader 对象
        SAXReader reader = new SAXReader();
        // 读取文件转换成 Document
        Document document = reader.read(
                new File("test.xml"));
        // 获取根节点元素对象
        Element root = document.getRootElement();
        // 遍历
        listNodes(root);
    }

    @Ignore
    @Test
    public void test1() throws Exception {
        // 创建 SAXReader 对象
        SAXReader reader = new SAXReader();
        // 读取文件 转换成 Document
        Document document = reader.read(
                new File("test.xml"));
        // 获取根节点元素对象
        Element root = document.getRootElement();
        System.out.println("-------添加节点前------");
        // 获取节点 book
//        Element book1Element = root.element("book");
        Iterator<Element> iterator = root.elementIterator();
        if (iterator.hasNext()) {
            Element book1 = iterator.next();
            // 遍历
            listNodes(book1);
            // 添加phone节点
            Element phoneElement = book1.addElement("copyright");
            // 为phone节点设置值
            phoneElement.setText("ice_lee");
            System.out.println("-------添加节点后------");
            listNodes(book1);
        } else {
            return ;
        }
//        // 遍历
//        listNodes(book1Element);
//        // 添加phone节点
//        Element phoneElement = book1Element.addElement("name");
//        // 为phone节点设置值
//        phoneElement.setText("老人与海");
//        System.out.println("-------添加节点后------");
//        listNodes(book1Element);
    }

    private void listNodes(Element node) {
        System.out.println("当前节点的名称：" + node.getName());
        // 首先获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        // 遍历属性节点
        for (Attribute attribute : list) {
            System.out.println("属性" + attribute.getName() + ":" + attribute.getValue());
        }
        // 如果当前节点内容不为空，则输出
        if (!(node.getTextTrim().equals(""))) {
            System.out.println(node.getName() + "：" + node.getText());
        }
        // 同时迭代当前节点下面的所有子节点
        // 使用递归
        Iterator<Element> iterator = node.elementIterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();
            listNodes(e);
        }
    }

}