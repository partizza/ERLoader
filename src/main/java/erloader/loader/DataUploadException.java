package erloader.loader;


public class DataUploadException extends RuntimeException {

    public DataUploadException(String message) {
        super(message);
    }

    public DataUploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
