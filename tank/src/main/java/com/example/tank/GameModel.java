package com.example.tank;

import com.example.tank.chain.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/24 15:09
 */
public class GameModel {

    Tank myTank;

    ColliderChain chain=new ColliderChain();
    List<GameObject> objects = new ArrayList<>();

    private static final GameModel instance=new GameModel();

    private GameModel(){

    }

    public static GameModel getInstance(){
        return instance;
    }

    static {
        instance.init();
    }

    private void init(){
        //初始化主站坦克
        myTank = new Tank(540, 540, Dir.UP,Group.GOOD);

        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50+i*160,0,Dir.DOWN,Group.BAD);
        }
        //初始化墙
        add(new Wall(150,150,200,50));
        add(new Wall(550,150,200,50));
        add(new Wall(300,300,50,200));
        add(new Wall(550,300,50,200));
        //主战坦克设置为静止
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
