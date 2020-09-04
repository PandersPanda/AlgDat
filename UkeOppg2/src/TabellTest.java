import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabellTest {

    @Test
    void max() {

        int[] a = {4,5,6,1,2,3,9,8};

        int minimum = Tabell.max(a, 0, 4);

        assertEquals(2, minimum);
    }
}