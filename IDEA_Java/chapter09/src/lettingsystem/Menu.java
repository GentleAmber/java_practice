package lettingsystem;

public class Menu {//Shows menu
    private String mainMenu =
            "-----------------Property Letting System-----------------\n" +
            "1  Add a property\n" +
            "2  Search for a property\n" +
            "3  Delete a property\n" +
            "4  Change property information\n" +
            "5  Property List\n" +
            "6  Exit\n\n" +
            "Please select (1-6):";

    public void showMainMenu() {
        System.out.println(mainMenu);
    }



}
