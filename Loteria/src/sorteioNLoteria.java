public class sorteioNLoteria {

	private int sorteio;
	
	public int numeroLoteria() {
		sorteio = (int) (Math.random()*61);
		return sorteio;
		
	}
}
