package com.sxt;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BackGround {
    //当前场景要显示的图像
    private BufferedImage bgImage = null;
    //记录当前是第几个场景
    private int sort;
    //判断是否是最后一个场景
//    private boolean flag;
    //用于存放我们的所有障碍物
    private List<Obstacle> obstacleList = new ArrayList<>();
    //用于存放所有的敌人
    private List<Enemy> enemyList = new ArrayList<>();
    //用于显示旗杆
    private BufferedImage gan = null;
    //用于显示城堡
    private BufferedImage tower = null;
    //判断玛利奥是否到达旗杆位置
    private boolean isReach = false;
    //判断旗子是否落地
    private boolean isBase = false;

    public BackGround() {

    }

    public BackGround(int sort) {
        this.sort = sort;
//        this.flag = flag;
//        if (flag) {
//            bgImage = StaticValue.bg2;
//        } else {
//            bgImage = StaticValue.bg0;
//        }

//        for (int i = 1; i <= 4; i++) {
            if (sort == 1) {
                bgImage = StaticValue.bg.get(0);
            }
            if (sort == 2) {
                bgImage = StaticValue.bg.get(1);
            }
            if (sort == 3) {
                bgImage = StaticValue.bg.get(2);
            }
            if (sort == 4) {
                bgImage = StaticValue.bg.get(3);
            }
//        }
        //判断是否为第一关
        if (sort == 1) {
            //绘制第一关的地面，上地面type=1,下地面type=2
            for (int i = 0; i < 27; i++) {
                obstacleList.add(new Obstacle(i * 30, 420, 1, this));
            }

            for (int j = 0; j <= 120; j += 30) {
                for (int i = 0; i < 27; i++) {
                    obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                }
            }
            //绘制砖块
            for (int i = 120; i <= 150; i += 30) {
                obstacleList.add(new Obstacle(i, 300, 7, this));
            }

            for (int i = 300; i <= 570; i += 30) {
                if (i == 360 || i == 390 || i == 480 || i == 510 || i == 540) {
                    obstacleList.add(new Obstacle(i, 300, 7, this));
                } else {
                    obstacleList.add(new Obstacle(i, 300, 0, this));
                }
            }

            for (int i = 420; i <= 450; i += 30) {
                obstacleList.add(new Obstacle(i, 240, 7, this));
            }
            //绘制水管
            for (int i = 360; i <= 600; i += 25) {
                if (i == 360) {
                    obstacleList.add(new Obstacle(620, i, 3, this));
                    obstacleList.add(new Obstacle(648, i, 4, this));
                } else {
                    obstacleList.add(new Obstacle(620, i, 5, this));
                    obstacleList.add(new Obstacle(648, i, 6, this));
                }
            }
            //绘制蘑菇敌人
            enemyList.add(new Enemy(580, 385, 1, true, this));
            enemyList.add(new Enemy(480, 385, 1, true, this));
            enemyList.add(new Enemy(380, 385, 1, true, this));
            //绘制食人花敌人
            enemyList.add(new Enemy(635, 420, 2, true, this, 328, 428));


        }

        //判断是否是第二关
        if (sort == 2) {
            //绘制第二关的地面，上地面type=1,下地面type=2
            for (int i = 0; i < 27; i++) {
                obstacleList.add(new Obstacle(i * 30, 420, 1, this));
            }

            for (int j = 0; j <= 120; j += 30) {
                for (int i = 0; i < 27; i++) {
                    obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                }
            }
            //绘制第一个水管
            for (int i = 360; i <= 600; i += 25) {
                if (i == 360) {
                    obstacleList.add(new Obstacle(60, i, 3, this));
                    obstacleList.add(new Obstacle(85, i, 4, this));
                } else {
                    obstacleList.add(new Obstacle(60, i, 5, this));
                    obstacleList.add(new Obstacle(85, i, 6, this));
                }
            }
            //绘制第二个水管
            for (int i = 330; i <= 600; i += 25) {
                if (i == 330) {
                    obstacleList.add(new Obstacle(620, i, 3, this));
                    obstacleList.add(new Obstacle(645, i, 4, this));
                } else {
                    obstacleList.add(new Obstacle(620, i, 5, this));
                    obstacleList.add(new Obstacle(645, i, 6, this));
                }
            }
            //绘制砖块
            obstacleList.add(new Obstacle(300, 330, 0, this));

            for (int i = 270; i <= 330; i += 30) {
                if (i == 270 || i == 330) {
                    obstacleList.add(new Obstacle(i, 360, 0, this));
                } else {
                    obstacleList.add(new Obstacle(i, 360, 7, this));
                }
            }

            for (int i = 240; i <= 360; i += 30) {
                if (i == 240 || i == 360) {
                    obstacleList.add(new Obstacle(i, 390, 0, this));
                } else {
                    obstacleList.add(new Obstacle(i, 390, 7, this));
                }
            }
            obstacleList.add(new Obstacle(240, 300, 0, this));

            for (int i = 360; i <= 540; i += 60) {
                obstacleList.add(new Obstacle(i, 270, 7, this));
            }
            //绘制食人花敌人
            enemyList.add(new Enemy(75, 420, 2, true, this, 328, 418));
            enemyList.add(new Enemy(635, 420, 2, true, this, 298, 388));
            //绘制蘑菇敌人
            enemyList.add(new Enemy(200, 385, 1, true, this));
            enemyList.add(new Enemy(500, 385, 1, true, this));
        }

        //判断是否是第三关
        if (sort == 3) {
            //绘制第三关的地面，上地面type=1,下地面type=2
            for (int i = 0; i < 15; i++) {
                obstacleList.add(new Obstacle(i * 30, 420, 1, this));
            }

            for (int i = 20; i < 27; i++) {
                obstacleList.add(new Obstacle(i * 30, 420, 1, this));
            }

            for (int j = 0; j <= 120; j += 30) {
                for (int i = 0; i < 15; i++) {
                    obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                }
            }
            for (int j = 0; j <= 120; j += 30) {
                for (int i = 20; i < 27; i++) {
                    obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                }
            }

            //绘制水管
            for (int i = 360; i <= 600; i += 25) {
                if (i == 360) {
                    obstacleList.add(new Obstacle(660, i, 3, this));
                    obstacleList.add(new Obstacle(685, i, 4, this));
                } else {
                    obstacleList.add(new Obstacle(660, i, 5, this));
                    obstacleList.add(new Obstacle(685, i, 6, this));
                }
            }
            //绘制砖块
            obstacleList.add(new Obstacle(420, 270, 0, this));

            for (int i = 30; i <= 300; i += 30) {
                if (i != 150 && i != 180) {
                    obstacleList.add(new Obstacle(i, 390, 7, this));
                }
            }

            for (int i = 60; i <= 270; i += 30) {
                if (i != 150 && i != 180) {
                    obstacleList.add(new Obstacle(i, 360, 7, this));
                }
            }

            for (int i = 90; i <= 240; i += 30) {
                if (i != 150 && i != 180) {
                    obstacleList.add(new Obstacle(i, 330, 7, this));
                }
            }

            for (int i = 120; i <= 210; i += 30) {
                if (i != 150 && i != 180) {
                    obstacleList.add(new Obstacle(i, 300, 7, this));
                }
            }
            obstacleList.add(new Obstacle(390, 330, 7, this));
            obstacleList.add(new Obstacle(420, 330, 7, this));

            //绘制食人花敌人
            enemyList.add(new Enemy(675, 420, 2, true, this, 328, 418));
//            enemyList.add(new Enemy(635, 420, 2, true, this, 298, 388));
            //绘制蘑菇敌人
            enemyList.add(new Enemy(750, 385, 1, true, this));
//            enemyList.add(new Enemy(500, 385, 1, true, this));


        }



        //判断是否是第四关
        if (sort == 4) {
            //绘制第四关的地面，上地面type=1,下地面type=2
            for (int i = 0; i < 27; i++) {
                obstacleList.add(new Obstacle(i * 30, 420, 1, this));
            }

            for (int j = 0; j <= 120; j += 30) {
                for (int i = 0; i < 27; i++) {
                    obstacleList.add(new Obstacle(i * 30, 570 - j, 2, this));
                }
            }
            //绘制砖块
            int temp = 290;
            for (int i = 390; i >= 270; i -= 30) {
                for (int j = temp; j <= 410; j += 30) {
                    obstacleList.add(new Obstacle(j, i, 7, this));
                }
                temp += 30;
            }
            temp = 60;
            for (int i = 390; i >= 360; i -= 30) {
                for (int j = temp; j <= 90; j += 30) {
                    obstacleList.add(new Obstacle(j, i, 7, this));
                }
                temp += 30;
            }
            //绘制旗杆
            gan = StaticValue.gan;
            //绘制城堡
            tower = StaticValue.tower;
            //添加旗子到旗杆上
            obstacleList.add(new Obstacle(515, 220, 8, this));
            //绘制蘑菇敌人
            enemyList.add(new Enemy(150, 385, 1, true, this));


        }

    }


    public BufferedImage getBgImage() {
        return bgImage;
    }

    public int getSort() {
        return sort;
    }

//    public boolean isFlag() {
//        return flag;
//    }

    public List<Obstacle> getObstacleList() {
        return obstacleList;
    }

    public BufferedImage getGan() {
        return gan;
    }

    public BufferedImage getTower() {
        return tower;
    }

    public boolean isReach() {
        return isReach;
    }

    public void setReach(boolean reach) {
        isReach = reach;
    }

    public boolean isBase() {
        return isBase;
    }

    public void setBase(boolean base) {
        isBase = base;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

}
