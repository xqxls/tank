package com.example.tank;

import com.example.tank.chain.BulletTankCollider;
import com.example.tank.chain.ColliderChain;
import com.example.tank.chain.TankTankCollider;

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
    ColliderChain chain=new ColliderChain();
    List<GameObject> objects = new ArrayList<>();

    public  GameModel(){
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,this));
        }

        myTank.setMoving(false);
    }

    public void add(GameObject gameObject){
        this.objects.add(gameObject);
    }

    public void remove(GameObject gameObject){
        this.objects.remove(gameObject);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("bullets:" + bullets.size(), 10, 60);
//        g.drawString("tanks:" + tanks.size(), 10, 80);
//        g.drawString("explodes:" + explodes.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i <objects.size() ; i++) {
            objects.get(i).paint(g);
        }


        for (int i = 0; i <objects.size() ; i++) {
            for (int j = i+1; j <objects.size() ; j++) {
                GameObject o1=objects.get(i);
                GameObject o2=objects.get(j);
                chain.collide(o1,o2);
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
