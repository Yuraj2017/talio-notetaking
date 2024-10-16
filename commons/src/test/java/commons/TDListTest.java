package commons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TDListTest {
    private TDList list;
    private TDList list1;
    private TDList list2;
    private Card card1;

    @BeforeEach
    void setUp() {
        list = new TDList("todo");
        list1 = new TDList("doing");
        list2 = new TDList("todo");
        card1 = new Card("card1");
    }

    @Test
    public void testEmptyConstructor() {
        TDList list = new TDList();
        assertNotNull(list);
    }

    @Test
    public void testConstructor() {
        TDList list = new TDList("test list");
        assertEquals("test list", list.title);
    }

    @Test
    void testNotEqual() {
        assertNotEquals(list, list1);
    }

    @Test
    void testEqualsSameAddress() {
        assertEquals(list, list);
    }

    @Test
    void testDifferentClasses() {
        assertNotEquals(list, card1);
    }

    @Test
    void testEqualsNull() {
        assertNotEquals(list, null);
    }

    @Test
    void testEqualsSameName() {
        assertEquals(list, list2);
    }

    @Test
    void testHashSameAttributes() {
        assertEquals(list.hashCode(), list2.hashCode());
    }

    @Test
    void testToString() {
        list.addCard(card1);
        String toString = "TO DO List:\n" + "id: " +
                list.id + "\n" + "title: todo\n" +
                "Cards:\nCard{" +
                "id=" + card1.getId() +
                ", title='card1'}" ;
        assertEquals(toString, list.toString());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list1.isEmpty());
    }

    @Test
    void testNotEmpty() {
        list.addCard(card1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testAddCard() {
        list.addCard(card1);
        assertEquals(card1, list.cards.get(0));
    }
    @Test
    void testRemoveCardExists() {
        list.addCard(card1);
        list.removeCard(card1.getId());
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemoveCardNotExists() {
        list.addCard(card1);
        list.removeCard(2);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testGetTitle() {
        assertEquals(list.title, list.getTitle());
    }

    @Test
    public void testSetTitle() {
        list.setTitle("test card 3");
        assertEquals("test card 3", list.getTitle());
    }

    @Test
    public void testGetId() {
        assertEquals(list.id, list.getId());
    }

    @Test
    public void testSetBoard() {
        Board board = new Board("test board");
        list.setBoard(board);
        assertEquals(board, list.getBoard());
    }

    @Test
    public void testGetBoard() {
        Board board = new Board("test board");
        list.setBoard(board);
        assertEquals(board, list.getBoard());
    }
}
