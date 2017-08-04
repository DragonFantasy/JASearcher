package com.JASearcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

public class PageContent 
{
	String page_url;
	public Document doc;
	public PageContent(String url) throws IOException
	{
		page_url = url;
		doc = Jsoup.connect(page_url)
				.userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")
				.timeout(10000)
				.get();
	}
	
	public Element getElementById(String eid)
	{
		return doc.getElementById(eid);
	}
	
	public ArrayList<Element> getElementsByIdArray(String[] eid_arr)
	{
		ArrayList<Element> ret_list = new ArrayList<Element>();
		for(String eid : eid_arr)
		{
			Element e = getElementById(eid);
			if(e != null)
			{
				ret_list.add(e);
			}
		}
		return ret_list;
	}
	
	public static void main(String args[])
	{
		try {
			/*Document login_doc = Jsoup.connect("https://www.amazon.cn/ap/signin?_encoding=UTF8&openid.assoc_handle=cnflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.cn%2Fref%3Dnav_ya_signin%3Ftag%3Dzcn0e-23")
								.userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")
								.timeout(10000)
								.get();
			HashMap login_hidden_data = new HashMap();
			Elements hidden_elements = login_doc.getElementsByTag("form").get(0).getElementsByTag("input"); 
			Iterator elements_it = hidden_elements.iterator();
			while(elements_it.hasNext())
			{
				Element e = (Element)elements_it.next();
				if(e.attr("type").equals("hidden"))
				{
					login_hidden_data.put(e.attr("name"), e.attr("value"));
				}
			}
			login_hidden_data.put("email", "13761520586");
			login_hidden_data.put("password", "880717");
			login_hidden_data.put("remenberMe", "true");
			Response res = Jsoup
				    .connect("https://www.amazon.cn/ap/signin?_encoding=UTF8&openid.assoc_handle=cnflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.cn%2Fref%3Dnav_ya_signin%3Ftag%3Dzcn0e-23")
				    .data(login_hidden_data)
				    .method(Method.POST)
				    .execute();
			Map<String, String> cookies_map = res.cookies();*/
//			HashMap cookies_map = new HashMap();
//			cookies_map.put("session-id", "461-4390643-8261611");
//			cookies_map.put("session-id-time", "2082729601l");
//			cookies_map.put("session-token", "\"2TRxtYR6YLuQrDNzmkNLpT0E3ztWRJ9Jef8IEwXrLKszDagCWQkIdAq5eBiqLN0V76OuHMDPdun+rOpf/cdmHtDqlfVFOVL4lKlZ1urEZsvs1QSfdCJnou1wjXSUr/IWMi3bNUU+VUKySi2nZJWZAQjoGUhdIjlfwrnPeOmFAS+3/AZSmQX2WkptVn7OE5ubt6t2KOx/ayiggy3OrhZpVExy4rpgyadkbwGnjDgTWxoTmSZBkOsKdMW5L3aryT2qltCyK+ImmU8=\"");
//			cookies_map.put("ubid-acbcn", "457-2562809-1587957");
//			cookies_map.put("at-main", "Atza|IwEBIJ3JEqlc1-5FfxZ_wpF5Q69dgdoUjsmuR7H6CaXY9ZSLCK2BxO0XyTXda56BlbRlkPsAOk7OdMuVkfUzaavbdHAbFbB9wNinkYZe78ZNdJFA5Tt-qWVXVKv8guNatGm5tpwAggwNtHXKzuCjlunVLFsbfAdF9DP33h_CLghfjyFNjdxE-s5kfPnLvDL_2ahTqMI1kloJ1CLEEoU-S9UhrUmcSENwFXrQPVij0-HHTEVcLtYCkYcaBXw-8vq4iVj8a_Ioik4aH0xw-wx8s2KNJnfG8tiRT3eWEtKC-h_sy-EZ7pFQ2pJMEz6WDbLfAi9TWiXyDyXa5ZJr5AOWrvnGM3_UicRCtBFdZmmsReVSsx7TAyGs9qznuizqhWXAjluS5yqyCUOjq9D72jzUrRzLZQwT");
//			cookies_map.put("x-acbcn", "\"F7BNymFxHd7Q0R5puBCP9cnqoaFALZU7WcdgfhtFEew5X??PzYphD9r0LvtAN7T3\"");
//			cookies_map.put("ap-fid", "");
//			cookies_map.put("a-ogbcbff", "1");
			
//			String cookie_str = "a-ogbcbff=1; x-wl-uid=1DMOUaWjqE/79/HCmmD2NkqU1WlHgu82SmqJZzq80aXgCA2SMmRE23/TmZ5pzPGuzEehsKfjfE1MGwpDq/6SsZ0sGMkAZS2jp8jheBASguo8p8WVnBy8v34m8W8Tyl24NJzgy1dmEr9s=; x-acbde=RphKlJl1MlNnUSCypATXMphmnTBf6ksj; session-token=U+ZH7XJPKpQ+uYVp8zmrwd8NSNG44K9xYIG4aOIaKOb9Eik1B+CZ2A7jn0nPPUUChbfs6Fp+6RcQ0KkzZNatKRb9ff3dm0X0OTgV36BDU8yo6ZiyjWUNoLShrDp9CNNzJO4J8a8aq3CYrryEwB3C9+vpouevPnBhcIKLoWw+ecoYZe8Yekc5kcgc0Rmr6XtrrsBT08IXNmXyAl7+XjpC6MikJc/7DHy263wquSrOLsB7XUjzidsWZ58jl4z6gYqeJIbHN0WXC7sTO++twJYnpPd9zcBbRdgf; lc-acbde=en_GB; session-id-time=2082754801l; session-id=262-6548289-7018963; ubid-acbde=258-9562680-7484768; csm-hit=58N918HCW7ZV1Z7MQQFX+s-KSAAGS9GVSR4BZMYN29A|1501811285999";
//			String[] splited_cookie_str = cookie_str.split("; ");
//			for(String cookie : splited_cookie_str)
//			{
//				String[] key_value = cookie.split("=");
//				cookies_map.put(key_value[0], key_value[1]);
//			}
//			System.out.println(cookies_map);
			
//			Document page_doc = Jsoup.connect("https://www.amazon.de/gp/product/B07339W2V7")
//					.userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")
//					.timeout(10000)
//					.cookies(cookies_map)
//					.get();
//			System.out.println(page_doc.getElementsByClass("nav-truncate"));
			
			ConstWebClient.getInstance().getCookieManager().addCookie(new Cookie("www.amazon.cn", "session-id", "461-4390643-8261611"));
			ConstWebClient.getInstance().getCookieManager().addCookie(new Cookie("www.amazon.cn", "session-id-time", "2082729601l"));
			ConstWebClient.getInstance().getCookieManager().addCookie(new Cookie("www.amazon.cn", "session-token", "\"2TRxtYR6YLuQrDNzmkNLpT0E3ztWRJ9Jef8IEwXrLKszDagCWQkIdAq5eBiqLN0V76OuHMDPdun+rOpf/cdmHtDqlfVFOVL4lKlZ1urEZsvs1QSfdCJnou1wjXSUr/IWMi3bNUU+VUKySi2nZJWZAQjoGUhdIjlfwrnPeOmFAS+3/AZSmQX2WkptVn7OE5ubt6t2KOx/ayiggy3OrhZpVExy4rpgyadkbwGnjDgTWxoTmSZBkOsKdMW5L3aryT2qltCyK+ImmU8=\""));
			ConstWebClient.getInstance().getCookieManager().addCookie(new Cookie("www.amazon.cn", "ubid-acbcn", "457-2562809-1587957"));
			ConstWebClient.getInstance().getCookieManager().addCookie(new Cookie("www.amazon.cn", "at-main", "Atza|IwEBIJ3JEqlc1-5FfxZ_wpF5Q69dgdoUjsmuR7H6CaXY9ZSLCK2BxO0XyTXda56BlbRlkPsAOk7OdMuVkfUzaavbdHAbFbB9wNinkYZe78ZNdJFA5Tt-qWVXVKv8guNatGm5tpwAggwNtHXKzuCjlunVLFsbfAdF9DP33h_CLghfjyFNjdxE-s5kfPnLvDL_2ahTqMI1kloJ1CLEEoU-S9UhrUmcSENwFXrQPVij0-HHTEVcLtYCkYcaBXw-8vq4iVj8a_Ioik4aH0xw-wx8s2KNJnfG8tiRT3eWEtKC-h_sy-EZ7pFQ2pJMEz6WDbLfAi9TWiXyDyXa5ZJr5AOWrvnGM3_UicRCtBFdZmmsReVSsx7TAyGs9qznuizqhWXAjluS5yqyCUOjq9D72jzUrRzLZQwT"));
			ConstWebClient.getInstance().getCookieManager().addCookie(new Cookie("www.amazon.cn", "x-acbcn", "\"F7BNymFxHd7Q0R5puBCP9cnqoaFALZU7WcdgfhtFEew5X??PzYphD9r0LvtAN7T3\""));
			ConstWebClient.getInstance().getCookieManager().addCookie(new Cookie("www.amazon.cn", "ap-fid", ""));
			ConstWebClient.getInstance().getCookieManager().addCookie(new Cookie("www.amazon.cn", "a-ogbcbff", "1"));
			
//			HtmlPage purchase_page = goods_page.getElementById("add-to-cart-button").click();
			
			HtmlPage goods_page = ConstWebClient.getInstance().getPage("https://www.amazon.cn/gp/cart/view.html/ref=nav_cart");
			System.out.println(goods_page.getUrl());
			HtmlPage purchase_page = goods_page.getElementById("sc-buy-box-ptc-button").click();
			System.out.println(purchase_page.getUrl());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fin...");
	}
}
