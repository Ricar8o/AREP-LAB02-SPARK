package edu.escuelaing.arep.app.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * Unit test for Calculator.
 * 
 * @author Andres Ricardo Martinez Diaz
 */
public class LinkedListTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LinkedListTest(String testName) {

        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(LinkedListTest.class);
    }

    /**
     * Prueba de add
     */
    public void testAdd() {
        LinkedList<Double> lista = new LinkedList<Double>();
        lista.add(6.2);
        lista.add(8.0);
        lista.add(-1.9);
        lista.add(99.05);
        assertEquals(4, lista.size());
        assertEquals(8.0, lista.get(1));
        assertEquals(99.05, lista.getLast());
    }

    /**
     * Prueba de remove 1
     */
    public void testRemove1() {
        LinkedList<Double> lista = new LinkedList<Double>();
        lista.add(6.2);
        lista.add(7.0);
        lista.add(-1.9);
        lista.add(95.05);
        assertEquals(-1.9, lista.get(2));
        lista.remove(2);
        assertEquals(95.05 ,lista.get(2));
        
    }
    /**
     * Prueba de remove 2
     */
    public void testRemove2() {
        LinkedList<Double> lista = new LinkedList<Double>();
        lista.add(6.2);
        lista.add(7.0);
        lista.add(-1.9);
        lista.add(95.05);
        assertEquals(4, lista.size());
        lista.remove(2);
        assertEquals(3, lista.size());
        
    }
    /**
     * Prueba de addFirst 
     */
    public void testAddFirst() {
        LinkedList<Double> lista = new LinkedList<Double>();
        lista.add(6.2);
        
        lista.add(7.0);
        lista.add(-1.9);
        assertEquals(6.2, lista.getFirst());
        lista.addFirst(95.05);
        assertEquals(95.05, lista.getFirst());
        assertEquals(6.2, lista.get(1));
        
    }

    /**
     * Prueba de RemoveFirst
     */
    public void testRemoveFirst() {
        LinkedList<Double> lista = new LinkedList<Double>();
        lista.add(6.2);
        lista.add(7.0);
        lista.add(-1.9);
        lista.add(95.05);

        assertEquals(6.2, lista.getFirst());

        lista.remove(0);
        assertEquals(7.0, lista.getFirst());
    }

    /**
     * Prueba de RemoveLast
     */
    public void testRemoveLast() {
        LinkedList<Double> lista = new LinkedList<Double>();
        lista.add(6.2);
        lista.add(7.0);
        lista.add(-1.9);
        lista.add(95.05);

        assertEquals(95.05, lista.getLast());

        lista.remove(3);
        assertEquals(-1.9, lista.getLast());
        
        lista.remove(2);
        assertEquals(7.0, lista.getLast());
    }
    
}