import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class Picture {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ImageFrame frame = new ImageFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}

class ImageFrame extends JFrame
{
    public ImageFrame()//
    {
        setTitle("Pondering");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        ImageComponent component = new ImageComponent();
        add(component);
    }
    public static final int DEFAULT_WIDTH = 1152;
    public static final int DEFAULT_HEIGHT = 1123;
}
class ImageComponent extends JComponent
{
    public ImageComponent()
    {

        try
        {
            image = ImageIO.read(new File("src/THEONE.jpg"));//Вывод изображения по указанному пути
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g)
    {
        if(image == null) return;
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        g.drawImage(image, 0, 0, null);
    }
    private Image image;
}