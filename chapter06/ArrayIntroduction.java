public class ArrayIntroduction{
	public static void main(String[] args){
		//Static initialization
		//There are 6 chiken, whose weights are 3kg, 5kg, 1kg, 3.4kg, 2kg, 50kg.
		//Calculate their average weight.
		//If using 6 variables for 6 weights, the programme will be too redundant.
		//We're going to introduce array here:
		double[] hens = {3, 5, 1, 3.4, 2, 50, 7.8};//double[] means an array for doubles
		double totalweight = 0;

		//Use hens[i] to get elements in the array. i starts from 0.
		for(int i = 0; i < hens.length; i++){
			//System.out.print(hens[i] + ", ");
			totalweight += hens[i];
		}
		System.out.print("The average weight is: " + totalweight/hens.length);
	}
}