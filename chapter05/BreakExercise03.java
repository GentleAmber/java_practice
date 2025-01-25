import java.util.Scanner;
public class BreakExercise03{
	public static void main(String[] args){
		//Login verification:
		//There are 3 chances. If the user name is "Jack" and password is "666", login success.
		//If not successful, prompts the number of chances to try
		//Use for + break
		Scanner mySc = new Scanner(System.in);
		String CORRECT_NAME = "Jack";
		String CORRECT_PASSWORD = "666";

		for (int i = 3; i >= 1; i--){
			System.out.print("User name: ");
			String userName = mySc.next();
			System.out.print("Password: ");
			String password = mySc.next();
			/*
			Method "equals" should be used to compare strings.
			userName.equals(CORRECT_NAME) and CORRECT_NAME.equals(userName) can both do the job,
			but the latter one is recommended to avoid void pointer (will be taught in later chapters)
			*/  
			if (CORRECT_NAME.equals(userName) && password.equals(CORRECT_PASSWORD)){
				System.out.print("Login success!");
				break;
			}else{
				System.out.print("Wrong user name or password.\n");
				System.out.print("You have " + (i - 1) + " more chances.\n");
			}
		}
	}
}