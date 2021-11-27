package animalpkg;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AnimalTypeList extends ArrayList<AnimalTypes> {
    //    ArrayList<AnimalTypes>list;
//    public AnimalTypeList(){
//        list=new ArrayList<AnimalTypes>();
//    }
    public boolean loadFromFile(String fName) {
        FileReader fr = null;
        BufferedReader bf = null;
        String line = "";
        StringTokenizer stk = null;
        try {
            fr = new FileReader(fName);
            bf = new BufferedReader(fr);
            while ((line = bf.readLine()) != null) {
                line = line.trim();
                if (line.length() > 0 && !line.startsWith("//")) {
                    stk = new StringTokenizer(line, ";");
                    int type = Integer.parseInt(stk.nextToken().trim());
//                    if(search(type)>=0){
//                        System.out.println("Animal type is duplicated.check again" + fName);
//                        System.out.println(0);
//                    }
                    String desc = stk.nextToken();
                    int numLegs = Integer.parseInt(stk.nextToken());
                    int numSwings = Integer.parseInt(stk.nextToken());
                    String moving = stk.nextToken();
                    boolean canSing = Boolean.parseBoolean(stk.nextToken());
                    boolean canGrowl = Boolean.parseBoolean(stk.nextToken());
                    boolean canFly = Boolean.parseBoolean(stk.nextToken());
                    String food = stk.nextToken();
                    double maxWeight = Double.parseDouble(stk.nextToken());
                    AnimalTypes tmp = new AnimalTypes(type, desc, numLegs, numSwings, moving, canFly, canSing, canGrowl, food, maxWeight);
                    this.add(tmp);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }

    public int search(int typeID) {
        for (AnimalTypes x : this
        ) {
            if (x.getType() == typeID)
                return typeID;
        }
        return 0;
    }

    //Create a menu for choosing an animal type when user inputs an animal
    private MENU createMenu() {
        MENU mnu = new MENU("Choose animal type");
        for (int i = 0; i < this.size(); i++) {
            mnu.add(this.get(i).getDesc());
        }
        return mnu;
    }

    //Choosing a type using a menu when user inputs an animal
    public AnimalTypes chooseType() {
        MENU mnu = this.createMenu();
        return this.get(mnu.getUserChoice2() - 1);
    }
}
