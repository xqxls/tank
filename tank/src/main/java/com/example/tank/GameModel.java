package com.example.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/24 15:09
 */
public class GameModel {

    Tank myTank = new Tank(540, 480, Dir.UP,Group.GOOD,this);
    java.util.List<Bullet> bullets=new ArrayList<>();
    java.util.List<Tank> tanks=new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    public  GameModel(){
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,this));
        }

        myTank.setMoving(false);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("bullets:" + bullets.size(), 10, 60);
        g.drawString("tanks:" + tanks.size(), 10, 80);
        g.drawString("explodes:" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i <bullets.size() ; i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i <tanks.size() ; i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i <explodes.size() ; i++) {
            explodes.get(i).paint(g);
        }

        for (int i = 0; i <bullets.size() ; i++) {
            for (int j = 0; j <tanks.size() ; j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
