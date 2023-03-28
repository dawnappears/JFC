package TUI;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu(List<String> menuItems){
        this.menuItems = menuItems;
        this.menuItems.add("Выход");
        exitIndex = this.menuItems.size() - 1;
    }

    private List<String> menuItems;
    private Scanner in = new Scanner(System.in);
    public int exitIndex;

    public void show(){
        System.out.println("\n\n========== Menu ==========\n");
        for(int i =0; i < menuItems.size(); i++){
            System.out.println(i + " -> " + menuItems.get(i));
        }
        System.out.println("==========================");
    }


    public int select(){
        System.out.print("\nВыбор >> ");
        int choice = in.nextInt();
        if (choice < 0 || choice >= menuItems.size()){
            throw new ArrayIndexOutOfBoundsException("Menu element under specified index doesn't exist");
        }
        return choice;
    }
}
