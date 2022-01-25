package com.example.tank.chain;

import com.example.tank.Bullet;
import com.example.tank.GameObject;
import com.example.tank.Tank;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/24 17:03
 */
public class BulletTankCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b=(Bullet)o1;
            Tank t=(Tank) o2;
            if(b.getGroup()==t.getGroup()) return false;
            //用一个rect记录位置
            if(b.getRect().intersects(t.getRect())){
                b.die();
                t.die();
            }
            return true;
        }
        else if(o1 instanceof Tank && o2 instanceof Bullet){
            collide(o2,o1);
        }
        return false;
    }
}
