package com.example.bbc_rss;

// THIS CLASS STORES TOP STORY ITEMS

public class TopStory
{

    private String title;
    private String description;
    private String pubDate;

    // Default Constructor
    public TopStory()
    {
        this.title="";
        this.description="";
        this.pubDate="";
    }

    ///////////////////////////////////////////////////////////
    // GETTERS AND SETTERS FOR PRIVATE VARIABLES
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }


    ///////////////////////////////////////////////////////////
    // PUTS THE INFORMATION INTO ONE STRING

    public String toString()
    {
        String topStory = "";
        topStory += "==========================" + "\n"
                +title + "\n"
                +"==========================" + "\n"
                +pubDate     + "\n"
                +"==========================" + "\n"
                +description + "\n"
                +"==========================" + "\n";

        return topStory;
    }





}