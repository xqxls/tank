package com.example.tank.decorator;

import com.example.tank.GameModel;
import com.example.tank.GameObject;

import java.awt.*;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/25 16:15
 */
public abstract class GoDecorator extends GameObject {
    GameObject go;

    public  GoDecorator(GameObject go){
        this.go=go;
    }

    public abstract void paint(Graphics g);

}
