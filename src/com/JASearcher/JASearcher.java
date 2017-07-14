package com.JASearcher;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.jsoup.nodes.Element;

public class JASearcher 
{
	public static String SEARCH_URL = "https://www.amazon.co.jp/s/ref=nb_sb_noss?__mk_ja_JP=%E3%82%AB%E3%82%BF%E3%82%AB%E3%83%8A&url=search-alias%3Dvideogames&field-keywords=%E3%83%8B%E3%83%B3%E3%83%86%E3%83%B3%E3%83%89%E3%83%BC%E3%82%AF%E3%83%A9%E3%82%B7%E3%83%83%E3%82%AF%E3%83%9F%E3%83%8B";
	
	public static void main(String[] args)
	{
		System.out.println("start time");
		System.out.println(new Date());
		Runnable main_loop = new Runnable() {
			@Override
			public void run() 
			{
				System.out.println("main loop active");
				boolean flag = true;
				while(flag)
				{
					try {
						PageContent page = new PageContent(SEARCH_URL);
						ArrayList<Element> element_list = page.getElementsByIdArray(new String[]{"result_0", "result_1", "result_2", "result_3", "result_4"});
						for(Element e : element_list)
						{
							String sub_page_link = e.getElementsByClass("s-access-detail-page").attr("href");
							String goods_title = e.getElementsByClass("s-access-detail-page").text();
							if(goods_title.indexOf("ニンテンドークラシックミニ スーパーファミコン") < 0)
							{
								continue;
							}
							PageContent sub_page = new PageContent(sub_page_link);
							String merchant_tag = sub_page.getElementById("merchant-info").html();
							String maker_name = sub_page.getElementById("brand").text();
							String merchant_logo = merchant_tag.substring(merchant_tag.indexOf("この商品は、")+6, merchant_tag.indexOf("が販売"));
							String merchant_name = merchant_logo.substring(merchant_logo.indexOf(">")+1, merchant_logo.indexOf("</"));
							if(merchant_name.equals("Amazon.co.jp"))
							{
								System.out.println(goods_title);
								System.out.println(sub_page_link);
								System.out.println(maker_name);
								Mail.sendMail("sfc mini到货啦", goods_title+"到货啦！<br>"+sub_page_link, "xiagxnnlx@126.com");
								flag = false;
							}
						}
					} 
					catch (Exception e) 
					{
						System.out.println(new Date());
						if(e instanceof SocketTimeoutException)
						{
							System.out.println("time out");
						}
						else
						{
							e.printStackTrace();
						}
					}
					finally
					{
						try 
						{
							Thread.sleep(60*1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		};
		main_loop.run();
		
		Runnable metroid_loop = new Runnable() {
			@Override
			public void run() 
			{
				System.out.println("metroid loop active");
				ArrayList<String> url_list = new ArrayList<String>();
				url_list.add("https://www.amazon.co.uk/dp/B07339W2V7/ref=olp_product_details?_encoding=UTF8&me=A3P5ROKL5A1OLE");
				url_list.add("https://www.amazon.fr/dp/B07339W2V7/ref=olp_product_details?_encoding=UTF8&me=A1X6FK5RDHNB96");
				url_list.add("https://www.amazon.de/gp/product/B07339W2V7");
				url_list.add("https://www.amazon.it/Metroid-Returns-Collectors-Limited-Nintendo/dp/B073Q3RG39/ref=sr_1_2?s=videogames&ie=UTF8&qid=1499746896&sr=1-2&keywords=samus");
				url_list.add("https://www.amazon.es/Metroid-Samus-Returns-Edici%C3%B3n-Legacy/dp/B07339W2V7/ref=zg_bs_videogames_9?_encoding=UTF8&psc=1&refRID=6Q9584BX5EVRJ6188697");
				while(url_list.size() > 0)
				{
					try {
						for(int i = url_list.size() - 1; i >= 0; i--)
						{
							String url = url_list.get(i);
							PageContent page = new PageContent(url);
							Element buy_element = page.getElementById("add-to-cart-button");
							if(buy_element == null)
							{
								continue;
							}
							String title_name = page.getElementById("productTitle").text();
							System.out.println(buy_element);
							System.out.println(title_name);
							Mail.sendMail(title_name+"到货啦", title_name+"到货啦！<br>"+url, "843801972@qq.com");
							url_list.remove(url);
						}
					} 
					catch (Exception e) 
					{
						System.out.println(new Date());
						if(e instanceof SocketTimeoutException)
						{
							System.out.println("time out");
						}
						else
						{
							e.printStackTrace();
						}
					}
					finally
					{
						try 
						{
							Thread.sleep(60*1000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		};
		
		metroid_loop.run();
	}
}
