package com.example.tank.test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/8 20:40
 */
public class ImageTest {

    @Test
    void test(){
        try {
            BufferedImage image= ImageIO.read(new File("F:\\projects\\tank\\src\\main\\resources\\images\\bulletD.gif"));
            assertNotNull(image);

            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
