package com.example.tank;

import java.awt.*;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/24 16:25
 */
public abstract class GameObject {

    public int x,y;

    public abstract void paint(Graphics g);

    public abstract int getWidth();

    public abstract int getHeight();
}
