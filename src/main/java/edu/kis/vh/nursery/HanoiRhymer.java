package edu.kis.vh.nursery;

public class HanoiRhymer extends DefaultCountingOutRhymer {
    //TODO: Brak kontroli overflow, licznik moze wzrostac bez konca bez sprawdzenia
    private int totalRejected = 0;

    public int reportRejected() {
        return totalRejected;
    }
    @Override
    public void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }
}
