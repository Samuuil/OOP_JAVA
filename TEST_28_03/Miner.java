class Miner implements Runnable {
    private static final int recourseCount = 10;
    private static final int restDigs = 3;
    private static final int restTime = 1000;

    private final Mine mine;
    private final String name;
    private int totalDug = 0;
    private int digs = 0;

    public Miner(Mine mine, String name) {
        this.mine = mine;
        this.name = name;
    }

    @Override
    public void run() {
        while (mine.getResources() > 0) {
            if (mine.dig(recourseCount)) {
                totalDug += recourseCount;
                digs++;
                System.out.println(name + " dug " + recourseCount + " resources. Total dug: " + totalDug);

                if (digs % restDigs == 0) {
                    rest();
                }
            } else {
                break;
            }
        }
        System.out.println(name + " finished digging. Total resources dug: " + totalDug);
    }

    private void rest() {
        try {
            System.out.println(name + " is resting.");
            Thread.sleep(restTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}