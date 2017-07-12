package com.JASearcher;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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
}
