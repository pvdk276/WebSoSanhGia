package com.webss.module;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;



import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

public class SnipperData {
	
	/**
	 * <Get data form Site>
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void GetSnipperData() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		HashMap<String, String> site=Util.readXML(null);
		@SuppressWarnings("unchecked")
		ArrayList<String> sites=(ArrayList<String>) site.clone();
		for(String s:sites){
			Elements elements=ElementUtil.getElements(site.toString(), s);
			SearchProduct.getInfoProduct(elements);
		}
	}
}
