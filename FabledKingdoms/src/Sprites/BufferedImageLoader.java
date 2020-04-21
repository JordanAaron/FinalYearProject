package Sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedImageLoader {
    private BufferedImage image;

    File inputFile;

    public BufferedImage loadImage(String path) throws IOException {
        this.inputFile = new File(path);
        //image = ImageIO.read(this.getClass().getResource(path));
        //image = ImageIO.read(new FileInputStream(path));
        image = ImageIO.read(inputFile);
        return image;
    }
}
