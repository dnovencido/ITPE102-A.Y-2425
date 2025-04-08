class Animal extends Thread {
	private int pause;
	private static final int TIMES = 10;
	private static String winner;

	public Animal(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			for (int i=0; i<TIMES; i++) {
				System.out.println(getName());
				addWinner(getName());
				pause = (int) (Math.random() * 3000); // 0.25 * 3000 → 750 ms (0.75 sec)
				sleep(pause);
			}
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	private static synchronized void addWinner(String name) {
       	winner = name;
    }

    public static void displayWinner() {
    	System.out.print("\n Winner:");
        System.out.println("\n🏆 "+ winner +" 🏆");
    }
}

public class AnimalRace {
	public static void main(String[] args) {
    	// Create and start threads
    	Animal animal1 = new Animal("🐵");
    	Animal animal2 = new Animal("🐻");
    	Animal animal3 = new Animal("🐹");
		Animal animal4 = new Animal("🐼");

    	animal1.start();
    	animal2.start();
    	animal3.start();
    	animal4.start();

    	// Wait for all threads to finish
        try {
            animal1.join();
            animal2.join();
            animal3.join();
            animal4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    	Animal.displayWinner();
	}
}