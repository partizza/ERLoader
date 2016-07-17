package erloader.extractor;

import javax.inject.Inject;
import java.io.*;
import java.net.URL;

public abstract class FileDownloader implements Downloader {

    @Inject
    protected DataLocation dataLocation;

    public void download() {
        try (InputStream urlStream=  new URL(dataLocation.getOriginalDataLocation()).openStream();
             BufferedInputStream inp = new BufferedInputStream(urlStream);
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(getTargetFile()))) {
            int data = inp.read();
            while (data > -1) {
                out.write(data);
                data = inp.read();
            }
            out.flush();
        } catch (IOException e) {
            throw new IncorrectSourceException("Can't download file.", e);
        }
    }

    public abstract File getTargetFile();
}
