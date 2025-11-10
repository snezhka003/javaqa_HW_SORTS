package ru.netology.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Moscow", "Mae", 8_900, 14548, 14552);
    Ticket ticket2 = new Ticket("Moscow", "Mae", 11_100, 62745, 62750);
    Ticket ticket3 = new Ticket("Moscow", "Mae", 11_100, 27960, 27963);
    Ticket ticket4 = new Ticket("Moscow", "Mae", 6_500, 12116, 12121);
    Ticket ticket5 = new Ticket("Moscow", "Mae", 32_750, 23912, 23924);
    Ticket ticket6 = new Ticket("Moscow", "Mae", 32_750, 16417, 16426);

    @Test
    public void shouldBeCompare() {
        int[] expected = { -1, 0, 1, -1, 1 };
        int[] actual = { ticket1.compareTo(ticket2), ticket2.compareTo(ticket3), ticket3.compareTo(ticket4), ticket4.compareTo(ticket5), ticket5.compareTo(ticket1) };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeSortByPrice() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);

        Ticket[] expected = { ticket4, ticket1, ticket2, ticket3, ticket5 };
        Ticket[] actual = tickets.search("Moscow", "Mae");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeSortByFlightTime() {
        AviaSouls tickets = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        Ticket[] expected = { ticket3, ticket1, ticket2, ticket4, ticket6, ticket5 };
        Ticket[] actual = tickets.searchAndSortBy("Moscow", "Mae", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
