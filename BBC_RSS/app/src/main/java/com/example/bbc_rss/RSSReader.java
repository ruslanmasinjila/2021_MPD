package com.example.bbc_rss;

import java.net.*;
import java.io.*;

public class RSSReader
{
    private String urlString = "https://feeds.bbci.co.uk/news/rss.xml";
    private String rssString = "";

    public String getRssString()
    {
        return rssString;
    }

    public void FetchRSS()
    {
        try
        {
            URL url = new URL(urlString);
            URLConnection conn = (URLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            while ((inputLine = in .readLine()) != null)
            {
                rssString += inputLine;
            }
            in .close();

        }

        catch (Exception e)

        {
            System.out.println(e.toString());
        }

    }

    public String getRSSString()
    {
        return rssString;
    }



}