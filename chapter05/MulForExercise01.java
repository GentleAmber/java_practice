import java.util.Scanner;
public class MulForExercise01{
	public static void main(String[] args){

		Scanner scStudent = new Scanner(System.in);
		double allClassScore = 0;
		for (int classNum = 1; classNum <= 3; classNum++){
			double singleClassScore = 0;
			for (int student = 1; student <= 5; student++){
				System.out.println("Please input score of the student No. " + student + 
					" in Class No. " + classNum + ":");
				double temScore = scStudent.nextDouble();
				singleClassScore += temScore;
			}
			System.out.println("Average score of class No. " + classNum + 
				" is: " + (singleClassScore/5));
			allClassScore += singleClassScore;
		}
		System.out.println("Average score of all the classes is: " + 
			(allClassScore/15));
	}
}

class MulForExercise02{
	public static void main(String[] args){
		Scanner scStudent = new Scanner(System.in);
		int count = 0;
		for (int classNum = 1; classNum <= 3; classNum++){
			for (int student = 1; student <= 5; student++){
				System.out.println("Please input score of the student No. " + student + 
					" in Class No. " + classNum + ":");
				double temScore = scStudent.nextDouble();
				if(temScore >= 60){
					count ++;
				}
			}
		}
		System.out.println("Number of students that have passed: " + count);
	}
}

class MulForExercise03{
	public static void main(String[] args){
		for (int i = 1; i <= 9; i++){
			for (int j = 1; j <= i; j++){
				System.out.print(j + " * " + i + " = " + j * i + "\t");
			}
			System.out.print("\n");
		}
	}
}