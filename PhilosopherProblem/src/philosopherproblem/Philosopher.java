/*
Take Home Quiz 1
Cloud Computing
Professor Philip Bradford
Semptember 6, 2020
 */
package philosopherproblem;

/**
 *
 * @author JasonChau
 */
public class Philosopher implements Runnable {
    private final Object leftFork;
    private final Object rightFork;
    
    public Philosopher(Object leftFork, Object rightFork){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }
    
    private void Status(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }
    
    @Override
    
    public void run() {
        try {
            while (true) {
                Status(": Thinking");
                synchronized (leftFork) {
                    Status(": Picked Up Left Fork");
                    synchronized (rightFork) {
                        Status(": Picked Up Right Fork");
                        Status(": Both Forks in Hand - Eating");
                        Status(": Put Down Right Fork");
                    }
                    Status(": Put Down Left Fork");
                    Status(": Both Forks are Down");
                }
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
