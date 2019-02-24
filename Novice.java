import java.io.*;
import java.util.*;

public class Novice {
    private int hp;  // Declared attributes
    private int maxHp;
    private int mp;
    private int maxMp;
    private int exp;
    private int maxExp;
    private int level;
    private String job;

    Bag bag;

    public Novice() {
        maxHp = 100;   // Defined attributes
        hp = maxHp;
        maxMp = 100;
        mp = maxMp;
        exp = 0;
        maxExp = 10;
        level = 1;
        job = "Novice";

        bag = new Bag();
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public int getMp() {
        return mp;
    }

    public int getExp() {
        return exp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public int getLevel() {
        return level;
    }

    public String getJob() {
        return job;
    }

    public void usePotion(int increaseValue) {
        if(increaseValue == bag.hpPotion.getPotionValue()) { 
            hp += increaseValue;
            if(hp > maxHp) {
                hp = maxHp;
            }
        }

        if(increaseValue == bag.mpPotion.getPotionValue()) {
            mp += increaseValue;
            if(mp > maxMp) {
                mp = maxMp;
            }
        }
    }

    public int showHp() { // display the current HP
        if(bag.getHpInitAmount() == 0) {
            hp -= (int)(Math.random() * 26);
            if(hp < 0) hp = 0;
            return hp;
        }

        if(hp <= 30) {  // Call usePotion method when HP equal 30
            usePotion(bag.hpPotion.getPotionValue());
            bag.itemList.replace("1. HP Potion (+100hp)", bag.getHpInitAmount(), bag.lostHpPotion());
        }

        hp -= (int)(Math.random() * 26);
        if(hp < 0) hp = 0;
        return hp;    // get hit by monster, hp is lost
    }

    public int showMp() {
        if(bag.getMpInitAmount() == 0) {
            mp -= 5;
            if(mp < 0) mp = 0;
            return mp;
        }

        if(mp <= 30) {
            usePotion(bag.mpPotion.getPotionValue());
            bag.itemList.replace("2. MP Potion (+50mp)", bag.getMpInitAmount(), bag.lostMpPotion());
        }

        mp -= 5;
        if(mp < 0) mp = 0;
        return mp;
    }

    public int showExp() { // display the current EXP
        exp += (int)(Math.random() * 26);
        if(exp > maxExp)
            exp = maxExp;

        return exp;
    }

    public int showLevel() { // display the current Level
        if(level == 99)
            return level;   // if reach to max level, level will not be increase

        else if(exp == 0)   
            return level;   // When the game get started, exp = 0, level will not be increase

        else if(exp >= maxExp) {
            level++;
            exp = 0;
            maxExp += 0.70 * maxExp;
            maxHp += 0.15 * maxHp;
            return level; // Level will be increase every max exp
        }
        
        return level;   // display the current Level
    }

    public void autoBot() {
        try {
            showExp();
            while(exp < maxExp) {   // Informations will be update every 500 ms. or 0.5 s. & cancel Auto Bot every maxExp
                System.out.println("==================");   // display your informations
                System.out.println("[" + getJob() + "] Level: " + showLevel());
                System.out.println("==================");
                System.out.println("HP: " + showHp() + "/" + maxHp);
                System.out.println("MP: " + showMp() + "/" + maxMp);
                System.out.println("EXP: " + showExp() + "/" + maxExp + "\n");
                
                int dropRate = (int)(Math.random() * 9);
                if(dropRate == 0) {
                    System.out.println("You get \"HP Potion\" x1");
                    bag.itemList.replace("1. HP Potion (+100hp)", bag.getHpInitAmount(), bag.addHpPotion());
                }
                else if(dropRate == 1) {
                    System.out.println("You get \"MP Potion\" x1");
                    bag.itemList.replace("2. MP Potion (+50mp)", bag.getMpInitAmount(), bag.addMpPotion());
                }
                else {
                    System.out.println("");
                }

                Thread.sleep(500); // sleep for 500 ms. 

                System.out.println("\n\n\n\n");

                if(hp == 0) {
                    for(int i = 5; i >= 0; i--) {
                        try {
                            System.out.println("\n\n\n\n\n\n\n\n\n");
                            System.out.println("      \"GAME OVER !!! \"");
                            System.out.println("\"YOU HAVE BEEN DEFEATED !!!\"\n");
                            System.out.println("You will be respawn in " + i + " seconds");
                            Thread.sleep(1000);
                            hp =  maxHp / 2;
                        }

                        catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }

            }
            showLevel();
        }

        catch(InterruptedException e) {
            e.printStackTrace();    // catch with try
        }
    }

    public void changeJobTo(String nameOfJob) {
        job = nameOfJob;
    }

    public void setStatusClass(int level, int maxExp, int hpOfClass, int mpOfClass, Bag bag) {
        this.level = level;

        this.maxExp = maxExp;

        maxHp = hpOfClass;
        hp = maxHp;
        
        maxMp = mpOfClass;
        mp = maxMp;

        this.bag = bag;
    }
} //end of class