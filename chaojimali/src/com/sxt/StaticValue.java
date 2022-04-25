package com.sxt;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaticValue {
//    public static BufferedImage bg0 = null;
//
//    public static BufferedImage bg1 = null;
//
//    public static BufferedImage bg2 = null;

    public static BufferedImage jump_L = null;

    public static BufferedImage jump_R = null;

    public static BufferedImage stand_L = null;

    public static BufferedImage stand_R = null;

    public static BufferedImage tower = null;

    public static BufferedImage gan = null;

    public static List<BufferedImage> bg = new ArrayList<>();

    public static List<BufferedImage> obstacle = new ArrayList<>();

    public static List<BufferedImage> run_L = new ArrayList<>();

    public static List<BufferedImage> run_R = new ArrayList<>();

    public static List<BufferedImage> mogu = new ArrayList<>();

    public static List<BufferedImage> flower = new ArrayList<>();

    public static String path = System.getProperty("user.dir") + "/src/images/";

    public static void init() {

        try {
//            bg0 = ImageIO.read(new File(path + "bg1.png"));
//
//            bg1 = ImageIO.read(new File(path + "
//         bg1.png"));
//
//            bg2 = ImageIO.read(new File(path + "bg4.png"));

            stand_L = ImageIO.read(new File(path + "s_mario_stand_L.png"));

            stand_R = ImageIO.read(new File(path + "s_mario_stand_R.png"));

            tower = ImageIO.read(new File(path + "tower.png"));

            gan = ImageIO.read(new File(path + "gan.png"));

            jump_L = ImageIO.read(new File(path + "s_mario_jump1_L.png"));

            jump_R = ImageIO.read(new File(path + "s_mario_jump1_R.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 4; i++) {
            try {
                bg.add(ImageIO.read(new File(path + "bg" + i + ".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 2; i++) {
            try {
                run_L.add(ImageIO.read(new File(path + "s_mario_run" + i + "_L.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 2; i++) {
            try {
                run_R.add(ImageIO.read(new File(path + "s_mario_run" + i + "_R.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            obstacle.add(ImageIO.read(new File(path + "brick.png")));
            obstacle.add(ImageIO.read(new File(path + "soil_up.png")));
            obstacle.add(ImageIO.read(new File(path + "soil_base.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 4; i++) {
            try {
                obstacle.add(ImageIO.read(new File(path + "pipe" + i + ".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            obstacle.add(ImageIO.read(new File(path + "brick2.png")));
            obstacle.add(ImageIO.read(new File(path + "flag.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 3; i++) {
            try {
                mogu.add(ImageIO.read(new File(path + "fungus" + i + ".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 2; i++) {
            try {
                flower.add(ImageIO.read(new File(path + "flower1." + i + ".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
