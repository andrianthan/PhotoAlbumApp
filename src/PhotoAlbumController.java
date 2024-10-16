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

        view.sortByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        view.next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        view.previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

}