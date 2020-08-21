package edu.escuelaing.arep.app.model;

import java.io.IOException;
import java.text.DecimalFormat;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Calculator.
 * @author Andres Ricardo Martinez Diaz
 */
public class CalculatorTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatorTest(String testName) {

        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CalculatorTest.class);
    }

    /**
     * Prueba de calculo de la media 1
     */
    public void testMean1() {
        Calculator calculator = new Calculator();
        calculator.cambiarRuta("data/datos1.txt");
        try {
            calculator.leerDatos();
            assertEquals(550.6, calculator.mean());
        } catch (IOException e) {
            assertTrue( false );
        }
       
    }

    /**
     * Prueba de calculo de la media 2
     */
    public void testMean2() {
        Calculator calculator = new Calculator();
        calculator.cambiarRuta("data/datos2.txt");
        try {
            calculator.leerDatos();
            DecimalFormat formato = new DecimalFormat("#.00");
            assertEquals(formato.format(60.32), formato.format(calculator.mean()));
        } catch (IOException e) {
            assertTrue( false );
        }
       
    }


    /**
     * Prueba de calculo de la desviacion estandar 1
     */
    public void testDeviation1() {
        Calculator calculator = new Calculator();
        calculator.cambiarRuta("data/datos1.txt");
        try {
            calculator.leerDatos();
            Double media = calculator.mean();
            DecimalFormat formato = new DecimalFormat("#.00");
            assertEquals(formato.format(572.03), formato.format(calculator.deviation(media)));
        } catch (IOException e) {
            assertTrue( false );
        }
       
    }

    /**
     * Prueba de calculo de la desviacion estandar 2
     */
    public void testDeviation2() {
        Calculator calculator = new Calculator();
        calculator.cambiarRuta("data/datos2.txt");
        try {
            calculator.leerDatos();
            Double media = calculator.mean();
            DecimalFormat formato = new DecimalFormat("#.00");
            assertEquals(formato.format(62.26), formato.format(calculator.deviation(media)));
        } catch (IOException e) {
            assertTrue( false );
        }
       
    }
}
