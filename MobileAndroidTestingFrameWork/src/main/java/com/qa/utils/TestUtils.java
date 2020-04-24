package com.qa.utils;

import java.io.InputStream;
import java.util.HashMap;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestUtils {
	
	public static final long WAIT= 15;
	
	public HashMap<String, String> parseStringXML(InputStream file) throws Exception{
		HashMap<String, String> stringMap = new HashMap<String, String>();
		//get document builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//build document
		Document document = builder.parse(file);
		
		//Normalize the XML structure; its just too important!!!
		document.getDocumentElement().normalize();
		
		//here comes the root node
		Element root = document.getDocumentElement();
		//System.out.println(root.getNodeName());
	
		//get all elements
		NodeList nList= document.getElementsByTagName("string");
		//System.out.println("===================================================================");
		
		for (int temp =0;temp<nList.getLength();temp++) {
			Node node = nList.item(temp);
			//System.out.println(""); //Just a seperator
			if(node.getNodeType()==Node.ELEMENT_NODE)
			{
				Element eElement = (Element)node;
				//store each element key value in map
				stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
			}
		}
		return stringMap;
	}

}
