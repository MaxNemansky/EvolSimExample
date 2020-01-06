package me.PythiusMalum.GeneticTest;

import java.util.concurrent.ThreadLocalRandom;

public class Algorithm {
	private static final double mutationRate = 0.015;
	private static final int popSize = 50;
	
	public static int getPopSize() {
		return popSize;
	}
	
	public static Population evolvePopulation(Population pop) {
		Population newPopulation = new Population(popSize, true);
		double potencySum = pop.fullPotency();
		
		for (int i = 0; i < popSize; i++) {
			double randomDouble = ThreadLocalRandom.current().nextDouble(0, potencySum);
			int fitnessIndivSum = 0;
			Individual parentOne = null;
			Individual parentTwo = null;
			boolean foundHim1 = false;
			boolean foundHim2 = false;
			
			for (int p = 0; p < popSize; p++) {
				fitnessIndivSum += Math.pow(pop.individuals[p].getFitness(), 1 + 1/16);
				if (randomDouble < fitnessIndivSum && foundHim1 == false) {
					foundHim1 = true;
					parentOne = pop.individuals[p];
				}
			}
			
			fitnessIndivSum = 0;
			randomDouble = ThreadLocalRandom.current().nextDouble(0, potencySum);

			for (int p = 0; p < popSize; p++) {
				fitnessIndivSum += Math.pow(pop.individuals[p].getFitness(), 1 + 1/16);
				if (randomDouble < fitnessIndivSum && foundHim2 == false) {
					foundHim2 = true;
					parentTwo = pop.individuals[p];
				}
			}
			
			Individual indiv = new Individual();
			
			for (int p = 0; p < 64; p++) {
				byte byteExact;
				double randDoubleForGene = Math.random() * (parentOne.getFitness() + parentTwo.getFitness());
				if (randDoubleForGene < parentOne.getFitness()) {
					byteExact = parentOne.getGene(p);
				} else {
					byteExact = parentTwo.getGene(p);
				}
				
				if (Math.random() < mutationRate) {
					byteExact = (byte) Math.round(Math.random());
				}
				
				indiv.setGene(p, byteExact);
			}
			newPopulation.saveIndividual(i, indiv);
		}
		newPopulation.saveIndividual(0, pop.getFittest());
		return newPopulation;
	}
}
