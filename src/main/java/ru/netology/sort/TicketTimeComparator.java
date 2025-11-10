package ru.netology.sort;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int flightTimeFirst = t1.getTimeTo() - t1.getTimeFrom();
        int flightTimeSecond = t2.getTimeTo() - t2.getTimeFrom();

        if (flightTimeFirst < flightTimeSecond) {
            return -1;
        } else if (flightTimeFirst > flightTimeSecond) {
            return 1;
        } else {
            return 0;
        }
    }
}
