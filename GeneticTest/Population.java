package me.PythiusMalum.GeneticTest;

public class Population {
	 Individual[] individuals;
	   public Population(int populationSize, boolean initialise) {
	       individuals = new Individual[populationSize];
	       if (initialise) {
	           for (int i = 0; i < individuals.length; i++) {
	               Individual newIndividual = new Individual();
	               newIndividual.generateIndividual();
	               saveIndividual(i, newIndividual);
	           }
	       }
	   }
	   
	   public Individual getIndividual(int i) {
		   return individuals[i];
	   }
	   
	   public Individual getFittest() {
		   Individual fittest = individuals[0];
		   for (Individual indiv : individuals) {
			   if (indiv.getFitness() > fittest.getFitness()) {
				   fittest = indiv;
			   }
		   }
		   return fittest;
	   }
	   
	   public void saveIndividual(int i, Individual individual) {
		   individuals[i] = individual;
	   }
	   
	   public double averageFitness() {
		   int absol = 0;
		   double averg = 0;
		   for (Individual i : individuals) {
			   absol += i.getFitness();
		   }
		   averg = absol / individuals.length;
		   return averg;
	   }
	   
	   public double fullPotency() {
		   double potenc = 0;
		   for (int i = 0; i < this.individuals.length; i++) {
			   potenc += Math.pow(this.individuals[i].getFitness(), 1 + 1/16);;
		   }
		   return potenc;
	   }
}
