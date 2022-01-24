package com.example.tank;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/4 18:53
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        TankFrame frame=new TankFrame();

        //music
        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while(true){
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
