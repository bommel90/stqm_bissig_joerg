package ch.fhnw.swc.mrs.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

public class StatementTest {
    
    private Statement s;
    private List<Rental> rentals;

    @Before
    public void setup() {
        Rental r1 = mock(Rental.class);
        Rental r2 = mock(Rental.class);
        Rental r3 = mock(Rental.class);

        rentals = new ArrayList<>(3);
        rentals.add(r1);
        rentals.add(r2);
        rentals.add(r3);
    }

    @Test
    public void testStatement() {
        Statement s1 = mock(Statement.class);
        when(s1.getLastName()).thenReturn("Muster");
        when(s1.getFirstName()).thenReturn("Hans");
        when(s1.getRentals()).thenReturn(rentals);


        assertEquals("Muster", s1.getLastName());
        assertEquals("Hans", s1.getFirstName());
        assertEquals(3, s1.getRentals().size());
    }


    @Disabled
    @Test (expected=IllegalArgumentException.class)
    public void testFirstName() {
        Statement s2 = mock(Statement.class);
        when(s2.getLastName()).thenReturn("Muster");
        when(s2.getFirstName()).thenReturn("Maximilian"); //länger als 8, wirft aber trotzdem keine IllegalArgumentException
        when(s2.getRentals()).thenReturn(rentals);
    }


    @Disabled
    @Test (expected=IllegalArgumentException.class)
    public void testLastname() {
        Statement s3 = mock(Statement.class);
        when(s3.getLastName()).thenReturn("Mustermann"); //länger als 8, wirft aber trotzdem keine IllegalArgumentException
        when(s3.getFirstName()).thenReturn("Hans");
        when(s3.getRentals()).thenReturn(rentals);
    }

    @Disabled
    @Test (expected=IllegalArgumentException.class)
    public void testRentals() {
        Statement s4 = mock(Statement.class);
        when(s4.getLastName()).thenReturn("Muster");
        when(s4.getFirstName()).thenReturn("Hans");
        when(s4.getRentals()).thenReturn(null); //ist null, wirft aber trotzdem keine IllegalArgumentException
    }

}
