package commons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubtaskTest {

    private Subtask subtask;

    private Subtask subtask1;

    private Subtask subtask2;

    @BeforeEach
    public void setUp() {
        subtask = new Subtask("Hello");
        subtask1 = new Subtask("Hello");
        subtask2 = new Subtask("Bye");
    }

    @Test
    public void testEmptyConstructor() {
        Subtask subtask = new Subtask();
        assertNotNull(subtask);
    }

    @Test
    void getName() {
        assertEquals(subtask.getName(), "Hello");
    }

    @Test
    void setName() {
        subtask.setName("HelloWorld");
        assertEquals(subtask.getName(), "HelloWorld");
    }

    @Test
    void getChecked() {
        assertFalse(subtask.getChecked());
    }

    @Test
    void setChecked() {
        subtask.setChecked(true);
        assertTrue(subtask.getChecked());
    }

    @Test
    void testEqualsSameAddress() {
        assertEquals(subtask, subtask);
    }

    @Test
    void testEqualsDifferentAddress() {
        assertEquals(subtask, subtask1);
    }

    @Test
    void testEqualsNotEqual() {
        assertNotEquals(subtask, subtask2);
    }

    @Test
    void testHashCode() {
        assertEquals(subtask.hashCode(), subtask1.hashCode());
    }

    @Test
    void testHashCodeNotEqual() {
        assertNotEquals(subtask.hashCode(), subtask2.hashCode());
    }

    @Test
    void testToString() {
        String toString = "Subtask{name='Hello', checked=false}";
        assertEquals(subtask.toString(), toString);
    }


}
