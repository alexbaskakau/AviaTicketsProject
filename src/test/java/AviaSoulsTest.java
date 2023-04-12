import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    @Test
    public void compareToTest() {
        Ticket ticket1 = new Ticket("London", "Moscow", 200, 20, 23);
        Ticket ticket2 = new Ticket("London", "Minsk", 270, 21, 22);
        Ticket ticket3 = new Ticket("London", "Vilnius", 250, 22, 24);
        Ticket ticket4 = new Ticket("London", "Warshaw", 220, 18, 20);
        Ticket ticket5 = new Ticket("London", "Riga", 289, 19, 22);
        int expected = -1;
        int actual = ticket1.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ticketTimeComparatorTest() {
        Ticket ticket1 = new Ticket("London", "Moscow", 200, 20, 23);
        Ticket ticket2 = new Ticket("London", "Minsk", 270, 21, 22);
        Ticket ticket3 = new Ticket("London", "Vilnius", 250, 22, 24);
        Ticket ticket4 = new Ticket("London", "Warshaw", 220, 18, 20);
        Ticket ticket5 = new Ticket("London", "Riga", 289, 19, 22);
        TicketTimeComparator service = new TicketTimeComparator();
        int expected = -1;
        int actual = service.compare(ticket3, ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchAviaSoulsSortByPriceTest() {
        Ticket ticket1 = new Ticket("London", "Minsk", 200, 20, 23);
        Ticket ticket2 = new Ticket("London", "Minsk", 270, 21, 22);
        Ticket ticket3 = new Ticket("London", "Minsk", 250, 22, 24);
        Ticket ticket4 = new Ticket("London", "Minsk", 220, 18, 20);
        Ticket ticket5 = new Ticket("London", "Minsk", 289, 19, 22);
        AviaSouls service = new AviaSouls();
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        Ticket[] expected = {ticket1, ticket4, ticket3, ticket2, ticket5};
        Ticket[] actual = service.search("London", "Minsk");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortTest() {
        Ticket ticket1 = new Ticket("London", "Minsk", 200, 20, 23);
        Ticket ticket2 = new Ticket("London", "Minsk", 270, 20, 24);
        Ticket ticket3 = new Ticket("London", "Minsk", 250, 21, 23);
        Ticket ticket4 = new Ticket("London", "Minsk", 220, 18, 23);
        Ticket ticket5 = new Ticket("London", "Minsk", 289, 18, 19);
        AviaSouls service = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        Ticket[] expected = {ticket5, ticket3, ticket1, ticket2, ticket4};
        Ticket[] actual = service.searchAndSortBy("london", "Minsk", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

}
