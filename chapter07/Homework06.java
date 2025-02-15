public class Homework06{
	public static void main(String[] args){
		double[] numArr1 = {7.8, 9}, numArr2 = {25.5,0};
		Cale tool1 = new Cale(numArr1[0],numArr1[1]);
		System.out.println("For numbers " + numArr1[0] + ", " + numArr1[1] + ": ");
		System.out.println("Sum: " + tool1.add() + "\nProduct: " + tool1.multiply() + 
			"\nDifference: " + tool1.subtract() + "\nQuotient: " + tool1.divide());

		Cale tool2 = new Cale(numArr2[0],numArr2[1]);
		System.out.println("For numbers " + numArr2[0] + ", " + numArr2[1] + ": ");
		System.out.println("Sum: " + tool2.add() + "\nProduct: " + tool2.multiply() + 
			"\nDifference: " + tool2.subtract() + "\nQuotient: " + tool2.divide());
	}
}

class Cale{
	double num1, num2;

	public Cale(double num1, double num2){
		this.num1 = num1;
		this.num2 = num2;
	}

	public double add(){
		return num1 + num2;
	}
	public double multiply(){
		return num1 * num2;
	}
	public double subtract(){
		return num1 - num2;
	}
	public Double divide(){
		if(num2 == 0){
			System.out.println("The divisor cannot be 0!");
			return null;
		}else{
			return num1 / num2;
		}
	}
}