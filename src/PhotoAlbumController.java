import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

/**
 * Initializes a controller for the photo album application.
 * Manages user interactions with the model and view components.
 * Handles actions which include adding photos, deleting photos,
 * navigating to next photo, navgiating to previous photo, sorting photos.
 */
public class PhotoAlbumController
{
    /**
     * Constructs a PhotoAlbumController object with a PhotoAlbumModel and PhotoAlbumView object
     * @param model
     * @param view
     */
    public PhotoAlbumController(PhotoAlbumModel model, PhotoAlbumView view)
    {

        //Action Listener for adding photos
        view.addPhoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    File file = fileChooser.getSelectedFile();
                    String fName = file.getName();
                    String fPath = file.getPath();
                    Date dateAdded = new Date();
                    long fileSize = file.length();
                    Photo photo = new Photo(fName, fPath, dateAdded, fileSize);
                    model.addPhoto(photo);
                    view.updateView();
                }

            }
        });


        //Action Listener for deleting photos
        view.deletePhoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = JOptionPane.showInputDialog("Please enter photo name to delete");
                model.deletePhoto(response);
                view.updateView();
            }
        });

        //Action Listener for navigating to next photo
        view.next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.next();
                view.updateView();

            }
        });


        //Action Listener for navigating to the previous photo
        view.previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.previous();
                view.updateView();

            }
        });

        //Action Listener for sorting photos
        view.sortDropDown.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = view.sortDropDown.getSelectedItem().toString();
                if(selection.equals("Sort By Date"))
                {
                    SortingStrategy sortByDate = new SortByDate();
                    sortByDate.sort(model.getPhotoList());
                    view.updateSortPhoto();

                }else if(selection.equals("Sort By Name")){
                    SortingStrategy sortByName = new SortByName();
                    sortByName.sort(model.getPhotoList());
                    view.updateSortPhoto();
                }else if (selection.equals("Sort By Size")){
                    SortingStrategy sortBySize = new SortBySize();
                    sortBySize.sort(model.getPhotoList());
                    view.updateSortPhoto();
                }
            }
        });



    }

}