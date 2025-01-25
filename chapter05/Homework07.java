public class Homework07{
	public static void main(String[] args){
		//Output a-z and Z-A
		for (int letter = 'a'; letter <= 'z'; letter++){
			System.out.print((char)letter + " ");
		}
		System.out.print("\n");
		for (int letter = 'Z'; letter >= 'A'; letter--){
			System.out.print((char)letter + " ");
		}
	}
}