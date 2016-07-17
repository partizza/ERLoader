package erloader.extractor;

import java.io.File;

public interface Downloader {

    public void download();

    public File getTargetFile();
}
