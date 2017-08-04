package com.JASearcher;

import com.gargoylesoftware.htmlunit.WebClient;

public class ConstWebClient 
{
	private static WebClient webClient;
	
	public static WebClient getInstance()
	{
		if(webClient == null)
		{
			webClient = new WebClient();
			webClient.getCookieManager().setCookiesEnabled(true);
			webClient.getOptions().setJavaScriptEnabled(true);
			webClient.getOptions().setCssEnabled(false);
			webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);  
			webClient.getOptions().setThrowExceptionOnScriptError(false);
		}
		return webClient;
	}
}
