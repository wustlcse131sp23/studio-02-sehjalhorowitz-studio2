package studio2;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What is your start amount?");
		int startAmount = in.nextInt();
		int resetAmount = startAmount; 
		System.out.println("What is your win chance?");
		double winChance = in.nextDouble();
		System.out.println("What is your win limit?");
		int winLimit = in.nextInt();
		System.out.println("How many simulations do you want to run?");
		int totalSimulations = in.nextInt();
		int simulationsRan;
		int simulationNumber = 0;
		int gamesPlayed = 0;
		int totalLosses = 0;
		double a = (1-winChance)/winChance;
		String result = "";
		
		
		for (simulationsRan = 0;  simulationsRan < totalSimulations; simulationsRan++) 
		{
			while (startAmount > 0 && startAmount < winLimit)
			{
				
				double randomValue = Math.random();
				if (randomValue > winChance)
				{
					startAmount--;
					gamesPlayed++;
				}
				else {
					startAmount++;
					gamesPlayed++;
				}
				
			}
			if (startAmount == 0) 
			{
				result = "Ruin";
				simulationNumber++;
				totalLosses++;
			}
			else 
			{
				result = "Win";
				simulationNumber++;
			}
			System.out.println("Simulation " + simulationNumber + ": " + gamesPlayed + " " + result);
			startAmount = resetAmount; 
			gamesPlayed = 0; 
		}
			System.out.println("Losses: " + totalLosses + " Simulations: " + simulationsRan);
			double expectedRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
			double ruinRate = Math.round(((double) totalLosses/simulationsRan)*100)/100.0;
			System.out.println("Ruin Rate from Simulation: " + ruinRate + " Expected Ruin Rate: " + expectedRuin);
	}

}
