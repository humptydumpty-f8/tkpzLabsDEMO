package var1.lab1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    Task1 task1;
    String[] originalArray =new String[]{"1", "2.0", "3", "0.", "-3.4", "-17", "0", "1e26", ".0", "-45"};

    @BeforeEach
    void setUp() {
        task1 = new Task1(originalArray);
    }

    @AfterEach
    void tearDown() {
        System.err.println("OK!");
    }

    @Test
    void printArray() {
     int expected = task1.printArray(originalArray);
     int actual=0;
     assertTrue(expected==actual);
    }

    @Test
    void originalArrayIsNumeric() {
        boolean expected = task1.originalArrayIsNumeric(originalArray);
        boolean actual = true;
        assertTrue(expected == actual);
    }

    @Test
    void getFinalArray() {
        boolean flag = true;
        String[] expected= task1.getFinalArray();
        String[] actual = new String[]{"-3.4","-17", "-45","0.","0",".0","1","2.0", "3","1e26"};

        for (int i = 0; i < expected.length; i++) {
            if (expected[i].equals(actual[i])) {
                continue;
            }else flag=false;
        }
        assertTrue(flag);
    }
}