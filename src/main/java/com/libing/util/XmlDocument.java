/*
 * Copyright (c) 2016 Sohu TV. All rights reserved.
 */
package com.libing.util;

/**
 * <P>
 * Description:定义 XML 文件生成或解析的接口
 * </p>
 * @author "libing"
 * @version 1.0
 * @Date 2016年2月17日下午4:08:50
 */
public interface XmlDocument {

    public void createXml(String fileName);

    public void parseXml(String fileName);

}

