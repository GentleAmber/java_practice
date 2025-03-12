package lettingsystem;

import java.util.Scanner;

public class LettingSystem {//Main operating system



    public Property[] addProperty(Property[] properties, int idAutomated) {
        Property[] tempPropertyArray = new Property[properties.length + 1];
        for (int i = 0; i < properties.length; i++) {
            tempPropertyArray[i] = properties[i];
        }

        Scanner scanner = new Scanner(System.in);

        Property newProperty = new Property();
        System.out.println("Landlord: ");
        newProperty.setLandlord(scanner.nextLine());
        System.out.println("Landlord tel: ");
        newProperty.setLandlordTel(scanner.next());
        System.out.println("Property address: ");
        scanner.nextLine();
        newProperty.setAddress(scanner.nextLine());
        System.out.println("Monthly rent: ");
        newProperty.setMonthlyRent(scanner.nextDouble());
        System.out.println("Rented or not (y/n): ");
        char ifRent = scanner.next().charAt(0);
        switch (ifRent) {
            case 'y':
            case 'Y':
                newProperty.setStatus(true);
                break;
            case 'n':
            case 'N':
                newProperty.setStatus(false);
                break;
            default:
                System.out.println("Wrong input. Will set to the default value: not rented.");
                newProperty.setStatus(false);
                break;
        }
        newProperty.setId(idAutomated);

        tempPropertyArray[properties.length] = newProperty;
        return tempPropertyArray;
    }

    public void showPropertyList(Property[] properties) {
        System.out.println("--------------------Property List--------------------");
        System.out.println("Id\t\tLandlord\tLandlord Tel\t\t\tAddress\t\t\t\t\tMonthly Rent\tStatus");
        for (int i = 0; i < properties.length; i++) {
            System.out.println(properties[i].toString());
        }
    }

    public Property[] deleteProperty(Property[] properties) {
        showPropertyList(properties);
        System.out.println("Which property would you like to delete? Please BE CAUTIOUS operating this.");
        System.out.println("Please type in the id: ");
        Scanner scanner = new Scanner(System.in);
        int deletedID = scanner.nextInt();

        boolean ifDeleted = false;
        for (int i = 0; i < properties.length; i++) {
            if (ifDeleted == false) {
                if (properties[i].getId() == deletedID) {
                    ifDeleted = true;
                }
            } else {
                properties[i - 1] = properties[i];
            }
        }

        Property[] tempArr = new Property[properties.length - 1];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = properties[i];
        }

        return tempArr;
    }

    public void changeInfo(Property[] properties) {
        showPropertyList(properties);
        System.out.println("Which property information would you like to change?");
        System.out.println("Please type in the id: ");

        Scanner scanner = new Scanner(System.in);
        int toBeChangedID = scanner.nextInt();

        Property newProperty = new Property();
        boolean ifChanged = false;
        int cursor = -1;

        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getId() == toBeChangedID) {
                System.out.println("Type in the new information. Note you can press Enter if a line" +
                        " doesn't need amending.");
                newProperty = userInputA2(properties[i]);
                ifChanged = true;
                cursor = i;
                break;
            }
            if (i == properties.length - 1) {
                System.out.println("Wrong id. Please double check.");
            }
        }
        //If anything's changed in the buffer, update it to the real property
        if (ifChanged == true) {
            if (!newProperty.getLandlord().isEmpty())
                properties[cursor].setLandlord(newProperty.getLandlord());
            if (!newProperty.getLandlordTel().isEmpty())
                properties[cursor].setLandlordTel(newProperty.getLandlordTel());
            if (!newProperty.getAddress().isEmpty())
                properties[cursor].setAddress(newProperty.getAddress());
            if (newProperty.getMonthlyRent() != 0)
                properties[cursor].setMonthlyRent(newProperty.getMonthlyRent());
            properties[cursor].setStatus(newProperty.getStatus());
        }

        System.out.println("Info changed successfully! The new info for this property is: ");
        System.out.println(properties[cursor].toString());
    }


    public Property userInputA2 (Property existingProperty) {
        Scanner scanner = new Scanner(System.in);
        Property nP = new Property();

        System.out.println("Landlord(" + existingProperty.getLandlord() + "): ");
        nP.setLandlord(scanner.nextLine());

        System.out.println("Landlord tel(" + existingProperty.getLandlordTel() + "): ");
        nP.setLandlordTel(scanner.nextLine());

        System.out.println("Property address(" + existingProperty.getAddress() + "): ");
        nP.setAddress(scanner.nextLine());

        System.out.println("Monthly rent(" + existingProperty.getMonthlyRent() + "): ");
        String mRentInput = scanner.nextLine();
        if (!mRentInput.isEmpty()) {
            try {
                nP.setMonthlyRent(Double.parseDouble(mRentInput));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for rent, using default (0). ");
                nP.setMonthlyRent(0);
            }
        }

        System.out.println("Rented or not (y/n)(" + existingProperty.getStatus() + "): ");
        String status = scanner.nextLine();
        if (!status.isEmpty()) {
            switch (status.charAt(0)) {
                case 'y':
                case 'Y':
                    nP.setStatus(true);
                    break;
                case 'n':
                case 'N':
                    nP.setStatus(false);
                    break;
                default:
                    System.out.println("Wrong input. Won't change anything.");
                    nP.setStatus(existingProperty.getStatus());
            }
        }
        return nP;
    }

    public void searchProperty(Property[] properties) {
        System.out.println("Please select what's used for search: ");
        System.out.println("1: ID, 2: Landlord, 3: post code");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        int searchID = -1;
        String landlord;
        String postcode;


        switch (choice) {
            case 1:
                System.out.println("Type in the id please: ");
                searchID = scanner.nextInt();
                searchProperty(properties, searchID);
                break;
            case 2:
                System.out.println("Type in the landlord please: ");
                scanner.nextLine();
                landlord = scanner.nextLine();
                searchProperty(properties, landlord, false);
                break;
            case 3:
                System.out.println("Type in the post code please: ");
                scanner.nextLine();
                postcode = scanner.nextLine();
                searchProperty(properties, postcode, true);
                break;
            default:
                System.out.println("Wrong choice.");
        }

    }

    public void searchProperty(Property[] properties, int searchID) {
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getId() == searchID) {
                System.out.println(properties[i].toString());
                break;
            }
            if (i == properties.length - 1) {
                System.out.println("No record found!");
            }
        }
    }

    public void searchProperty(Property[] properties, String postcodeOrLandlord, boolean ifPostcode) {
        int record = 0;
        String foundRecords = "Matching records are: \n";
        if (ifPostcode) {
            for (Property property : properties) {
                if (property.getAddress().contains(postcodeOrLandlord)) {
                    foundRecords += property.toString() + "\n";
                    record++;
                }
            }
        } else {
            for (Property property : properties) {
                if (property.getLandlord().contains(postcodeOrLandlord)) {
                    foundRecords += property.toString() + "\n";
                    record++;
                }
            }
        }

        if (record == 0) {
            System.out.println("No record found!");
        } else {
            System.out.println(foundRecords);
        }
    }


}




