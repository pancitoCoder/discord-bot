package com.pancitoCoder.discordbot.utils;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

@Component
public class ImageUtils {

    public void generateImage(String name) throws Exception{
        //read the image
        BufferedImage image = ImageIO.read(new File("C:\\Users\\aaron\\Documents\\AG\\prueba.jpg"));
        //get the Graphics object
        Graphics g = image.getGraphics();
        //set font
        g.setFont(g.getFont().deriveFont(25f));
        //display the text at the coordinates(x=50, y=150)
        g.drawString(String.format("Manco ese %s", name), 400, 333);
        g.dispose();
        //write the image
        ImageIO.write(image, "png", new File("C:\\Users\\aaron\\Documents\\AG\\prueba1.jpg"));
    }

    public static void main(String[] args) throws Exception
    {
        //read the image
        BufferedImage image = ImageIO.read(new File("C:\\Users\\aaron\\Documents\\AG\\prueba.jpg"));
        //get the Graphics object
        Graphics g = image.getGraphics();
        //set font
        g.setFont(g.getFont().deriveFont(25f));
        //display the text at the coordinates(x=50, y=150)
        g.drawString("Manco ese Jey", 400, 333);
        g.dispose();
        //write the image
        ImageIO.write(image, "png", new File("C:\\Users\\aaron\\Documents\\AG\\prueba1.jpg"));
    }
}
