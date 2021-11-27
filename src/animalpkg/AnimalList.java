package animalpkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AnimalList extends ArrayList<Animal> {
    //    ArrayList<Animal>list;
    AnimalTypeList typeList;

    //creating a list of animals with available type list
    public AnimalList(AnimalTypeList typeList) {
        super();
        this.typeList = typeList;
    }

    //Search an animal based on ID-Using linear search
    public int search(String ID) {
//        Scanner sc=new Scanner(System.in);
        ID = ID.trim().toLowerCase();
//        ID=sc.nextLine();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equalsIgnoreCase(ID))
                return i;
        }
        return -1;
    }

    public boolean loadFromFile(String fName) {
        FileReader fr = null;
        BufferedReader br = null;
        String line = null;
        StringTokenizer stk = null;
        try {
            fr = new FileReader(fName);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.length() > 0) {
                    stk = new StringTokenizer(line, ";");
                    String ID = stk.nextToken();
                    String name = stk.nextToken();
                    int type = Integer.parseInt(stk.nextToken());
                    AnimalTypes aType = this.typeList.get(typeList.search(type));
                    if (aType == null) {
                        System.out.println("This animal type is not supported");
                        System.exit(0);
                    }
                    String color = stk.nextToken();
                    double weight = Double.parseDouble(stk.nextToken());
                    String S;

                    Animal animal;
                    switch (type) {
                        case 1:
                            S = stk.nextToken().trim().toUpperCase();
                            boolean poisonous = S.startsWith("T");
                            animal = new ZLA(ID, name, aType, color, weight, poisonous);
                            this.add(animal);
                            break;
                        //Format: BFLA;Penguin 01;2;black;3.5;true
                        case 2:
                            S = stk.nextToken().trim().toUpperCase();
                            boolean cute = S.startsWith("T");
                            animal = new BFLA(ID, name, aType, color, weight, cute);
                            this.add(animal);
                            break;
                        case 3://BFA01; pigeon 01;3; white; 0.3;false
                            S = stk.nextToken().trim().toUpperCase();
                            boolean heroic = S.startsWith("T");
                            animal = new BFA(ID, name, aType, color, weight, heroic);
                            this.add(animal);
                            break;
                        case 4:
                            S = stk.nextToken().trim();
                            boolean canGrowl = S.startsWith("T");
                            S = stk.nextToken().trim().toUpperCase();
                            boolean dangerr = S.startsWith("T");
                            animal = new FLA(ID, name, aType, color, weight, canGrowl, dangerr);
                            this.add(animal);
                            break;
                    }
                }
            }
            //closing the openned file
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    //Saving animals to file
    public boolean writeToFile(String fName) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            //open the character file for writing
            fw = new FileWriter(fName);
            pw = new PrintWriter(fw);
            for (int i = 0; i < this.size(); i++)
                pw.println(this.get(i).strtoFile());
            //closing the opened file
            pw.flush();
            System.out.println("Writing file :DONE.");
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public void add() {
        String ID;
        String name;
        AnimalTypes type = null;
        String color;
        double weight;
        //INput new animal's properties
        boolean duplicated;
        do {
            ID = MyScanner.getNonBlankStr("Input it's ID");
            ID = ID.trim();
            duplicated = (this.search(ID) >= 0);
            if (duplicated)
                System.out.println("ID is duplicated!");
        } while (duplicated);
        do {
            name = MyScanner.getNonBlankStr("Input it's name: ");
            name = name.trim();
            duplicated = (this.search(name) >= 0);
            if (duplicated)
                System.out.println("Name is duplicated!");
        } while (duplicated);
        type = this.typeList.chooseType();
        color = MyScanner.getNonBlankStr("input it's color");
        weight = MyScanner.getDouble("Input it's weight", 300);
        Animal newAnimal = null;
        int intType = type.getType();
        switch (intType) {
            case AnimalTypes.ZLA:
                weight = MyScanner.getDouble("Input it's weight", 300);
                boolean poison = MyScanner.getBoolean("Is it poisionous?");
                newAnimal = new ZLA(ID, name, type, color, weight, poison);
                this.add(newAnimal);
                break;
            case AnimalTypes.BFA:
                boolean heroic = MyScanner.getBoolean("Is it heroic?");
                newAnimal = new BFA(ID, name, type, color, weight, heroic);
                this.add(newAnimal);
                break;
            case AnimalTypes.BLFA:
                boolean cute = MyScanner.getBoolean("Is it cute?");
                newAnimal = new BFLA(ID, name, type, color, weight, cute);
                this.add(newAnimal);
                break;
            case AnimalTypes.FLA:
                boolean canGrowl = MyScanner.getBoolean("Is it Growl?");
                boolean danger = MyScanner.getBoolean("Is it danger?");
                newAnimal = new FLA(ID, name, type, color, weight, canGrowl, danger);
                this.add(newAnimal);
                break;
            default:
                System.out.println("This animal type is not supported");

        }
        // add new animal to the list
//            if (newAnimal != null) {
//                this.add(newAnimal);
//                System.out.println("Add operation is succesful");
//            }
    }

    //Update properties of an animal based on an inputted ID
    //User can update all animal's properties.So.
    //Updating an animmal means that replacing it with a new animal
    public void Update() {
        String ID = "";
//                Scanner sc=new Scanner(System.in);
        ID = MyScanner.getNonBlankStr("Input it's ID: ");
        int pos = this.search(ID);
        if (pos < 0) System.out.println("Animal" + ID + "does not exist");
        else {
            this.remove(this.get(pos));
            System.out.println("Input new details");
            add();
        }
    }

    public void delete() {
        String ID = "";
        boolean cofirm;
        ID = MyScanner.getNonBlankStr("Input its ID to deleted");
        int pos = this.search(ID);
        if (pos < 0)
            System.out.println("Animal" + ID + "does not exist!");
        else {
            cofirm=MyScanner.getBoolean("Do you want to deleted this animal?");
            if(cofirm==true){
                this.remove(this.get(pos));
                System.out.println("the animal"  + ID + " has been deleted ");
            }else {
                System.out.println("Exist");
            }
        }
    }

    public void printByName() {
        String chosenName;
        chosenName = MyScanner.getNonBlankStr("Input name to print: ");
        int count = 0;
        for (Animal a : this
        ) {
            if (a.getName().compareTo(chosenName) == 0) {
                System.out.println(a);
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Result");
            System.out.println(count +" "+ "animals");
        } else {
            System.out.println("No result is found");
        }
    }

    public void prinByType() {
        int chosenType;
        int maxType = this.typeList.size();
        chosenType = MyScanner.getInt("Input animal type", 1, maxType);
//        System.out.println("Result");
        int count = 0;
        for (Animal a : this
        ) {
            if (a.type.getType() == chosenType) {
                System.out.println(a);
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Result");
            System.out.println(count + "animals");
        }
        else System.out.println("No result is found");
    }

    public void showAll() {
        if (this.isEmpty())
            System.out.println("The animal list is empty");
        else {
            for (Animal a : this
            ) {
                System.out.println(a.strtoFile());
            }
        }

    }
}

