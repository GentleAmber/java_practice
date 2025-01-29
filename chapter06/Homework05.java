public class Homework05{
	public static void main(String[] args){
		//Generate 10 random integers between 1-100, save them into an array
		//Print them in a reverse order and output:
		//average value, indices for the max and min values
		//And check if there's number 8 in them

		int[] randomArr = new int[10];
		double average, sum = 0;
		int maxIndex = 0, minIndex = 0;
		boolean ifThereIsEight = false;

		//Generate the array
		for(int i = 0; i < randomArr.length; i++){
			randomArr[i] = (int)(Math.random() * 100 + 1);
		}
		
		//Get the average value + indices
		int maxNum = randomArr[0], minNum = randomArr[0];
		for(int i = 0; i < randomArr.length; i++){
			if(maxNum < randomArr[i]){
				maxNum = randomArr[i];
				maxIndex = i;
			}
			if(minNum > randomArr[i]){
				minNum = randomArr[i];
				minIndex = i;
			}
			if(randomArr[i] == 8){
				ifThereIsEight = true;
			}
			sum += randomArr[i];
		}
		average = sum/randomArr.length;

		//Print the results
		System.out.println("The array in a reverse order: ");
		for(int i = randomArr.length - 1; i >= 0; i--){
			System.out.print(randomArr[i] + " ");
		}
		System.out.print("\nThe average of all the elements in the array is: " + average + 
			".\nThe index of the maximum number is: " + maxIndex + 
			".\nThe index of the minimum number is: " + minIndex + 
			".\n");
		if(ifThereIsEight){
			System.out.print("There is number 8 in the array.");
		}else{
			System.out.print("There is NO number 8 in the array.");
		}
	}
}