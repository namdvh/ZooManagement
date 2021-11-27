package Default;

import animalpkg.AnimalList;
import animalpkg.AnimalTypeList;
import animalpkg.MENU;
import animalpkg.MyScanner;

import java.lang.reflect.Member;
import java.rmi.MarshalException;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileTypes = "AnimalTypes.txt";
        String fileAnimals = "Animals.txt";

        MENU mainMenu = new MENU("\nManaging animals-Main menu");
        mainMenu.add("Add new animal");
        mainMenu.add("Update animal");
        mainMenu.add("Delete animal");
        mainMenu.add("Search animal");
        mainMenu.add("Show animal list");
        mainMenu.add("Store data to file");
        int mainchoice;
        MENU searchMenu = new MENU("choose search option ");
        searchMenu.add("Search by name: ");
        searchMenu.add("Search by type ");
        MENU showMenu = new MENU("choose show option: ");
        showMenu.add("Show by type");
        showMenu.add("Show all");
        int subChoice;
        AnimalTypeList typeList = new AnimalTypeList();
        typeList.loadFromFile(fileTypes);
        AnimalList aList = new AnimalList(typeList);
        aList.loadFromFile(fileAnimals);
        boolean changed = false;
        do {
            mainchoice = mainMenu.getUserChoice();
            switch (mainchoice) {
                case 1:
                    aList.add();
                    changed = true;
                    break;
                case 2:
                    aList.Update();
                    changed = true;
                    break;
                case 3:
                    aList.delete();
                    changed = true;
                    break;
                case 4:
                    do {
                        subChoice = searchMenu.getUserChoice();
                        switch (subChoice) {
                            case 1:
                                aList.printByName();
                                break;
                            case 2:
                                aList.prinByType();
                                break;
                        }
                    } while (subChoice > 0 && subChoice <= searchMenu.size());
                    break;
                case 5:
                    do {
                        subChoice = showMenu.getUserChoice();
                        switch (subChoice) {
                            case 1:
                                aList.prinByType();
                                break;
                            case 2:
                                Collections.sort(aList);
                                aList.showAll();
                                break;
                        }
                    } while (subChoice > 0 && subChoice <= showMenu.size());
                    break;
                case 6:
                    aList.writeToFile(fileAnimals);
                    changed = false;
                    break;
                default:
                    if (changed) {
                        boolean respone = MyScanner.getBoolean("Save changes to file?");
                        if (respone == true)
                            aList.writeToFile(fileAnimals);
                    }

            }
        } while (mainchoice > 0 && mainchoice <= mainMenu.size());
    }
}
