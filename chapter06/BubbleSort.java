public class BubbleSort{

	public static void main(String[] args){
		//Bubble sort this number sequence: 24, 69, 80, 57, 13
		int sequence[] = {24, 69, 80, 57, 13, 48, 23, 80, 99, 159, 34, 50};
		//Method:
		//Compare pairs of numbers from the left to the right, and exchange the two numbers when
		//the right one < the left one.
		//Every time an exchange happens, the number that's changed to left should be compared all the way
		//down left until it finds its position		
		for (int i = 0; i < sequence.length - 1; i++){
			if (sequence[i] > sequence[i+1]){
				int tempNumber = sequence[i];
				sequence[i] = sequence[i+1];
				sequence[i+1] = tempNumber;
				//The exchange has happened, so
				//if the current is not the bottom left position, start comparison all the way down left.
				if (i != 0){
					//If this is not the bottom left position, then the new left number should be compared all
					//the way down to the left. Every time it's smaller than the current number, they should 
					//be swapped.
					for (int j = i; j > 0; j--){
						if (sequence[j] < sequence[j - 1]){
							int temp = sequence[j];
							sequence[j] = sequence[j - 1];
							sequence[j - 1] = temp;
						}
					}
				}
			}
		}
		System.out.println("After bubble sorting: ");
		for (int i = 0; i <sequence.length; i++){
			System.out.print(sequence[i] + " ");
		}
	}
}