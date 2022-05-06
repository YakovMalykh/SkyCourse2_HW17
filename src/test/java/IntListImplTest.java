import Exceptions.IntOutOfBoundException;
import Exceptions.PassingNullToParameterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class IntListImplTest {

    private final IntListImpl out = new IntListImpl(0);

    @BeforeEach
    public void shouldFillList() {
        out.add(3);
        out.add(5);
    }

    @Test
    public void shouldAddNumderAndReturnThisNamber() {
        int result = out.add(2);
        assertEquals(2, result);
    }

    @Test
    public void shouldReturnSize() {
        int result = out.size();
        assertEquals(2, result);
    }

    @Test
    public void shouldReturnFalseIfListNotEmpty() {
        assertTrue(!out.isEmpty());
    }

    @Test
    public void shouldClearList() {
        assertTrue(!out.isEmpty());
        out.clear();
        assertTrue(out.isEmpty());
    }

    @Test
    public void shouldReturnElemntByIndex() {
        int result = out.get(1);
        assertEquals(5, result);
    }

    @Test
    public void shouldReturnSameArray() {
        int[] result1 = out.getArrayInt();
        int[] result2 = out.toArray();
        assertTrue(Arrays.equals(result1, result2));
    }

    @Test
    public void shouldReturnTrueWhenListsAreEquals() {
        IntListImpl otherList = new IntListImpl(2);
        otherList.add(3);
        otherList.add(5);
        assertTrue(out.equals(otherList));
    }

    @Test
    public void shouldReturnTrueIfListContainsElement() {
        assertTrue(out.contains(5));
        assertFalse(out.contains(7));
    }

    @Test
    public void shouldSetElementByIndex() {
        int result = out.set(1, 10);
        assertEquals(10, result);
    }

    @Test
    public void shouldReturnIndexOfElement() {
        int result = out.indexOf(3);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnIndexOfElementFromTheEnd() {
        int result = out.lastIndexOf(5);
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnRemovedElementAndReduceSizeOfList() {
        int result = out.remove(0);
        assertEquals(3, result);
        assertEquals(1, out.getSize());
    }

    @Test
    public void shouldThrowIntOutOfBoundExceptionWhenElementNotExist() {
        assertThrows(PassingNullToParameterException.class, () -> out.remove(3));
    }

    @Test
    public void shouldReturnRemovedElementByValue() {
        int result = out.removeValue(5);
        assertEquals(5, result);
    }

    @Test
    public void shouldReturnAddElementByIndex() {
        int resultElement = out.add(1, 4);
        assertEquals(4, resultElement);
        int resultIndex = out.indexOf(4);
        assertEquals(1, resultIndex);
    }

    @Test
    public void shouldReturnTrueWhenListContainsElement() {
        out.add(7);
        assertTrue(out.contains(5));
    }

}
