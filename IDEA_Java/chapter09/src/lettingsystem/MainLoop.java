package lettingsystem;

import java.util.Scanner;

public class MainLoop {
    public static void main(String[] args) {
        int idAutomated = 0;

        Scanner scanner = new Scanner(System.in);
        char selection;
        Property[] properties = new Property[0];

        Menu menu = new Menu();
        do {
            menu.showMainMenu();

            selection = scanner.next().charAt(0);
            switch (selection) {
                case '1':
                    idAutomated++;
                    properties = new LettingSystem().addProperty(properties, idAutomated);
                    break;
                case '2':
                    new LettingSystem().searchProperty(properties);
                    break;
                case '3':
                    properties = new LettingSystem().deleteProperty(properties);
                    break;
                case '4':
                    new LettingSystem().changeInfo(properties);
                    break;
                case '5':
                    new LettingSystem().showPropertyList(properties);
                    break;
                case '6':
                    break;
                default:
                    System.out.println("Wrong input.");
            }
        }while(selection != '6');
    }
}
