package com.example.tank.chain;

import com.example.tank.GameObject;
import com.example.tank.Tank;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/24 17:29
 */
public class TankTankCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank){
            Tank t1=(Tank)o1;
            Tank t2=(Tank)o2;
            if(t1.getRect().intersects(t2.getRect())){
                t1.backPoint();
                t2.backPoint();
            }
            return true;
        }
        return false;
    }
}
