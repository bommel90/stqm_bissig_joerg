package ch.fhnw.swc.mrs.data;

import ch.fhnw.swc.mrs.model.Bill;
import ch.fhnw.swc.mrs.model.Rental;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ITBill {

    private List<Rental> rentals = new ArrayList<>(1);;
    Bill bill = new Bill("Otto","Meier",rentals);

    @Test
    Bill b = new Bill(bill.getFirstName(), bill.getLastName(), bill.getRentals());
    String s =  bill.print();

    String[] lines = s.split("\n");
    assertEquals(9, lines.length);
    assertEquals("Statement", lines[0]);
    assertEquals("=========", lines[1]);
    assertEquals("for: Otto Meier", lines[2]);
    assertEquals("", lines[3]);
    assertEquals("Days   Price  Title", lines[4]);
    assertEquals("-------------------", lines[5]);
    assertEquals("   1    8.40  Avatar", lines[6]);


}