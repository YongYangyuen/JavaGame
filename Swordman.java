import java.io.*;
import java.util.*;

public class Swordman extends Novice {

    public Swordman(Novice novice) {
         changeJobTo("Swordman");
         setStatusClass(novice.getLevel(), novice.getMaxExp(), 500, 200, novice.bag);
    }
}