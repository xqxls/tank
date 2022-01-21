package com.example.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/8 21:26
 */
public class ResourceMgr {
    public static BufferedImage goodTankL,goodTankU,goodTankR,goodTankD;
    public static BufferedImage badTankL,badTankU,badTankR,badTankD;
    public static BufferedImage BulletL,BulletU,BulletR,BulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static{
        try {
            goodTankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL= ImageUtil.rotateImage(goodTankU,-90);
            goodTankR= ImageUtil.rotateImage(goodTankU,90);
            goodTankD= ImageUtil.rotateImage(goodTankU,180);

            badTankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL= ImageUtil.rotateImage(badTankU,-90);
            badTankR= ImageUtil.rotateImage(badTankU,90);
            badTankD= ImageUtil.rotateImage(badTankU,180);

            BulletU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            BulletL= ImageUtil.rotateImage(BulletU,-90);
            BulletR= ImageUtil.rotateImage(BulletU,90);
            BulletD= ImageUtil.rotateImage(BulletU,180);

            for(int i=0; i<16; i++){
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
