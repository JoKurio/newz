package io.github.jokurio.newz;

public class News {
    private String mTitle;
    private String mAuthor;
    public String mUrl;
    private String mDate;
    private String mSection;


    public News(String mTitle, String mAuthor, String mUrl, String mDate, String mSection) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mUrl = mUrl;
        this.mDate = mDate;
        this.mSection = mSection;
    }

    public String getmTitle() {
        return mTitle;
    }


    public String getmAuthor() {
        return mAuthor;
    }


    public String getmDate() {
        return mDate;
    }


    public String getmSection() {
        return mSection;
    }


}
