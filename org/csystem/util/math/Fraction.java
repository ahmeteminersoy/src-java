/*----------------------------------------------------------------------
	FILE        : Fraction.java
	AUTHOR      : Java-Feb-2022 Group
	LAST UPDATE : 13.08.2022

	Immutable Fraction class that represents fraction in mathematics

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math;

public class Fraction {
    private final int m_a, m_b;

    public Fraction()
    {
        m_a = 0;
        m_b = 1;
    }

    public Fraction(int a)
    {
        m_a = a;
        m_b = 1;
    }

    public Fraction(int a, int b)
    {
        //TODO:
        m_a = a;
        m_b = b;
    }

    public int getNumerator()
    {
        return m_a;
    }

    public int getDenominator()
    {
        return m_b;
    }
    public double getRealValue()
    {
        return (double)m_a / m_b;
    }

    public static Fraction add(int value, Fraction fraction)
    {
        //TODO
        return new Fraction();
    }

    public Fraction add(Fraction other)
    {
        //TODO
        return new Fraction();
    }

    public Fraction add(int value)
    {
        //TODO
        return new Fraction();
    }

    public static Fraction subtract(int value, Fraction fraction)
    {
        //TODO
        return new Fraction();
    }

    public Fraction subtract(Fraction other)
    {
        //TODO
        return new Fraction();
    }

    public Fraction subtract(int value)
    {
        //TODO
        return new Fraction();
    }

    public static Fraction multiply(int value, Fraction fraction)
    {
        //TODO
        return new Fraction();
    }

    public Fraction multiply(Fraction other)
    {
        //TODO
        return new Fraction();
    }

    public Fraction multiply(int value)
    {
        //TODO
        return new Fraction();
    }

    public static Fraction divide(int value, Fraction fraction)
    {
        //TODO
        return new Fraction();
    }

    public Fraction divide(Fraction other)
    {
        //TODO
        return new Fraction();
    }

    public Fraction divide(int value)
    {
        //TODO
        return new Fraction();
    }


    public String toString()
    {
        return String.format("%d%s", m_a, m_b == 1 ? "" : " / " + m_b + " = " + getRealValue());
    }
}
