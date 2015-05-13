package com.nuwan.model;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date; 

public class DatePrefixGeneratorV2 implements PrefixGeneratorV2 {

    public String getPrefix() {
	DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(new Date());
    }
}
