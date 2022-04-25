package com.sxt;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Music {
    public Music() throws FileNotFoundException {
        String str ="src/Muisc/music.wav";
//        String str = System.getProperty("user.dir") + "/src/Music/music.wav";
        BufferedInputStream name = new BufferedInputStream(new FileInputStream(str));
        Player player = null;
        try {
            player = new Player(name);
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
        try {
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

}
