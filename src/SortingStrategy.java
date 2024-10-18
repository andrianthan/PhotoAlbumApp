import java.util.List;
public interface SortingStrategy
{

    /**
     * Sorts the list of photos according to a sorting strategy.
     * @param photos
     */

    void sort(List<Photo> photos);

}