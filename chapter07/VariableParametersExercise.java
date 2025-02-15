public class VariableParametersExercise{
	public static void main(String[] args){
		ScoreMethod scoreMethod = new ScoreMethod();
		
		System.out.println("Name\tSubjects Taken\tTotal Score");
		scoreMethod.scoreSum("Wei Li", 95, 79.5, 85);
		scoreMethod.scoreSum("Jane Alexander", 95, 92.5, 89.5, 78);

	}
}

class ScoreMethod{
	public void scoreSum(String name, double... subjects){
		double sum = 0;
		for(int i = 0; i < subjects.length; i++){
			sum += subjects[i];
		}

		System.out.println(name + "\t" + subjects.length + "\t" + sum);
	}
}