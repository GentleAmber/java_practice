public class BreakDetails {
	public static void main(String[] args) {
		//We can use labels to break the codes accordingly.
		//If not specified, it only breaks the current loop.
		label1:
		for (int j = 0; j < 4; j++){
		label2:
			for (int i = 0; i < 10; i++){
				if(i == 2){
					break label1;
				}
				System.out.println("i = " + i + ", j = " + j);
			}
		}
	}
}