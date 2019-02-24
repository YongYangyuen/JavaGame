import java.io.*;
import java.util.*;

public class Item {
    private String nameItem;
    private String detailItem;
    private int potionValue;

    public Item(String name, String detail, int value) {
        nameItem = name;
        detailItem = detail;
        potionValue = value;
    }

    public String getNameItem() {
        return nameItem;
    }

    public String getDetailItem() {
        return detailItem;
    }

    public int getPotionValue() {
        return potionValue;
    }

}