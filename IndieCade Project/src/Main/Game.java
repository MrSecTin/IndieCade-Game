package Main;

import java.io.Serializable;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import GUI.GUI;
import Map.MapList;
import Map.World;
import Player.Player;
import Tiles.TileList;

public class Game extends BasicGameState implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	Player player;
	World world;
	
	transient GUI gui;
	
	transient GameContainer gc;
	transient StateBasedGame sbg;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		this.gc = gc;
		this.sbg = sbg;
		
		TileList.init();
		
		gui = new GUI();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{	
		player.render(g);
		world.render(g);
		gui.render(g, player);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
	{
		player.update();
		
		world.update();
		
		gui.update(sbg, world, player);
	}

	@Override
	public int getID() 
	{
		return 2;
	}

	public void loadFiles(String ref)
	{
		player = (Player) Load.Load.load(ref + "/Player.ply");

		MapList.init(player);
		
		world = (World) Load.Load.load(ref + "/World.wrl");
	}
	
	public void newGame()
	{	
		player = new Player(this, Config.WIDTH / 2, Config.HEIGHT / 2);
		
		MapList.init(player);
		
		world = new World(player);
	}
	
	public GameContainer getGc()
	{
		return gc;
	}
	
	public StateBasedGame getSbg()
	{
		return sbg;
	}
}
