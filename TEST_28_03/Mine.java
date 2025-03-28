import java.util.concurrent.Semaphore;

class Mine {
    private int resources;
    private final Semaphore semaphore;

    public Mine(int resources, int maxMiners) {
        this.resources = resources;
        this.semaphore = new Semaphore(maxMiners);
    }

    public boolean dig(int amount) {
        try {
            semaphore.acquire();
            if (resources >= amount) {
                resources -= amount;
                return true;
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } finally {
            semaphore.release();
        }
    }

    public int getResources() {
        return resources;
    }
}