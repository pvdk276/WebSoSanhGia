/**
 * <Search Product class>
 * @author Linh
 */
package com.webss.module;


import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ElementUtil {
	
	/**
	 * <Get Elements>
	 * @param doc
	 * @param name
	 * @return elements
	 * @throws IOException 
	 */
	public static Elements getElements(String url,String name) throws IOException{
		Document doc=Util.getConnect(url);
		Elements elements=doc.select("div[class=list-product] table");
		return elements;
	}
	
}
