import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

public class PhotoAlbumController
{

    private PhotoAlbumView view;
    public PhotoAlbumController(PhotoAlbumModel model, PhotoAlbumView view)
    {
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

        view.deletePhoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = JOptionPane.showInputDialog("Please enter photo name to delete");
                model.deletePhoto(response);
                view.updateView();
            }
        });

        view.next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(model.getCurrent() == model.getPhotoList().size() -1)
                {
                    model.updateCurrent(0);
                }else {
                    model.updateCurrent(model.getCurrent() + 1);
                }
                view.updateView();

            }
        });

        view.previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(model.getCurrent() == 0)
                {
                    model.updateCurrent(model.getPhotoList().size()-1);
                }else {
                    model.updateCurrent(model.getCurrent() -1);
                }
                view.updateView();

            }
        });

        view.sortDropDown.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = view.sortDropDown.getSelectedItem().toString();
                if(selection.equals("Sort By Date"))
                {
                    SortingStrategy sortByDate = new SortByDate();
                    sortByDate.sort(model.getPhotoList());
                    view.updateView();


                }else if(selection.equals("Sort By Name")){
                    SortingStrategy sortByName = new SortByName();
                    sortByName.sort(model.getPhotoList());
                    view.updateView();

                }else if (selection.equals("Sort By Size")){
                    SortingStrategy sortBySize = new SortBySize();
                    sortBySize.sort(model.getPhotoList());
                    view.updateView();
                }
            }





        });


    }

}