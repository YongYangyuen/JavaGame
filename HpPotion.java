import java.io.*;
import java.util.*;

public class HpPotion extends Item {

    public HpPotion() {
        super("HP Potion", "Can use to heal up your HP +100hp", 100);
    }

    public void showDetailOfItem() {
        System.out.println(getNameItem());
        System.out.println(getDetailItem());
    }
}