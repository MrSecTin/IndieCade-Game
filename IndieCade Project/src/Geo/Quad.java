package Geo;

import java.io.Serializable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Quad implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6083904781356000620L;
	public float width, height, x, y;

	public Quad(float x, float y, float width, float height) {
		this.x = x - width / 2;
		this.y = y - height / 2;
		this.width = width;
		this.height = height;
	}

	public boolean checkPoint(float x, float y) {
		if (x >= this.x)
			if (y >= this.y)
				if (x <= this.x + this.width)
					if (y <= this.y + this.height)
						return true;
		return false;
	}
	
	public boolean checkQuad(Quad quad)
	{
		boolean intersect = false;
		
		for(float x = quad.x ; x < quad.x + quad.width; x ++)
		{
			for(float y = quad.y ; y < quad.y + quad.height; y ++)
			{
				if(checkPoint(x,y))
				{
					intersect = true;
					break;
				}
			}
			
			if(intersect)
			{
				break;
			}
		}
		
		return intersect;
	}
	
	public boolean checkWithin(Quad quad)
	{
		boolean contained = true;
		
		for(float x = quad.x ; x < quad.x + quad.width; x ++)
		{
			for(float y = quad.y - quad.height; y < quad.y + quad.height; y ++)
			{
				if(!checkPoint(x,y))
				{
					contained = false;
					break;
				}
			}
			
			if(!contained)
			{
				break;
			}
		}
		
		return contained;
	}
	
	public void changeDimensions(float x, float y, float width, float height)
	{
		this.x = x- width / 2;
		this.y = y - height / 2;
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics g) throws SlickException
	{
		g.drawRect(x, y, width, height);
	}
}
