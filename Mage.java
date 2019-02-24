import java.io.*;
import java.util.*;

public class Mage extends Novice {
    public Mage(Novice novice) {
        changeJobTo("Mage");
        setStatusClass(novice.getLevel(), novice.getMaxExp(), 400, 500, novice.bag);
    }
}