import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


/**
 * Initializes the Photo Album application by creating instances of the model, view, controller.
 * The model manages the collection of photos, view displays photos, and the program acts on user inputs
 * with the controller.
 */
public class PhotoAlbumApp {
    public static void main (String args[])
    {
        PhotoAlbumModel model = new PhotoAlbumModel();
        PhotoAlbumView view = new PhotoAlbumView(model);
        PhotoAlbumController controller = new PhotoAlbumController(model, view);

    }


}
