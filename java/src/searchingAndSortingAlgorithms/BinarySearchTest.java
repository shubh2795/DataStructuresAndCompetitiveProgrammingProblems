package searchingAndSortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @org.junit.jupiter.api.Test
    void binarySearchIterative() {
        assertEquals(-1, BinarySearch.binarySearchIterative(new int[]{}, 1));
        assertEquals(-1, BinarySearch.binarySearchIterative(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 9));
        assertEquals(-1, BinarySearch.binarySearchIterative(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18},
                9));
        assertEquals(0, BinarySearch.binarySearchIterative(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 0));
        assertEquals(-1, BinarySearch.binarySearchIterative(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 5));
        assertEquals(4, BinarySearch.binarySearchIterative(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 8));
        assertEquals(8, BinarySearch.binarySearchIterative(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 16));

    }

    @org.junit.jupiter.api.Test
    void binarySearchRecursive() {
        assertEquals(-1, BinarySearch.binarySearchRecursive(new int[]{}, 0, 0, 1));
        assertEquals(-1, BinarySearch.binarySearchRecursive(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 0, 9, 9));
        assertEquals(-1, BinarySearch.binarySearchRecursive(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18},
                0, 9, 9));
        assertEquals(0, BinarySearch.binarySearchRecursive(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 0, 9, 0));
        assertEquals(-1, BinarySearch.binarySearchRecursive(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 0, 9, 5));
        assertEquals(4, BinarySearch.binarySearchRecursive(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 0, 9, 8));
        assertEquals(8, BinarySearch.binarySearchRecursive(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16}, 0, 9, 16));
    }
}