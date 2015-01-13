package org.jetstorm.stormFrame;

import java.awt.GridBagConstraints;

public class StormConstraints
{
	private int gx;
	private int gy;
	private int gw; 
	private int gh; 
	private int wx; 
	private int wy;
	private int fill; 
	private int alignment;
	public StormConstraints(final int xPos, final int yPos,	
			final int componentWidth, final int componentHeight, final int xWeight, final int yWeight,
			final int componentFill, final int componentAlignment)
	{
		gx = xPos;
		gy = yPos;
		gw = componentWidth; 
		gh = componentHeight; 
		wx = xWeight; 
		wy = yWeight;
		fill = componentFill; 
		alignment = componentAlignment;
	}
	public StormConstraints()
	{
		gx = 0;
		gy = 0;
		gw = 0; 
		gh = 0; 
		wx = 0; 
		wy = 0;
		fill = 0; 
		alignment = 0;
	}
	public int getAlignment()
	{
		switch (alignment % 9) {
		case 0:
			return GridBagConstraints.CENTER;
		case 1:
			return GridBagConstraints.NORTH;
		case 2:
			return GridBagConstraints.NORTHEAST;
		case 3:
			return GridBagConstraints.EAST;
		case 4:
			return GridBagConstraints.SOUTHEAST;
		case 5:
			return GridBagConstraints.SOUTH;
		case 6:
			return GridBagConstraints.SOUTHWEST;
		case 7:
			return GridBagConstraints.WEST;
		case 8:
			return GridBagConstraints.NORTHWEST;
		default:
			return GridBagConstraints.CENTER;
		}
	}
	public int getFill()
	{
		switch (fill % 4) {
		case 0:
			return GridBagConstraints.BOTH;
		case 1:
			return GridBagConstraints.NONE;
		case 2:
			return GridBagConstraints.HORIZONTAL;
		case 3:
			return GridBagConstraints.VERTICAL;
		default:
			return GridBagConstraints.BOTH;
		}
	}
	public int getWy()
	{
		return wy;
	}
	public int getWx()
	{
		return wx;
	}
	public int getGh()
	{
		return gh;
	}
	public int getGw()
	{
		return gw;
	}
	public int getGy()
	{
		return gy;
	}
	public int getGx()
	{
		return gx;
	}
}
