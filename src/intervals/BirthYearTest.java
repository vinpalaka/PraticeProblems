package intervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthYearTest {

    BirthYear birthYear = new BirthYear();
    @Test
    public void getYear() {
        int ar[][] = {{2011, 2090}, {1997, 2060}, {1980, 1998}, {2078, 2081},  {2080, 2083}} ;
        int max = birthYear.getYear(ar);
        assertEquals(2080, max);
        int ar2[][] = { {1980, 1998}, {2070, 2081}, {2078, 2081},  {2080, 2083}, {2060, 2079}} ;
        int max2 = birthYear.getYear(ar);
        assertEquals(2080, max2);
    }
}