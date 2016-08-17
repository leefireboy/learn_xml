/*
 * Copyright (c) 2016 Sohu TV. All rights reserved.
 */
package com.libing.test;

import org.junit.Test;

import com.libing.util.XmlDocument;
import com.libing.util.impl.Dom4jDemo;

/**
 * <P>
 * Description:
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年2月17日下午4:32:48
 */
public class XmlTest {
    private XmlDocument xmlDocument;

    @Test
    public void xmlTest() {
        xmlDocument = new Dom4jDemo();
        xmlDocument.createXml("test.xml");
    }

}

