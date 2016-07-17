package erloader.extractor;

import javax.inject.Named;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Named
public class XMLDownloader extends FileDownloader {

    public File getTargetFile() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
        String name = ldt.format(formatter);
        String path = dataLocation.getLocalDataLocation();
        String fullName = path + name + ".xml";
        return new File(fullName);
    }

    @Override
    public String toString() {
        return "URLDownloader{" +
                "path='" + dataLocation.getLocalDataLocation() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XMLDownloader that = (XMLDownloader) o;

        return !(dataLocation != null ? !dataLocation.equals(that.dataLocation) : that.dataLocation != null);

    }

    @Override
    public int hashCode() {
        return dataLocation != null ? dataLocation.hashCode() : 0;
    }
}
