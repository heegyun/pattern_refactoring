
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
		if (type == 0) { // ���� Dragon�̸�,
			if ( p.getEnergy() < 100 ) // 100���� ������ ���� 
				p.getInjured(30);	
		} else if ( type == 1) { // ���� Dracula��, 
			if ( p.getEnergy() < 80 ) // 80���� ������ ���� 
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
		return (energy > 0); // �������� 0���� ũ�� ��� �ִ� �� 
	}
	
	public int getEnergy() {
		return energy;
	}
}

