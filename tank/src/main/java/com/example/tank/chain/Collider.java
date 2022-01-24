package com.example.tank.chain;

import com.example.tank.GameObject;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/24 17:02
 */
public interface Collider {

    boolean collide(GameObject o1,GameObject o2);
}
