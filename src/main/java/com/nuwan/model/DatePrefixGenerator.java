package com.nuwan.model;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date; 

public class DatePrefixGenerator implements PrefixGenerator {

 
    private DateFormat formatter;

    public void setPattern(String pattern) {
        this.formatter = new SimpleDateFormat(pattern);
    }

    public String getPrefix() {
        return formatter.format(new Date());
    }
}
