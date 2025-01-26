public class ArrayExercise02{
	public static void main(String[] args){
		int practice[] = {4, -1, 9, 10, 23};
		int maxNumber = practice[0];
		int index = 0;
		for (int i = 0; i < practice.length; i++){
			if (practice[i] >= maxNumber){
				maxNumber = practice[i];
				index = i;
			}
		}
		System.out.println("The max number is: " + maxNumber);
		System.out.println("The according index is: " + index);
	}
}