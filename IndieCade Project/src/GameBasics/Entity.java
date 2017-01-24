package GameBasics;

import java.io.Serializable;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import java.util.ArrayList;
import BoneStructure.BoneStructure;
import Geo.Quad;
import Main.Config;
import Map.Map;
import Render.AnimationSet;
import Render.BasicImage;
import Tiles.Tile;

public abstract class Entity implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1335939607570570293L;
	
	boolean paused;
	
	//Horizontal movement
	float x;
	float Vx;
	float Vy;
	float Ax;
	float Ay;
	float acceleration;
	
	//Vertical movement
	float y;
	float jumpV;
	int jump;
	int maxJump;
	long jumpTick;
	boolean jumping;
	
	//Combat statistics
	BoneStructure body;
	float maxHealth;
	float health;
	float damage;
	float defense;
	float speed;
	float tenacity;
	ArrayList<Magic> Magic = new <Magic>();
	
	//Combat values
	float Stun;
	float Speed;
	
	//World
	Map map;
	
	//Renders
	float width;
	float height;
	public Quad Hitbox;
	Quad Screen;
	Level level;
	AnimationSet BaseModel;
	int tickCount;
	long lastTick;
	
	//Random Generator
	Random gen = new Random();
	
	public Entity(float x, float y, float speed)
	{
		
		paused = false;
		
		this.x = x;
		this.y = y;
		jumpV = -10F;
		jump = 0;
		maxJump = 2;
		jumpTick = System.currentTimeMillis();
		jumping = false;
		
		Vx = 0;
		Vy = 0;
		
		Ax = 0;
		Ay = 0.5F;
		acceleration = 0.5F;
		
		width = 64;
		height = 64;
		
		Hitbox = new Quad(x, y, width, height);
		Screen = new Quad(x, y, Config.WIDTH, Config.HEIGHT);
		
		maxHealth = 100;
		health = maxHealth;
		defense = 5;
		damage = 5;
		tenacity = 0;
		this.speed = 5;
	}
	
	public void AI(){
	
	}
	
	//Combat Stuff
	//MoveSet? Will this be in here? Is ArrayList the proper thing here?
	public Entity setMagic(Magic Magic){
		Magic.add(Magic);
		return this;
	}
	
	//Setting Stats
	public Entity setMaxJump(float maxJump){
		this.maxJump = maxJump;
		return this;
	)
	
	public Entity setBaseSpeed(float speed){
		this.speed = speed;
		return this;
	)
	
	public Entity setDamage(float damage)
	{
		this.damage = damage;
		return this;
	)
	
	public Entity setTenacity(float tenacity)
	{
		this.tenacity = tenacity;
		return this;
	)
	
	public Entitiy setMaxHealth(float maxHealth)
	{
		this.maxHealth = maxHealth;
		return this;
	}
	
	public Entitiy setDefense(float defense)
	{
		this.defense = defense;
		return this;
	}
	//End of Setting Stats
	
	/*	ASK ABOUT THIS AS WELL
	public boolean distanceSense(float distance, BasicPlayer protag)
	{
		double space = Math.sqrt(Math.pow(x - 
				protag.getX(), 2) + Math.pow(y - protag.getY(), 2));
		
		if(space <= distance)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	*/
	
	public Entity move(float xa, float ya)
	{
		if(movable)
		{
			x += xa * speed;
			y += ya * speed;
		}
		
		if(BaseModel.afterImage)
		{
			BaseModel.moveAfterImage(-xa * speed, -ya * speed);
		}
		return this;
	}
	
	public Entity Move(float xa, float ya)
	{
		x += xa;
		y += ya;
		
		if(BaseModel.afterImage)
		{
			BaseModel.moveAfterImage(xa, ya );
		}
	}
	
	public Entity setMovable(boolean movable)
	{
		this.movable = movable;
		return this;
	}
	
	
	public Entity follow(BasicPlayer protag)
	{
		float distX = protag.getX() - x;
		float distY = protag.getY() - y;
		
		if(distY != 0)
		{
			try
			{
				move(0, (distY) / (Math.abs(distY))); // 
			}
			catch(Exception e)
			{
				move(0, 0);
			}
		}else
		{
			move(0,0);
		}
		
		if(distX != 0)
		{
			try
			{
				move((distX) / (Math.abs(distX)) ,0); //
			}
			catch(Exception e)
			{
				move(0, 0);
			}
		}else
		{
			move(0,0);
		}
		return this;
	}
	
	public Entity setAnimation(String ref, long delay)
	{
		BaseModel = new AnimationSet(ref, delay);
		return this;
	}
	
	//Ask Hummus about Carter Method here
	public Entity setMap(Map map)
	{
		this.map = map;
		return this;
	}
	
	public void Physics()
	{
		Vx += Ax;
		
		boolean CollisionX = false;
		boolean CollisionY = false;
		
		for(Tile T : map.getTiles())
		{
			if(T.getCollidable() && T.getHitbox().checkQuad(new Quad(x + Vx + Ax, y, width, height)))
			{
				CollisionX = true;
				T.nextTo = true;
			}else
			{
				T.nextTo = false;
			}
			
			if(T.getCollidable() && T.getHitbox().checkQuad(new Quad(x, y + Vy + Ay, width, height)))
			{
				CollisionY = true;
				T.on = true;
			}else
			{
				T.on = false;
			}
		}
		
		if(CollisionX)
		{
			Vx = 0;
		}
		
		if(CollisionY)
		{
			jumping = false;
			if(jump < maxJump && Vy > 0)
			{
				jump ++;
			}
			Vy = 0;
		}else
		{
			Vy += Ay;
			if(!jumping)
			{
				jump = 0;
			}
		}
		
	}
	
	
	public void update()
	{
		if(!paused)
		{
			Physics();
			
			if(Math.abs(Vx) < map.getCurrentTile(x, y + 50).getFriction())
			{
				Vx = 0;
			}
			
			if(health <= 0)
			{
				die();
			}
		}
		
		map.shift(-Vx, 0);
		map.shift(0, -Vy);
		
		Hitbox.changeDimensions(x, y, width, height);
		Screen.changeDimensions(x, y, Config.WIDTH, Config.HEIGHT);
	}
	
	public void render(Graphics g) throws SlickException
	{
		Hitbox.render(g);
		Screen.render(g);
	}
	
	public void jump()
	{
		Vy = jumpV;
		jump --;
		jumping = true;
		
		jumpTick = System.currentTimeMillis();
	}
	
	public void pause()
	{
		paused = true;
	}
	
	public void unpause()
	{
		paused = false;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public float getVx()
	{
		return Vx;
	}
	
	public float getVy()
	{
		return Vy;
	}
	
	public Map getMap()
	{
		return map;
	}
	
	public BoneStructure getBody()
	{
		return body;
	}
	
	//...
	public void damage(int damage)
	{
		health -= damage;
	}
	
	public void die()
	{
		for(int i = 0; i < level.getEntities().size(); i ++)
		{
			if(level.getEntities().get(i) == this)
			{
				level.getEntities().remove(i);
			}
		}
		
	}
	public Quad getHitbox() 
	{
		return Hitbox;
	}
	
	public void init()
	{
		
	}
	
}
