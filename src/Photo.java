import java.util.Date;
import java.util.*;

/**
 * Represents a Photo object with a name, filepath, date added, and file size.
 */
public class Photo {
    private String name;
    private String filePath;
    private Date dateAdded;
    private long fileSize;

    /**
     * Constructs a new Photo object with a given name, file path, date added, and file size.
     *
     * @param name
     * @param filePath
     * @param dateAdded
     * @param fileSize
     */
    public Photo (String name, String filePath, Date dateAdded, long fileSize)
    {
        this.name = name;
        this.filePath = filePath;
        this.dateAdded = dateAdded;
        this.fileSize = fileSize;
    }

    /**
     * Returns the name of the current Photo object.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the date that the photo was added to the album.
     * @return dateAdded
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * Returns the file size of the photo.
     * @return fileSize
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * Return the file path of the photo.
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

}
