import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByName implements SortingStrategy {

    @Override
    public void sort(List<Photo> photos) {
        Collections.sort(photos, new Comparator<Photo>() {
            @Override
            public int compare(Photo p1, Photo p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        System.out.println("Sorted by name.");
        for(Photo p: photos)
        {
            System.out.println(p.getName()+ " ");
        }
    }
}
