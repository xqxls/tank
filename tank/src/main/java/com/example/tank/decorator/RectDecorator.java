package com.example.tank.decorator;

import com.example.tank.GameModel;
import com.example.tank.GameObject;

import java.awt.*;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/25 16:40
 */
public class RectDecorator extends GoDecorator{

    public RectDecorator(GameObject go){
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x=go.x;
        this.y=go.y;
        go.paint(g);

        Color c=g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(go.x,go.y,getWidth(),getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }
}
