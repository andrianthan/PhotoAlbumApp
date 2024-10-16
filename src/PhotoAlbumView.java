import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
    JButton sortByName;
    PhotoAlbumModel model;

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

        photoLabel = new JLabel("Current Photo");
        photoLabel.setBounds(20, 20, 460, 460);
        rightPanel.add(photoLabel);

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

        sortByName = new JButton("Sort By Name");
        sortByName.setBounds(560, 520, 120, 30);

        frame.add(addPhoto);
        frame.add(deletePhoto);
        frame.add(next);
        frame.add(previous);
        frame.add(sortByName);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    public void updateView() {
        List<Photo> photos = model.getPhotoList();

        StringBuilder sb = new StringBuilder();
        for (Photo photo : photos) {
            sb.append(photo.getName()).append("\n");
        }
        photoList.setText(sb.toString());
        Photo currentPhoto = null;
        if (!photos.isEmpty()) {
            currentPhoto = model.getPhoto();
        }

        if (currentPhoto != null) {
            try {
                BufferedImage img = ImageIO.read(new File(currentPhoto.getFilePath()));
                Image scaledImage = img.getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
                photoLabel.setIcon(new ImageIcon(scaledImage));
                photoLabel.setText("");
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
