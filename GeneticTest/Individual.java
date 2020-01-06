package me.PythiusMalum.GeneticTest;

public class Individual {
	private byte[] genes = new byte[64];
	
	public void generateIndividual() {
		for (int i = 0; i < genes.length; i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
	}
	
	public byte getGene(int num) {
		return genes[num];
	}
	
	public void setGene(int num, byte byteNum) {
		genes[num] = byteNum;
	}
	
	public int genomSize() {
		return 64;
	}
	
	public int getFitness() {
		return Fitness.getFitness(this);
	}

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < genomSize(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
}
