import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhotoAlbumModel implements Iterable<Photo>{
    private List<Photo> photoList;
    private int current;

    public PhotoAlbumModel()
    {
        photoList = new ArrayList<>();
        current = 0;
    }
    public int getCurrent()
    {
        return current;
    }
    public void updateCurrent(int current)
    {
        this.current = current;
    }

    public void addPhoto(Photo p)
    {
        photoList.add(p);
        current = photoList.size() -1;
        notifyView();

    }

    public Photo getPhoto()
    {
       return photoList.get(photoList.size() -1);
    }
    public void deletePhoto(String name)
    {
        int index = 0;
        for(Photo p: photoList)
        {
            if(p.getName().contains(name))
            {
                //valid photo was found
                photoList.remove(index);
                notifyView();
                return;
            }
            index++;
        }
        //valid photo was not found
        System.out.println("Photo was not found. Please try again.");




    }



    public void next()
    {
        if(photoList.size() == 0)
        {
            return;
        }
        current = (current + 1) % photoList.size();
        notifyView();
    }

    public void previous()
    {
        if(photoList.size() == 0)
        {
            return;
        }
        current = (current - 1) % photoList.size();
        notifyView();
        current = 0;

    }

    public void notifyView()
    {
        System.out.print("1\n");


    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    @Override
    public Iterator<Photo> iterator() {
        return photoList.iterator();
    }


    }

