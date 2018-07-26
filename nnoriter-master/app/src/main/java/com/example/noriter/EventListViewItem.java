package com.example.noriter;

import android.graphics.drawable.Drawable;

/**
 * Created by 전효승 on 2018-03-10.
 */

public class EventListViewItem {
    private int eventindex ;
    private Drawable image ;
    private String title ;
    private String date ;
    private String address ;

    public void setImage(Drawable icon) {
        image = icon ;
    }
    public void settitle(String title1) {
        title = title1 ;
    }
    public void setdate(String desc) {
        date = desc ;
    }
    public void setaddress(String adress2) {
        address = adress2 ;
    }
    public void seteventindex(int pcindex1) { eventindex = pcindex1 ; }

    public Drawable getImage() {
        return this.image ;
    }
    public String gettitle() {
        return this.title ;
    }
    public String getdate() {
        return this.date ;
    }
    public String getaddress() {
        return this.address ;
    }
    public int geteventindex() { return this.eventindex ; }
}
