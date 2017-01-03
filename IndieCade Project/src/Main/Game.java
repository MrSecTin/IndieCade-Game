package Main;

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
import Map.TileList;
import Map.World;
import Player.Player;

public class Game extends BasicGameState
{
	Player player;
	World world;
	
	GUI gui;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
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
		player = (Player) Load.Load.load(ref + "/Player");

		MapList.init(player);
		
		world = (World) Load.Load.load(ref + "/World");
		System.out.println(player);
	}
	
	public void newGame()
	{	
		player = new Player(Config.WIDTH / 2, Config.HEIGHT / 2);
		
		MapList.init(player);
		
		world = new World(player);
	}
}
