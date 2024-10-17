import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


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


    public Photo getPhoto() {
        if (photoList.isEmpty() || current < 0 || current >= photoList.size()) {
            return null;
        }
        return photoList.get(current);
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
        current = (current - 1 + photoList.size()) % photoList.size();
        notifyView();
    }

    public void notifyView()
    {
        System.out.print("");
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    @Override
    public Iterator<Photo> iterator() {
        return new PhotoAlbumIterator();
    }


    private class PhotoAlbumIterator implements Iterator<Photo>{
        private int index = 0;
        @Override
        public boolean hasNext(){
            if(index < photoList.size())
            {
                return true;
            }else{
                return false;
            }
        }

        public boolean hasPrevious()
        {
            return index > 0;
        }
        @Override
        public Photo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            System.out.println("prev");
            return photoList.get(index++);
        }

        public Photo previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            return photoList.get(--index);
        }

        @Override
        public void remove() {
            if (index <= 0) {
                throw new IllegalStateException("You cannot remove an item");
            }
            photoList.remove(--index);
        }
    }
    }

