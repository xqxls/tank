package com.example.tank;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/4 18:53
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        TankFrame frame=new TankFrame();
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initTankCount; i++) {
            frame.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,frame));
        }

        frame.myTank.setMoving(false);

        //music
        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while(true){
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
