package com.example.tank;

import com.example.tank.decorator.RectDecorator;
import com.example.tank.decorator.TailDecorator;

import java.awt.*;
import java.util.Random;

/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2022/1/4 20:39
 */
public class Tank extends GameObject{
    private int oldX,oldY;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean moving = true;
    private boolean living = true;
    private Group group = Group.BAD;

    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    Random random = new Random();
    Rectangle rect = new Rectangle();

    public Tank() {
    }

    public Rectangle getRect() {
        return rect;
    }

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
            return;
        }

        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    public void move() {
        if (!living) return;

        if (!moving) return;

        oldX=x;
        oldY=y;

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

        if (this.group == Group.BAD && random.nextInt(10) > 8) {
            double t = Math.random();
            if (t >= 0 && t < 0.25) {
                this.dir = Dir.LEFT;
            } else if (t >= 0.25 && t < 0.5) {
                this.dir = Dir.RIGHT;
            } else if (t >= 0.5 && t < 0.75) {
                this.dir = Dir.UP;
            } else {
                this.dir = Dir.DOWN;
            }
        }

        if (this.group == Group.BAD && random.nextInt(10) > 8) {
            this.fire();
        }

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (x < 2) {
            x = 2;
        }
        if (y < 28) {
            y = 28;
        }
        if (x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

//        GameModel.getInstance().add(new RectDecorator(new TailDecorator(new Bullet(bX, bY, this.dir, this.group))));
        GameModel.getInstance().add(new Bullet(bX, bY, this.dir, this.group));

        if(this.group == Group.GOOD){
            new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
        }
    }

    public void die() {
        this.living = false;
        int eX = this.x + Tank.WIDTH / 2 - Explode.WIDTH / 2;
        int eY = this.y + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
        GameModel.getInstance().add(new Explode(eX, eY));
    }

    public boolean isLiving() {
        return living;
    }


    public void backPoint() {
        x=oldX;
        y=oldY;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
