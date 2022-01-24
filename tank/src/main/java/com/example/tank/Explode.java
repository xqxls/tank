package com.example.tank;

import java.awt.*;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/11 21:32
 */
public class Explode extends GameObject{
    private int x, y;
    private  int step=0;

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    GameModel gm;

    public Explode(int x, int y,GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm=gm;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step>=ResourceMgr.explodes.length){
            gm.remove(this);
        }
    }

}
