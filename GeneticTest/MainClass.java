package me.PythiusMalum.GeneticTest;

public class MainClass{
	public static void main(String[] args) {
		
		Population myPopulation = new Population(Algorithm.getPopSize(), true);
		
		int generationCount = 0;
        while (myPopulation.getFittest().getFitness() < Fitness.maxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPopulation.getFittest().getFitness()+ " Average fitness: " + myPopulation.averageFitness() + " Fittest hash: " + myPopulation.getFittest().hashCode());
            myPopulation = Algorithm.evolvePopulation(myPopulation);
            
            try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
        }
        generationCount++;
        System.out.println("Generation: " + generationCount + " Fittest: " + myPopulation.getFittest().getFitness() + " Average fitness: " + myPopulation.averageFitness());
        System.out.println("Found perfect genome.");
	}
}
