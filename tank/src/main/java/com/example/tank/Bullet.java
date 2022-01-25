package com.example.tank;

import java.awt.*;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/6 16:09
 */
public class Bullet extends GameObject{
    private int x, y;
    private Dir dir;
    private static final int SPEED = 20;
    private boolean moving = true;
    private boolean living = true;
    private Group group = Group.BAD;

    public static int WIDTH = ResourceMgr.BulletD.getWidth();
    public static int HEIGHT = ResourceMgr.BulletD.getHeight();

    Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics g){
        if(!living){
            GameModel.getInstance().remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.BulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.BulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.BulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.BulletD,x,y,null);
                break;
            default:
                break;
        }
        move();
    }

    public void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }

        rect.x = this.x;
        rect.y = this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;

    }


    public void die(){
        this.living=false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRect() {
        return rect;
    }
}
