package homework;

public class Homework03_NameFormat {
    public static void main(String[] args) {
        String name = "Tommy Marriot Turnipseed";
        System.out.println("Name is: " + name);
        //Format it to "Clinton, William .J"
        try {
            nameVerification(name);
            System.out.println("After formatted: " + nameFormatter(name));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void nameVerification(String name) {
        char[] chars = name.toCharArray();
        int spaceCount = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                spaceCount++;
            else
                if (!Character.isLetter(chars[i]))
                    throw new RuntimeException("Illegal character.");
        }

        if (spaceCount != 2)
            throw new RuntimeException("Wrong format.");
    }

    public static String nameFormatter(String name) {
        String[] words = name.split(" ");
        String newName = words[2] + ", " +words[0] + " ." + words[1].charAt(0);
        return newName;
    }
}