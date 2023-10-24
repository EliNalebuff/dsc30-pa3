import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharQueueTest {
    CharQueue queue;
    @BeforeEach
    public void setUp() {
        queue = new CharQueue(10);
    }
    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(queue.size(), 0);
        queue.enqueue('1');
        queue.enqueue('2');
        queue.enqueue('3');
        queue.enqueue('4');

        assertEquals(queue.size(), 4);
        queue.dequeue();
        assertEquals(queue.size(), 3);
        assertEquals('2', queue.dequeue());
        assertEquals('3', queue.peek());
        assertEquals('3', queue.dequeue());
        assertEquals('4', queue.peek());
        assertEquals('4', queue.dequeue());
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            // code that is expected to throw the exception
            queue.dequeue();
        });



    }
    @Test
    public void test2() {
        queue.clear();
        assertTrue(queue.isEmpty());
        queue.enqueue('1');
        queue.enqueue('2');
        queue.enqueue('3');
        assertEquals(queue.peek(), '1');
        queue.dequeue();
        assertEquals(queue.peek(), '2');
        queue.dequeue();
        assertEquals(queue.peek(), '3');
        queue.dequeue();

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            // code that is expected to throw the exception
            queue.dequeue();
        });



    }







    }