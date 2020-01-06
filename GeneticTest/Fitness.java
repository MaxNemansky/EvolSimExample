package me.PythiusMalum.GeneticTest;

public class Fitness {
	
	static byte[] genomCorrect = {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1};
	
	static int getFitness(Individual individual) {
		int fitness = 0;
		for (int i = 0; i < 64; i++) {
			if (individual.getGene(i) == genomCorrect[i]) {
				fitness++;
			}
		}
		return fitness;
	}
	
	static int maxFitness() {
		return genomCorrect.length;
	}

}
