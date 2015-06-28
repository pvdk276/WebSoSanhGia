package com.webss.module;


import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webss.model.Product;

public class SearchProduct {

	/**
	 * <Parse product info from source website list>
	 * @param elements
	 * @return
	 */
	public static ArrayList<Product> getInfoProduct(Elements elements){
		ArrayList<Product> products=new ArrayList<Product>();
		for(Element e: elements){
			for(Element row: e.select("tr")){
				//ArrayList<String> content=new ArrayList<String>();
				//Elements col=row.select("td");
				//System.out.println(col.get(0).text());
				//String[] content=col.get(0).text().split(" ");
				//products.add(new Product("", "", col.get(1).text(), "", ""));
				String name="";
				String store="";
				String storeUrl="";
				String imageUrl="";
				String price="";
				Element col=row.select("td").first();
				name=col.select("h3").text();
				store="";
				storeUrl=col.select("cite").text();
				imageUrl="";
				price=col.select("div[class=product-col2] > p").select("strong:not([span])").text().split(" ")[0];										

				if(storeUrl.contains("/"))
				products.add(new Product(name, store, price, storeUrl, imageUrl));
				//System.out.println(content.get(0));
			}
		}
		return products;
	}
}
