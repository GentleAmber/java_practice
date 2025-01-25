import java.util.Scanner;
public class Pyramid{
	public static void main(String[] args){
		Scanner mySc = new Scanner(System.in);
		System.out.print("Please type in the level of the pyramid: ");
		int totalLevel = mySc.nextInt();
		for (int level = 1; level <= totalLevel; level++){
			for (int space = totalLevel - level; space >= 1; space--){
				System.out.print(" ");
			}
			for (int aster = 1; aster <= (level * 2 - 1); aster++){
					System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
class DiamondShape{
	public static void main(String[] args){
		Scanner mySc = new Scanner(System.in);
		System.out.print("Please type in the height of the diamond (>= 2): ");
		int height = mySc.nextInt();
		for (int level = 1; level <= 2 * height - 1; level++){
			//Print the upper and the middle levels of the diamond
			if (level <= height){
				//Pirnt space
				for (int space = 1; space <= height - level; space++){
					System.out.print(" ");
				}
				//Print asterisks
				for (int asterisk = 1; asterisk <= 2 * level - 1; asterisk++){
					//Make the inner space empty
					if (asterisk == 1 || asterisk == 2 * level - 1){
						System.out.print("*");
					}else{
						System.out.print(" ");
					}
				}
			//Print the lower part of the diamond
			}else{
				//Print space
				for (int space = 1; space <= level - height; space++){
					System.out.print(" ");
				}
				//Print asterisks
				for (int asterisk = 1; asterisk <= 2 * (2 * height - level) - 1; asterisk++){
					if (asterisk == 1 || asterisk == 2 * (2 * height - level) - 1){
						System.out.print("*");
					}else{
						System.out.print(" ");
					}
				}
			}
			System.out.print("\n");
		}
	}
}

class DiamondWithWhile{
	public static void main(String[] args){
		Scanner mySc = new Scanner(System.in);
		System.out.print("Please type in the height of the diamond (>= 2): ");
		int height = mySc.nextInt();//Receive the height

		//Parameters initialisation for upper levels (including the intermidiate one)
		int level = 1, upperSpace = 1, upperAsterisk = 1;
		//Parameters initialisation for lower levels
		int lowerSpace = 1, lowerAsterisk = 1;
		
		//Cooking
		while (level <= 2 * height - 1){
			//Start drawing the upper part!
			if (level <= height){
				//Print space
				upperSpace = 1;
				while (upperSpace <= height - level){
					System.out.print(" ");
					upperSpace++;
				}
				//Print asterisks
				upperAsterisk = 1;
				while (upperAsterisk <= 2 * level - 1){
					if(upperAsterisk == 1 || upperAsterisk == 2 * level - 1){
						System.out.print("*");
					}else{
						System.out.print(" ");
					}
					upperAsterisk++;
				}
			//Print the lower part
			}else{
				//Print space
				lowerSpace = 1;
				while (lowerSpace <= level - height){
					System.out.print(" ");
					lowerSpace++;
				}
				//Print asterisks
				lowerAsterisk = 1;
				while (lowerAsterisk <= 2 * (2 * height - level) - 1){
					if (lowerAsterisk == 1 || lowerAsterisk == 2 * (2 * height - level) - 1){
						System.out.print("*");
					}else{
						System.out.print(" ");
					}
					lowerAsterisk++;
				}
			}
			System.out.print("\n");
			level ++;
		}
	}
}

class DiamondWithWhileTest{
	public static void main(String[] args){
		int STATIC_HEIGHT = 3;
		int upperSpace = 1, upperAsterisk = 1, lowerSpace = 1, lowerAsterisk = 1;
		for (int level = 1; level <= 2 * STATIC_HEIGHT - 1; level++){
			if (level <= STATIC_HEIGHT){
				//Print space correct?
				upperSpace = 1;
				while (upperSpace <= STATIC_HEIGHT - level){
					System.out.print(" ");
					upperSpace++;
				}
				System.out.print(level);
			}else{
				lowerSpace = 1;
				while (lowerSpace <= level - STATIC_HEIGHT){
					System.out.print(" ");
					lowerSpace++;
				}
				System.out.print(level);
			}
			System.out.print("\n");
		}
	}
}