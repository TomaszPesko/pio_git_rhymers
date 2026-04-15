package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int MAX_SIZE = 12;
    private static final int EMPTY_INDEX = -1;
    private static final int DEFAULT_VALUE = -1;

    //TODO: tablica o stalej wielkosci, mozliwe uzycie struktury dynamincznej
    private final int[] numbers = new int[MAX_SIZE];

    private int total = EMPTY_INDEX;

    public void countIn(int in) {
        //TODO: brak obslugi przepelnienia stosu, brak zawiadomienia ze stos jest pelny
        if (!isFull())
            numbers[++total] = in;
    }

    //TODO: rozwazyc usuniecie lub ograniczenie dostepu - narusza enkapsulacje
    public int getTotal() {
        return total;
    }
    //TODO: nazwa metody nie jest intuicyjna, moznaby zmienic na np. checkIfEmpty()
    public boolean callCheck() {
        return total == EMPTY_INDEX;
    }

    public boolean isFull() {
        return total == MAX_SIZE - 1;
    }

    protected int peekaboo() {
        if (callCheck())
            return DEFAULT_VALUE;
        return numbers[total];
    }

    //TODO: brak jawnej informacji o bledzie, zwracanie DEFAULT_VALUE moze ukrywac problem, zmiejsza czytelnosc
    //TODO: rozwazyc rzucanie wyjatku zamiast wartosci
    public int countOut() {
        if (callCheck())
            return DEFAULT_VALUE;
        return numbers[total--];
    }
}
