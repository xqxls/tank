package com.example.tank;

import java.awt.*;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/25 12:02
 */
public class Wall extends GameObject{

    int w,h;

    public  Rectangle rect;

    public Wall(int x,int y,int w,int h){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;

        rect=new Rectangle(x,y,w,h);
    }

    @Override
    public void paint(Graphics g) {

        Color c=g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x,y,w,h);
        g.setColor(c);

    }

    public Rectangle getRect() {
        return rect;
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }
}
