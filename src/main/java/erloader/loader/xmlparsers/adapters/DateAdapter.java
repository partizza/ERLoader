package erloader.loader.xmlparsers.adapters;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter<String,LocalDateTime> {

    public LocalDateTime unmarshal(String date) throws Exception {
        return LocalDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public String marshal(LocalDateTime date) throws Exception {
        return date.toString();
    }
}
