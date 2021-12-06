
public class TemplateMethodDemoGame {
	public static void main(String[] args) {
		
	}
}

class Monster {
	private int type; // 0: Dragon, 1: Dracula
		
	public Monster(int type) {
		this.type = type;
	}
	
	public void attack(Person p) {			
		if (type == 0) { // 만약 Dragon이면,
			if ( p.getEnergy() < 100 ) // 100보다 작으면 공격 
				p.getInjured(30);	
		} else if ( type == 1) { // 만약 Dracula면, 
			if ( p.getEnergy() < 80 ) // 80보다 작으면 공격 
				p.getInjured(10);	
		}											
	}		
}

class Person {
	private int energy;
	
	public Person() {
		this(100);
	}
	
	public Person(int energy) {
		this.energy = energy;
	}
	
	public void getInjured(int injuryLevel) {
		energy -= injuryLevel;
	}
	
	public boolean isAlive() {
		return (energy > 0); // 에너지가 0보다 크면 살아 있는 것 
	}
	
	public int getEnergy() {
		return energy;
	}
}

