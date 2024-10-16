import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class PhotoAlbumApp {
    public static void main (String args[])
    {
        PhotoAlbumModel model = new PhotoAlbumModel();
        PhotoAlbumView view = new PhotoAlbumView(model);
        PhotoAlbumController controller = new PhotoAlbumController(model, view);







    }


}
