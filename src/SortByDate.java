import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Sorts the list of photos by the date added in ascending order.
 */
public class SortByDate implements SortingStrategy {

    /**
     * Sorts the list of photos by the date they were added in ascending order.
     * Prints the sequence of photos in the photo album after sorting.
     * @param photos
     */
    @Override
    public void sort(List<Photo> photos) {
        Collections.sort(photos, new Comparator<Photo>() {
            @Override
            public int compare(Photo p1, Photo p2) {
                return p1.getDateAdded().compareTo(p2.getDateAdded());
            }
        });

        System.out.println("Sorted by date.");
        for(Photo p: photos)
        {
            System.out.println(p.getName()+ " ");
        }

    }
}
