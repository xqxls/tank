package com.example.tank.chain;

import com.example.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/24 18:15
 */
public class ColliderChain {

    private List<Collider> colliders=new LinkedList<>();

    public ColliderChain(){
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }

    public void collide(GameObject o1, GameObject o2) {
        for(int i=0;i<colliders.size();i++){
            if(colliders.get(i).collide(o1,o2)){
                break;
            }
        }
    }

    public void add(Collider collider){
        colliders.add(collider);
    }
}
