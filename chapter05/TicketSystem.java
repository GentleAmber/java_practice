import java.util.Scanner;
public class TicketSystem{

	public static void main(String[] args){

		Scanner info = new Scanner(System.in);
		System.out.println("Please type in the current month:");
		int month = info.nextInt();
		System.out.println("Please type in your age:");
		int age = info.nextInt();

		int ticketPriceBusySeason = 60;
		int ticketPriceOffSeason = 40;

		if(4 <= month && month <= 10){
			//busy season
			if(age < 18){
				System.out.println("This is busy season and you're under 18, so the ticket price is: "
					+ ticketPriceBusySeason/2);
			}else if(age <= 60){
				System.out.println("This is busy season and you're an adult, so the ticket price is: "
					+ ticketPriceBusySeason);
			}else{
				System.out.println("This is busy season and you're an elder, so the ticket price is: "
					+ ticketPriceBusySeason/3);
			}

		}else{
			//off season
			if(18 <= age && age <= 60){
				System.out.println("This is off season and you're an adult, so the ticket price is: "
					+ ticketPriceOffSeason);
			}else{
				System.out.println("This is off season and you're either a child or an elder, so the ticket price is: "
					+ ticketPriceOffSeason/2);
			}
		}

	}

}