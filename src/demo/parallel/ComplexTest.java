package demo.parallel;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexTest {

    @Test
    public void testMinus() {
        Complex a = new Complex(5, 3);
        Complex b = new Complex(2, 1);
        a.minus(b);
        assertEquals(3.0, a.getRe(), 0.0001);
        assertEquals(2.0, a.getIm(), 0.0001);
    }

    @Test
    public void testMinusNegative() {
        Complex a = new Complex(2, 1);
        Complex b = new Complex(5, 3);
        a.minus(b);
        assertEquals(-3.0, a.getRe(), 0.0001);
        assertEquals(-2.0, a.getIm(), 0.0001);
    }

    @Test
    public void testMinusZero() {
        Complex a = new Complex(5, 3);
        Complex b = new Complex(0, 0);
        a.minus(b);
        assertEquals(5.0, a.getRe(), 0.0001);
        assertEquals(3.0, a.getIm(), 0.0001);
    }

    @Test
    public void testDivide() {
        Complex a = new Complex(4, 2);
        Complex b = new Complex(2, 0);
        a.divide(b);
        assertEquals(2.0, a.getRe(), 0.0001);
        assertEquals(1.0, a.getIm(), 0.0001);
    }

    @Test
    public void testDivideComplex() {
        Complex a = new Complex(3, 2);
        Complex b = new Complex(1, 1);
        a.divide(b);
        assertEquals(2.5, a.getRe(), 0.0001);
        assertEquals(-0.5, a.getIm(), 0.0001);
    }

    @Test
    public void testDivideByReal() {
        Complex a = new Complex(6, 9);
        Complex b = new Complex(3, 0);
        a.divide(b);
        assertEquals(2.0, a.getRe(), 0.0001);
        assertEquals(3.0, a.getIm(), 0.0001);
    }

    @Test
    public void testDivideByImaginary() {
        Complex a = new Complex(6, 9);
        Complex b = new Complex(0, 3);
        a.divide(b);
        assertEquals(3.0, a.getRe(), 0.0001);
        assertEquals(-2.0, a.getIm(), 0.0001);
    }

    @Test
    public void testConjugate() {
        Complex a = new Complex(3, 4);
        a.conjugate();
        assertEquals(3.0, a.getRe(), 0.0001);
        assertEquals(-4.0, a.getIm(), 0.0001);
    }

    @Test
    public void testConjugateZero() {
        Complex a = new Complex(0, 0);
        a.conjugate();
        assertEquals(0.0, a.getRe(), 0.0001);
        assertEquals(0.0, a.getIm(), 0.0001);
    }

    @Test
    public void testConjugateNegative() {
        Complex a = new Complex(-3, -4);
        a.conjugate();
        assertEquals(-3.0, a.getRe(), 0.0001);
        assertEquals(4.0, a.getIm(), 0.0001);
    }

    @Test
    public void testOperationsChain() {
        Complex result = new Complex(2, 3)
            .plus(new Complex(1, 1))
            .minus(new Complex(1, 2))
            .times(new Complex(2, 0));

        assertEquals(4.0, result.getRe(), 0.0001);
        assertEquals(4.0, result.getIm(), 0.0001);
    }

    @Test
    public void testComplexDivisionChain() {
        Complex result = new Complex(10, 5)
            .divide(new Complex(2, 1))
            .times(new Complex(3, 0));

        assertEquals(15.0, result.getRe(), 0.0001);
        assertEquals(0.0, result.getIm(), 0.0001);
    }

    @Test
    public void testNewFractalEquationFirstIteration() {
        Complex comp = new Complex(0.5, 0.5);
        Complex c = new Complex(0, 0);

        Complex temp = new Complex(c.getRe(), c.getIm());
        Complex numerator = temp.times(temp).times(temp).plus(temp.times(temp));
        Complex denominator = temp.plus(comp);
        Complex result = numerator.divide(denominator).plus(comp);

        assertEquals(0.5, result.getRe(), 0.0001);
        assertEquals(0.5, result.getIm(), 0.0001);
    }

    @Test
    public void testNewFractalEquationSecondIteration() {
        Complex comp = new Complex(0.5, 0.5);
        Complex c = new Complex(0.5, 0.5);

        Complex temp = new Complex(c.getRe(), c.getIm());
        Complex numerator = temp.times(temp).times(temp).plus(temp.times(temp));
        Complex denominator = temp.plus(comp);
        Complex result = numerator.divide(denominator).plus(comp);

        assertEquals(1.0, result.getRe(), 0.0001);
        assertEquals(1.0, result.getIm(), 0.0001);
    }

    @Test
    public void testOriginalOperationsPreserved() {
        Complex a = new Complex(2, 3);
        Complex b = new Complex(1, 1);

        a.plus(b);
        assertEquals(3.0, a.getRe(), 0.0001);
        assertEquals(4.0, a.getIm(), 0.0001);

        Complex c = new Complex(2, 3);
        c.times(b);
        assertEquals(-1.0, c.getRe(), 0.0001);
        assertEquals(5.0, c.getIm(), 0.0001);
    }
}