import java.io.*;
import java.util.*;

public class Ragmarock {
    public static void main(String args[]) {
        Novice novice = new Novice();
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Hello World"); // Greeting by the Game

            System.out.println("=====================================================");   // display your informations
            System.out.println("[" + novice.getJob() + "] Level: " + novice.getLevel());
            System.out.println("=====================================================");
            System.out.println("HP: " + novice.getHp() + "/" + novice.getMaxHp());
            System.out.println("MP: " + novice.getMp() + "/" + novice.getMaxMp());
            System.out.println("EXP: " + novice.getExp() + "/" + novice.getMaxExp());
            System.out.println("=====================================================");

            if(novice.getLevel() == 10 && novice.getJob() == "Novice") {
                System.out.println("\"CHANGE CLASS !!!\" => Press: \"C\"");
                System.out.println("\"QUIT GAME\" => Press: \"Q\""); 
            }

            else {
                System.out.println("\"AUTO BOT\" => Press: \"A\"    \"INVENTORY\" => Press: \"I\"");
                System.out.println("\"QUIT GAME\" => Press: \"Q\"");
            }

            System.out.print("Input: ");
            char c = scan.next().charAt(0);

            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            
            if(novice.getLevel() == 10 && novice.getJob() == "Novice") {
                if(c == 'C' || c == 'c') {
                    System.out.println("========================");
                    System.out.println("PLEASE SELECT YOUR CLASS");
                    System.out.println("========================");
                    System.out.println("1. Swordman");
                    System.out.println("2. Mage");
                    System.out.println("========================");

                    System.out.print("Input: ");
                    c = scan.next().charAt(0);

                    System.out.println("\n\n\n\n");

                    System.out.println("===========Congratulations !!!============\n");

                    switch(c) {
                        case '1': System.out.println("     YOUR CLASS IS \"Swordman\" NOW !");
                                  novice = new Swordman(novice);
                                  break;
                        
                        case '2': System.out.println("     YOUR CLASS IS \"Mage\" NOW !");
                                  novice = new Mage(novice);
                                  break;

                        default:
                    }

                    System.out.println("\n\n\n");
                    System.out.println("...Press any key to return to your game...");
                    System.out.println("==========================================");
                    System.out.print("Input: ");
                    c = scan.next().charAt(0);
                }
                else if(c == 'Q' || c == 'q') {
                    System.exit(0);
                }
            }

            else {
                if(c == 'A' || c == 'a') {
                    novice.autoBot();
                }
                else if(c == 'I' || c == 'i') {
                    do {
                        System.out.println("=====================================================");
                        System.out.println("INVENTORY"); // Your Inventory
                        System.out.println("=====================================================");   // display your informations
                        
                        for(Map.Entry m:novice.bag.itemList.entrySet()) {
                            System.out.println(m.getKey() + "   " + "x" + m.getValue());
                        }  
                
                        System.out.println("=====================================================");
                        System.out.println("\"USE ITEM\" => Press: \"NUMBER\"   \"BACK\" => Press: \"B\"");
                
                        System.out.print("Input: ");
                        c = scan.next().charAt(0);
                
                        switch(c) {
                            case '1': if(novice.bag.getHpInitAmount() == 0) break;
                                      novice.bag.itemList.replace("1. HP Potion (+100hp)", novice.bag.getHpInitAmount(), novice.bag.lostHpPotion());
                                      novice.usePotion(novice.bag.hpPotion.getPotionValue());
                                      break;
                
                            case '2': if(novice.bag.getMpInitAmount() == 0) break;
                                      novice.bag.itemList.replace("2. MP Potion (+50mp)", novice.bag.getMpInitAmount(), novice.bag.lostMpPotion());
                                      novice.usePotion(novice.bag.mpPotion.getPotionValue());
                                      break;
                
                            default:
                        }
                        System.out.println("\n\n\n");
                    } while(c != 'B' && c != 'b');
                }
                else if(c == 'Q' || c == 'q') {
                    System.exit(0);
                }
            }
            
        }
    }
}