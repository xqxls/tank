package com.example.tank.chain;

import com.example.tank.Bullet;
import com.example.tank.GameObject;
import com.example.tank.Wall;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/25 12:17
 */
public class BulletWallCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet b=(Bullet)o1;
            Wall w=(Wall) o2;
            if(b.getRect().intersects(w.getRect())){
                b.die();
            }
            return true;
        }
        else if(o1 instanceof Wall && o2 instanceof Bullet){
            collide(o2,o1);
        }
        return false;
    }
}
