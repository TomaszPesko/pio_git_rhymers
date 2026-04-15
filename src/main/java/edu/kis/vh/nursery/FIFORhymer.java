package edu.kis.vh.nursery;

/**
 * Implementacja kolejki FIFO (first in first out) na bazie stosu LIFO
 * Nadpisuje metode countOut by zwracac elementy w kolejnosci ich dodania
 */
public class FIFORhymer extends DefaultCountingOutRhymer {
    /**
     * Tymczasowy stos pomocniczy do odwracania kolejnosci elementow.
     */
    private final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Usuwa i zwraca element zgodnie z zasada FIFO.
     *
     * Mechanizm dzialania:
     * - wszystkie elementy sa przenoszone do stosu pomocniczego (odwrocenie kolejnosci)
     * - zdejmowany jest element, ktory byl dodany jako pierwszy
     * - pozostale elementy wracaja na oryginalny stos
     *
     * @return pierwszy dodany element lub -1 jesli struktura jest pusta
     */
    @Override
    public int countOut() {
        // Przeniesienie wszystkich elementow do stosu pomocniczego
        while (!callCheck())
            temp.countIn(super.countOut());

        // Pobranie najstarszego elementu (FIFO)
        int ret = temp.countOut();

        // Przywrocenie pozostalych elementow na oryginalny stos
        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
