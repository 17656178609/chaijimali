package com.sxt;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame implements KeyListener, Runnable {
    //用于存放所有的背景
    private List<BackGround> allBg = new ArrayList<>();
    //用于存放当前的背景
    private BackGround backGround = new BackGround();
    //用于双缓存
    private Image offScreenImage = null;
    //玛利奥对象
    private Mario mario = new Mario();
    //定义一个线程对象，用于实现玛利奥的运动
    private Thread thread = new Thread(this);

    public MyFrame() throws FileNotFoundException, JavaLayerException {

        this.setSize(800, 600);

        this.setLocationRelativeTo(null);

        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);
        //向窗口对象添加键盘监听器
        this.addKeyListener(this);
        //设置窗口名称
        this.setTitle("超级玛丽");
        //初始化图片
        StaticValue.init();
        //初始化玛利奥
        mario = new Mario(10, 355);
        //创建全部的场景
        for (int i = 1; i <= 4; i++) {
            allBg.add(new BackGround(i));
        }
        //将第一个场景设置为当前场景
        backGround = allBg.get(0);
        mario.setBackGround(backGround);
        //绘制图像
        repaint();
        thread.start();
        new Music();
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(800, 600);
        }
        Graphics graphics = offScreenImage.getGraphics();
        graphics.fillRect(0, 0, 800, 600);
        //绘制背景
        graphics.drawImage(backGround.getBgImage(), 0, 0, this);
        //绘制敌人
        for (Enemy e : backGround.getEnemyList()){
            graphics.drawImage(e.getShow(),e.getX(),e.getY(),this);
        }
        //绘制障碍物
        for (Obstacle ob : backGround.getObstacleList()) {
            graphics.drawImage(ob.getShow(), ob.getX(), ob.getY(), this);
        }
        //绘制城堡
        graphics.drawImage(backGround.getTower(), 620, 270, this);
        //绘制旗杆
        graphics.drawImage(backGround.getGan(), 500, 220, this);
        //绘制玛利奥
        graphics.drawImage(mario.getShow(), mario.getX(), mario.getY(), this);
        //添加分数
        Color c = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("黑体",Font.BOLD,25));
        graphics.drawString("当前的分数为: "+ mario.getScore(),300,100);
        graphics.setColor(c);
        //将对象绘制到窗口中
        g.drawImage(offScreenImage, 0, 0, this);
    }

    public static void main(String[] args) {
        try {
            MyFrame myFrame = new MyFrame();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当键盘按键时调用
    @Override
    public void keyPressed(KeyEvent e) {
        //向右移动
        if (e.getKeyCode() == 68) {
            mario.rightMove();
        }
        //向左移动
        if (e.getKeyCode() == 65) {
            mario.leftMove();
        }
        //跳跃
        if (e.getKeyCode() == 87) {
            mario.jump();
        }
        //下管道
        if (e.getKeyCode() == 83) {
            mario.downMove();
        }
    }

    //当键盘松开按键时调用
    @Override
    public void keyReleased(KeyEvent e) {
        //向左停止
        if (e.getKeyCode() == 65) {
            mario.leftStop();
        }
        //向右停止
        if (e.getKeyCode() == 68) {
            mario.rightStop();
        }
        //向下停止
        if(e.getKeyCode() == 83) {
            mario.downStop();
        }
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(50);
                if (mario.getX() >= 775) {
                    backGround = allBg.get(backGround.getSort());
                    mario.setBackGround(backGround);
                    mario.setX(10);
                    mario.setY(355);
                }
                if((mario.getX() >= 620 && mario.getX() <= 648) && mario.getY() <= 360){
                    if (mario.getDown() == 1 && backGround.getSort() == 1){
                        backGround = allBg.get(backGround.getSort());
                        mario.setBackGround(backGround);
                        mario.setX(10);
                        mario.setY(355);
                    }
                }

                //判断玛利奥是否死亡
                if(mario.isDeath()){
                    JOptionPane.showMessageDialog(this,"玛利奥死亡");
                    System.exit(0);
                }
                //判断是否结束
                if (mario.isOK()) {
                    JOptionPane.showMessageDialog(this,"恭喜你！成功通关了");
                    System.exit(0);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
