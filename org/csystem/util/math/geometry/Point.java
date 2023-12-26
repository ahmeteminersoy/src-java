/*----------------------------------------------------------------------
	FILE        : Point.java
	AUTHOR      : Java-Feb-2022 Group
	LAST UPDATE : 07.08.2022

	Immutable Point class that represents a 2(two) dimensional point in
	Cartesian plane

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

public class Point {
	private final int m_x;
	private final int m_y;
	
	public Point()
	{
		this(0);
	}
	
	public Point(int x)
	{
		this(x, 0);
	}
	
	public Point(int x, int y)
	{
		m_x = x;
		m_y = y;
	}

	public int getX()
	{
		return m_x;
	}

	public int getY()
	{
		return m_y;
	}


	public double distance()
	{
		return distance(0, 0);		
	}
	
	public double distance(Point other)
	{
		return distance(other.m_x, other.m_y);
	}
	
	public double distance(int x, int y)
	{
		return PointCommonUtil.distance(m_x, m_y, x, y);
	}

	public Point offset(int dxy)
	{
		return offset(dxy, dxy);
	}

	public Point offset(int dx, int dy)
	{
		return new Point(m_x + dx, m_y + dy);
	}

	public MutablePoint toMutablePoint()
	{
		return new MutablePoint(m_x, m_y);
	}

	public String toString()
	{
		return PointCommonUtil.toString(m_x, m_y);
	}
}

