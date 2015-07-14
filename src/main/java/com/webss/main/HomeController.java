package com.webss.main;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.webss.dal.PriceDAL;
import com.webss.dal.ProductDAL;
import com.webss.model.*;
import com.webss.module.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws IOException {

		logger.info("Home page", locale);		
		return "home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchPrice(@RequestParam("item") String searchItem, Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		logger.info("Web so sanh Search ! The client locale is {}.", searchItem);	
		
		ArrayList<Product> products=Util.init(searchItem);		
		model.addAttribute("products", products);
		return "search";
	}
	

	@RequestMapping(value = "/dienthoai", method = RequestMethod.GET)
	public String searchDienThoai(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("dien-thoai-di-dong/cat-82.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	
	@RequestMapping(value = "/maytinhbang", method = RequestMethod.GET)
	public String searchMayTinhBang(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("may-tinh-bang-tablet/cat-84.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	
	@RequestMapping(value = "/smartwatch", method = RequestMethod.GET)
	public String searchSmartWatch(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("smart-watch/cat-1885.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	
	@RequestMapping(value = "/phukiendidong", method = RequestMethod.GET)
	public String searchPhuKienDiDong(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("phu-kien-dien-thoai/cat-35.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	
	@RequestMapping(value = "/laptop", method = RequestMethod.GET)
	public String searchLaptop(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("laptop/cat-18.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	
	@RequestMapping(value = "/maytinhdeban", method = RequestMethod.GET)
	public String searchMayTinhDeBan(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("may-tinh-de-ban-desktop/cat-19.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	
	@RequestMapping(value = "/linhkienlaptop", method = RequestMethod.GET)
	public String searchLinhKienLapTop(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("linh-kien-laptop/cat-21.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	
	@RequestMapping(value = "/linhkienpc", method = RequestMethod.GET)
	public String searchLinhKienPC(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("linh-kien-may-tinh/cat-75.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	@RequestMapping(value = "/phanmem", method = RequestMethod.GET)
	public String searchPhanMem(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("phan-mem-tin-hoc/cat-1864.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	
	@RequestMapping(value = "/dieuhoa", method = RequestMethod.GET)
	public String searchDieuHoa(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("dieu-hoa/cat-51.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	
	@RequestMapping(value = "/tulanh", method = RequestMethod.GET)
	public String searchTuLanh(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("tu-lanh/cat-60.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	@RequestMapping(value = "/tumat", method = RequestMethod.GET)
	public String searchTuMat(Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {

		
		
		ArrayList<Product> products=Util.initCategory("tu-mat/cat-53.htm");		
		model.addAttribute("products", products);
		return "category";
	}
	
	@RequestMapping(value = "/bieudo", method = RequestMethod.GET)
	public String xemBieuDo(@RequestParam("productName") String productName,@RequestParam("productStoreUrl") String productStoreUrl,Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException, SQLException {
		model.addAttribute("productName", productName);
		//Get product id
		ProductDAL productdal = new ProductDAL();
		ResultSet rs = null;
		rs = productdal.selectProductByNameAndStore(productName, productStoreUrl);
		int id = 0;
		while(rs.next()){
			id = Integer.parseInt(rs.getString("productID"));
		}
		rs = null;	
		//get price by product id
		PriceDAL pricedal = new PriceDAL();
		rs = pricedal.getPriceById(id);
		
		//price to list
		LinkedList<Price> lPrice = new LinkedList<Price>();
		while (rs.next()) {
	        lPrice.add(new Price(rs.getInt("productID"),
	        					rs.getDate("priceDate"),
	        				     rs.getInt("price")
	        				     ));
	    }
		model.addAttribute("prices", lPrice);
		String jsonPrice = this.getJsonString(lPrice);
		model.addAttribute("jsPrice", jsonPrice);
		return "bieudo";
	}
	
	private String getJsonString(LinkedList<Price> lPrice) {
	    Gson gson = new Gson();
	     gson = new GsonBuilder()
	        .excludeFieldsWithoutExposeAnnotation()
	        .create();
	    return gson.toJson(lPrice);
	}
	
	@RequestMapping(value = "/sosanh", method = RequestMethod.POST)
    public String sosanh(@RequestParam("productStoreUrl") String productStoreUrl,Model model) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
            Document doc=Util.getConnect(productStoreUrl);
            Elements elements=doc.select("div[class=store-item]");
            ArrayList<Product> products=new ArrayList<Product>();
            for (Element element : elements) {
                    String name=element.select("div[class=store-item-col3] > h3 > a").text();
                    String price=element.select("div[class=store-item-col2 ] > p").select("strong:not([span])").text().split(" ")[0];
                    String store=element.select("div[class=store-item-col1] > a").select("img").attr("src");
                    String storeImage=element.select("div[class=store-item-col1] > a").select("img").attr("alt");
                    String imageUrl="";
                    products.add(new Product(name, store, price, storeImage, imageUrl));
            }
            model.addAttribute("products",products);
            return "sosanh";
    }
	
}
