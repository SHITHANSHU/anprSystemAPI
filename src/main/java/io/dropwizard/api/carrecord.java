package io.dropwizard.api;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class carrecord {
    private int tollamount;
    private String tollcode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    public carrecord(int tollamount, Date date, String tollcode)
    {
        this.tollamount = tollamount;
        this.date = date;
        this.tollcode = tollcode;
    }

    public carrecord(int tollamount,String date,String tollcode) throws ParseException
    {
        this.tollamount=tollamount;
        this.tollcode=tollcode;
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
        this.date=date1;
        System.out.println("date "+ date);
    }

    public carrecord(int tollamount, String tollcode) {
        this.tollamount = tollamount;
        this.tollcode = tollcode;
    }

    public int getTollamount() {
        return tollamount;
    }

    public void setTollamount(int tollamount) {
        this.tollamount = tollamount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTollcode() {
        return tollcode;
    }

    public void setTollcode(String tollcode) {
        this.tollcode = tollcode;
    }
}
