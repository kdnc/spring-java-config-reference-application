package com.nuwan.model.springCoreTasks.dependencies.autoWiringCollaborators.autoWiringWithPrimaryAttribute;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date; 

public class DatePrefixGenerator implements PrefixGenerator {

    private DateFormat formatter;

    public String getPrefix() {
        return formatter.format(new Date());
    }

    public void setPattern(String pattern) {
        this.formatter = new SimpleDateFormat(pattern);
    }
}
