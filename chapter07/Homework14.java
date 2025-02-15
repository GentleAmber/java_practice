import java.util.Random;
public class Homework14{
	public static void main(String[] args){
		//Play rock-paper-scissors with computers for 3 times and show the winning times
		//and losing times.
		//0: rock, 1: scissors, 2: paper
		Tom t = new Tom();
		t.play(0,0);
		t.play(1,0);
		t.play(2,2);
		t.results();

	}
}

class Tom{
	int[] roundResults = new int[3];//1:Tom wins, 0: Tie, -1:Tom loses
	int[][] roundInfo = new int[3][2];//int[][0]: Tom's situation, int[][1]: Computer's situation

	public void play(int round, int rpsT){			
		roundInfo[round][0] = rpsT;

		Random rand = new Random();
		int rpsC = rand.nextInt(3);
		roundInfo[round][1] = rpsC;

		ifTomWins(round,rpsT,rpsC);
	}

	public void ifTomWins(int round, int rpsT, int rpsC){
		if(rpsT == rpsC){
			roundResults[round] = 0;
		}else if(rpsT == 0){
			if(rpsC == 1){
				roundResults[round] = 1;
			}else{
				roundResults[round] = -1;
			}
		}else if(rpsT == 1){
			if(rpsC == 0){
				roundResults[round] = -1;
			}else{
				roundResults[round] = 1;
			}
		}else if(rpsT == 2){
			if(rpsC == 0){
				roundResults[round] = 1;
			}else{
				roundResults[round] = -1;
			}
		}
	}

	public String winner(int result){
		switch(result){
		case 1: return "Tom";
		case 0: return "Tie/None";
		case -1: return "Computer";
		default: return "Wrong input! Please check.";
		}
	}

	public void results(){
		System.out.println("Round\tWinner\tTom\tComputer");
		for(int i = 0; i < 3; i++){
			System.out.println("Round" + (i + 1) + "\t" + winner(roundResults[i])
		 + "\t" + roundInfo[i][0] + "\t" + roundInfo[i][1]);
		}
		
	}
}