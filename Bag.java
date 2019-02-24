import java.io.*;
import java.util.*;

public class Bag {
    HashMap <String, Integer>itemList;

    HpPotion hpPotion;
    MpPotion mpPotion;

    private int hpInitAmount;
    private int mpInitAmount;

    public Bag() {
        itemList = new HashMap <String, Integer>();

        mpPotion = new MpPotion();
        hpPotion = new HpPotion();

        hpInitAmount = 3;
        mpInitAmount = 3;

        itemList.put("1. HP Potion (+100hp)", hpInitAmount);
        itemList.put("2. MP Potion (+50mp)", mpInitAmount);
    } 

    public int getHpInitAmount() {
        return hpInitAmount;
    }

    public int getMpInitAmount() {
        return mpInitAmount;
    }

    public int lostHpPotion() {
        if(hpInitAmount == 0)
            return hpInitAmount;

        --hpInitAmount;
        return hpInitAmount;
    }

    public int lostMpPotion() {
        if(mpInitAmount == 0)
            return mpInitAmount;

        --mpInitAmount;
        return mpInitAmount;
    }

    public int addHpPotion() {
        if(hpInitAmount == 99)
            return hpInitAmount;

        ++hpInitAmount;
        return hpInitAmount;
    }

    public int addMpPotion() {
        if(mpInitAmount == 99)
            return mpInitAmount;

        ++mpInitAmount;
        return mpInitAmount;
    }

    

}