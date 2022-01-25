package com.example.tank.chain;

import com.example.tank.GameModel;
import com.example.tank.GameObject;
import com.example.tank.Tank;
import com.example.tank.Wall;

import java.awt.*;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/25 12:23
 */
public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Wall){
            Tank t=(Tank)o1;
            Wall w=(Wall) o2;
            if(t.getRect().intersects(w.getRect())){
                t.backPoint();
            }
            return true;
        }
        else if(o1 instanceof Wall && o2 instanceof Tank){
            collide(o2,o1);
        }
        return false;
    }
}
