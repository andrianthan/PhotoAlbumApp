import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Represents a model for a photo album that manages a collecton of photos.
 * Provides methods to add, delete, next, previous, and sort photos within an album.
 * Implements an iterator for iterating over the photos in the album.
 */
public class PhotoAlbumModel implements Iterable<Photo>{
    private List<Photo> photoList;
    private int current;

    /**
     * Initializes a new PhotoAlbumModel with an empty photo list and sets current index at 0.
     */
    public PhotoAlbumModel()
    {
        photoList = new ArrayList<>();
        current = 0;
    }

    /**
     * Gets the current index of the photo in the album.
     * @return current index of the photo
     */
    public int getCurrent()
    {
        return current;
    }

    /**
     * Updates the current index
     * @param current
     */
    public void updateCurrent(int current)
    {
        this.current = current;
    }

    /**
     * Adds a new photo to the photo album.
     * @param p is the photo to be added to the album.
     */
    public void addPhoto(Photo p)
    {
        photoList.add(p);
        current = photoList.size() -1;
    }

    /**
     * Gets the photo at the current index.
     * @return the photo at the current index
     */
    public Photo getPhoto() {
        if (photoList.isEmpty() || current < 0 || current >= photoList.size()) {
            return null;
        }
        return photoList.get(current);
    }


    /**
     * Deletes the photo with the specified name.
     * @param name the name of the photo to be deleted
     */
    public void deletePhoto(String name)
    {
        int index = 0;
        for(Photo p: photoList)
        {
            if(p.getName().contains(name))
            {
                //valid photo was found
                photoList.remove(index);
                return;
            }
            index++;
        }
        //valid photo was not found
        System.out.println("Photo was not found. Please try again.");


    }

    /**
     * Moves the current index to the next photo.
     * If the next index is empty, then do nothing.
     */
    public void next()
    {
        if(photoList.size() == 0)
        {
            return;
        }
        current = (current + 1) % photoList.size();
    }

    /**
     * Moves the current index to the previous photo.
     * If the previous index is empty, then do nothing.
     */
    public void previous()
    {
        if(photoList.size() == 0)
        {
            return;
        }
        current = (current - 1 + photoList.size()) % photoList.size();
    }


    /**
     * Gets the list of photos in the album and returns it.
     * @return the list of photos in the album
     */
    public List<Photo> getPhotoList() {
        return photoList;
    }

    /**
     * Returns an iterator over the elements in the photo album.
     * @return an iterator
     */
    @Override
    public Iterator<Photo> iterator() {
        return new PhotoAlbumIterator();
    }


    /**
     * An iterator over a collection of photos in a photo album.
     * The iterator allows traversing the photos in the album sequentially.
     */
    private class PhotoAlbumIterator implements Iterator<Photo>{
        private int index = 0;


        /**
         * Returns true if iterator has more photos.
         * @return true if iterator has more succeeding photos
         */
        @Override
        public boolean hasNext(){
            if(index < photoList.size())
            {
                return true;
            }else{
                return false;
            }
        }


        /**
         * Checks if there is a previous photo in the list.
         *
         * @return true or false depending on if there is a previous photo.
         */
        public boolean hasPrevious()
        {
            return index > 0;
        }

        /**
         * Returns the next photo in the list.
         * @return the next Photo in the album.
         */
        @Override
        public Photo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            System.out.println("prev");
            return photoList.get(index++);
        }

        /**
         * Returns the previous photo in the list.
         *
         * @return the next Photo in the album.
         */
        public Photo previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            return photoList.get(--index);
        }

        /**
         * Removes an item in the Photo Album.
         */

        @Override
        public void remove() {
            if (index <= 0) {
                throw new IllegalStateException("You cannot remove an item");
            }
            photoList.remove(--index);
        }
    }
    }

