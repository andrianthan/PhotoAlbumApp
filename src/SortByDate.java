import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByDate implements SortingStrategy {

    @Override
    public void sort(List<Photo> photos) {
        Collections.sort(photos, new Comparator<Photo>() {
            @Override
            public int compare(Photo p1, Photo p2) {
                return p1.getDateAdded().compareTo(p2.getDateAdded());  // Sort by date
            }
        });
        System.out.println("Sorted by date.");
    }
}
