package dndtools;

import java.util.Random;

public class ScoreDecider {
    public static void main(String[] args) {
//Used to roll ability scores

//        int[] abilityScores = new int[6];

//        AbilityScore abilityScore = new AbilityScore();
//        for (int i = 0; i < abilityScores.length; i++) {
//            abilityScores[i] = abilityScore.generateOne();
//        }
//        System.out.println("Ability scores are: ");
//        for (int i = 0; i < abilityScores.length; i++) {
//            System.out.print(abilityScores[i] + " ");
//        }

        OneD6 oneD6 = new OneD6();

        int[] hitPointDice = new int[7];
        for (int i = 0; i < hitPointDice.length; i++) {
            hitPointDice[i] = oneD6.roll1d6();
        }
        System.out.println("=============Hit point dices:==============");
        for (int i = 0; i < hitPointDice.length; i++) {
            System.out.println(hitPointDice[i] + " ");
        }
    }
}

class OneD6 {
    public int roll1d6() {
        Random ran = new Random();
        return ran.nextInt(6) + 1;
    }
}

class AbilityScore {
    int[] dices = new int[4];
    int[] highestThreeDices = new int[3];


    public int generateOne() {
        OneD6 oneD6 = new OneD6();

        int lowestDice;

        for (int i = 0; i < dices.length; i++) {
            dices[i] = oneD6.roll1d6();
        }

        lowestDice = dices[0];

        for (int i = 1; i < dices.length; i++) {
            if (lowestDice >= dices[i]) {
                lowestDice = dices[i];
            }
        }

        boolean lowestMet = false;
        for (int i = 0; i < dices.length; i++) {
            if (lowestDice == dices[i]) {
                lowestMet = true;
                lowestDice = -1;// prevent duplicate error
                continue;
            }
            if (lowestMet == false) {
                highestThreeDices[i] = dices[i];
            } else {
                highestThreeDices[i - 1] = dices[i];
            }
        }

        int highestThree = 0;
        for (int i = 0; i < highestThreeDices.length; i++) {
            highestThree += highestThreeDices[i];
        }

        return highestThree;

    }

    public void test(){
        System.out.println("================Dices================");
        for (int i = 0; i < dices.length; i++) {
            System.out.println(dices[i] + " ");
        }

        System.out.println("=============Highest dices=============");
        for (int i = 0; i < highestThreeDices.length; i++) {
            System.out.println(highestThreeDices[i] + " ");
        }

    }
}
