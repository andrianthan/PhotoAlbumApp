import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortBySize implements SortingStrategy {

    @Override
    public void sort(List<Photo> photos) {
        Collections.sort(photos, new Comparator<Photo>() {
            @Override
            public int compare(Photo p1, Photo p2) {
                return Long.compare(p1.getFileSize(), p2.getFileSize());
            }
        });
        System.out.println("Sorted by size.");
    }
}
