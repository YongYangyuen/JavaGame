import java.io.*;
import java.util.*;

public class MpPotion extends Item {

    public MpPotion() {
        super("MP Potion", "Can use to increase your MP +50mp", 50);
    }

    public void showDetailOfItem() {
        System.out.println(getNameItem());
        System.out.println(getDetailItem());
    }
}