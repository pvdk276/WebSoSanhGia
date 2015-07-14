/**
 * Util class
 * @author Linh
 * 
 */
package com.webss.module;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.webss.model.Product;

public class Util {
	
	/**
	 * <Get connect to url>
	 * @param url
	 * @return doc
	 * @throws IOException
	 */
	public static Document getConnect(String url) throws IOException{
		Document doc=Jsoup.connect(url).header("Accept-Encoding", "gzip,deflate").maxBodySize(0).timeout(6000000).get();
		return doc;
	}
	
	/**
	 * <Read XML File>
	 * @param path
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static HashMap<String,String> readXML(String path) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		HashMap<String, String> site=new HashMap<String, String>();
		FileInputStream file = new FileInputStream(new File("//resources/site.xml"));
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
         
        DocumentBuilder builder =  builderFactory.newDocumentBuilder();
         
        Document xmlDocument = (Document) builder.parse(file);

        XPath xPath =  XPathFactory.newInstance().newXPath();
		String expression = "/site/item";
		System.out.println(expression);
		Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
		if(null != node) {
			Object nodeList = node.getChildNodes();
			for (int i = 0;null!=nodeList && i < ((NodeList) nodeList).getLength(); i++) {
				Node nod = (Node) ((NodeList) nodeList).item(i);
				if(nod.getNodeType() == Node.ELEMENT_NODE)
					System.out.println(((NodeList) nodeList).item(i).getNodeName() + " : " + nod.getFirstChild().getNodeValue()); 
			}
		}
		return site;
	}
	
	public static ArrayList<Product> init(String item) throws IOException{
		String url="http://websosanh.vn/s/"+item.replace(" ", "+")+".htm";
		String name="";
		Elements elements=ElementUtil.getElements(url,name);
		ArrayList<Product> products=SearchProduct.getInfoProduct(elements);
		return products;
		
	}
	
	public static ArrayList<Product> initCategory(String item) throws IOException{
		String url="http://websosanh.vn/"+item;
		String name="";
		Elements elements=ElementUtil.getElements(url,name);
		ArrayList<Product> products=SearchProduct.getInfoProductCategory(elements);
		return products;
		
	}
		
}
