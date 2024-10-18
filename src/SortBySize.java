import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorts the photo album by the size of photos.
 */
public class SortBySize implements SortingStrategy {


    /**
     * Takes a photo album and sorts the photos by size, from smallest to largest.
     * @param photos
     */

    @Override
    public void sort(List<Photo> photos) {
        Collections.sort(photos, new Comparator<Photo>() {
            @Override
            public int compare(Photo p1, Photo p2) {
                return Long.compare(p1.getFileSize(), p2.getFileSize());
            }
        });
        System.out.println("Sorted by size.");
        for(Photo p: photos)
        {
            System.out.println(p.getName()+ " ");
        }
    }
}
