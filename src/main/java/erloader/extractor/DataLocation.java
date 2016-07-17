package erloader.extractor;


public class DataLocation  {

    private String originalDataLocation;

    private String localDataLocation;

    public String getLocalDataLocation() {
        return localDataLocation;
    }

    public void setLocalDataLocation(String localDataLocation) {
        this.localDataLocation = localDataLocation;
    }

    public String getOriginalDataLocation() {
        return originalDataLocation;
    }

    public void setOriginalDataLocation(String originalDataLocation) {
        this.originalDataLocation = originalDataLocation;
    }

    @Override
    public String toString() {
        return "DataLocation{" +
                "localDataLocation='" + localDataLocation + '\'' +
                ", originalDataLocation='" + originalDataLocation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataLocation that = (DataLocation) o;

        if (!originalDataLocation.equals(that.originalDataLocation)) return false;
        return localDataLocation.equals(that.localDataLocation);

    }

    @Override
    public int hashCode() {
        int result = originalDataLocation.hashCode();
        result = 31 * result + localDataLocation.hashCode();
        return result;
    }
}
