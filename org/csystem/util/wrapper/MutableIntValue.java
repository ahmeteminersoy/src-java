/*----------------------------------------------------------------------
	FILE        : IntValue.java
	AUTHOR      : Java-Feb-2022 Group
	LAST UPDATE : 02.09.2022

	MutableImmutable IntValue class that wraps an int value

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.wrapper;

public final class MutableIntValue {
    private int m_value;

    public MutableIntValue()
    {
    }

    public MutableIntValue(int value)
    {
        m_value = value;
    }


    public int getValue()
    {
        return m_value;
    }

    public MutableIntValue setValue(int value)
    {
        m_value = value;

        return this;
    }

    public int compareTo(MutableIntValue other)
    {
        return m_value - other.m_value;
    }

    public MutableIntValue add(int value)
    {
        m_value += value;
        return this;
    }

    public MutableIntValue add(MutableIntValue value)
    {
        return add(value.m_value);
    }

    public MutableIntValue subtract(int value)
    {
        return add(-value);
    }

    public MutableIntValue subtract(MutableIntValue value)
    {
        return subtract(value.m_value);
    }

    public MutableIntValue multiply(int value)
    {
        m_value *= value;
        return this;
    }

    public MutableIntValue multiply(MutableIntValue value)
    {
        return multiply(value.m_value);
    }

    public MutableIntValue divide(int value)
    {
        m_value /= value;

        return this;
    }

    public MutableIntValue divide(MutableIntValue value)
    {
        return divide(value.m_value);
    }

    public MutableIntValue[] divideAndRemainder(int value)
    {
        MutableIntValue[] result = new MutableIntValue[2];
        result[0] = divide(value);
        result[1] = new MutableIntValue(m_value % value);

        return result;
    }

    public MutableIntValue[] divideAndRemainder(MutableIntValue value)
    {
        return divideAndRemainder(value.m_value);
    }

    public MutableIntValue mod(int value)
    {
        m_value %= value;

        return this;
    }

    public MutableIntValue mod(MutableIntValue value)
    {
        return mod(value.m_value);
    }

    public MutableIntValue inc()
    {
        return add(1);
    }

    public MutableIntValue dec()
    {
        return subtract(1);
    }

    public String toString()
    {
        return m_value + "";
    }
}
