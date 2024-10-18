import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Represents the view of a photo album application.
 * Manages the display of photos and list of photos in the album.
 */
public class PhotoAlbumView {

    JFrame frame;
    JPanel leftPanel;
    JPanel rightPanel;
    JTextArea photoList;
    JLabel photoLabel;
    JButton addPhoto;
    JButton deletePhoto;
    JButton next;
    JButton previous;
    PhotoAlbumModel model;
    JLabel fileName;
    JComboBox<String> sortDropDown;


    /**
     * Represents the PhotoAlbumView object
     * Manages the display of photos and functionalities to add, delete, and navigate through photos
     * in the album.
     * @param model
     */

    public PhotoAlbumView(PhotoAlbumModel model) {
        this.model = model;

        frame = new JFrame("Photo Album Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);

        leftPanel = new JPanel();
        leftPanel.setBounds(10, 10, 250, 500);
        leftPanel.setBorder(BorderFactory.createTitledBorder("List of Photos"));
        leftPanel.setLayout(null);

        photoList = new JTextArea();
        photoList.setBounds(10, 20, 230, 470);
        photoList.setEditable(false);
        leftPanel.add(photoList);

        rightPanel = new JPanel();
        rightPanel.setBounds(270, 10, 500, 500);
        rightPanel.setBorder(BorderFactory.createTitledBorder("Current Photo"));
        rightPanel.setLayout(null);

        fileName = new JLabel();
        fileName.setBounds(10, 20, 460, 20);
        fileName.setHorizontalAlignment(JLabel.CENTER);
        fileName.setVerticalAlignment(JLabel.TOP);


        photoLabel = new JLabel("Current Photo");
        photoLabel.setBounds(20, 20, 460, 460);
        rightPanel.add(photoLabel);
        rightPanel.add(fileName);

        frame.add(leftPanel);
        frame.add(rightPanel);

        addPhoto = new JButton("Add Photo");
        addPhoto.setBounds(100, 520, 100, 30);

        deletePhoto = new JButton("Delete Photo");
        deletePhoto.setBounds(210, 520, 120, 30);

        next = new JButton("Next");
        next.setBounds(340, 520, 100, 30);

        previous = new JButton("Previous");
        previous.setBounds(450, 520, 100, 30);

        String[] sortBy = {"Sort By Date", "Sort By Name", "Sort By Size"};
        sortDropDown = new JComboBox<>(sortBy);
        sortDropDown.setBounds(560, 520, 120, 30);

        frame.add(addPhoto);
        frame.add(deletePhoto);
        frame.add(next);
        frame.add(previous);
        frame.add(sortDropDown);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }


    /**
     * Updates the view of the Photo Album application by updating the photo on display and photo album list.
     */
    public void updateView() {
        List<Photo> photos = model.getPhotoList();

        StringBuilder sb = new StringBuilder();
        for (Photo photo : photos) {
            sb.append(photo.getName()).append("\n");
        }

        photoList.setText(sb.toString());
        Photo currentPhoto = null;

        if (!photos.isEmpty()) {
            currentPhoto = photos.get(model.getCurrent());
        }

        if (currentPhoto != null) {
            try {
                BufferedImage img = ImageIO.read(new File(currentPhoto.getFilePath()));
                Image scaledImage = img.getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
                photoLabel.setIcon(new ImageIcon(scaledImage));
                fileName.setText(currentPhoto.getName());
            } catch (IOException e) {
                e.printStackTrace();
                photoLabel.setIcon(null);
                photoLabel.setText("Error loading image");
            }
        } else {
            photoLabel.setIcon(null);
            photoLabel.setText("No Photo");
        }
        photoLabel.revalidate();
        photoLabel.repaint();
        photoList.revalidate();
        photoList.repaint();
    }

    /**
     * Updates the view of the photo album list and the photo on display when a sorting method is used.
     */
    public void updateSortPhoto()
    {
        List<Photo> photos = model.getPhotoList();

        StringBuilder sb = new StringBuilder();
        for (Photo photo : photos) {
            sb.append(photo.getName()).append("\n");
        }

        photoList.setText(sb.toString());
        Photo currentPhoto = model.getPhotoList().get(0);
        if (currentPhoto != null) {
            try {
                BufferedImage img = ImageIO.read(new File(currentPhoto.getFilePath()));
                Image scaledImage = img.getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
                photoLabel.setIcon(new ImageIcon(scaledImage));
                fileName.setText(currentPhoto.getName());
            } catch (IOException e) {
                e.printStackTrace();
                photoLabel.setIcon(null);
                photoLabel.setText("Error loading image");
            }
        } else {
            photoLabel.setIcon(null);
            photoLabel.setText("No Photo");
        }
        photoLabel.revalidate();
        photoLabel.repaint();
        photoList.revalidate();
        photoList.repaint();
    }




}
