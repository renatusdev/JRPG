package Game.World;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Game.Entities.EntityManager;
import Game.Entities.Dynamics.EnemyOne;
import Game.Entities.Statics.LightStatue;
import Game.Entities.Statics.SmokeHouse;
import Game.Entities.Statics.Tree;
import Main.GameSetUp;
import Main.Handler;
import Resources.Images;
import Resources.MusicHandler;
import Resources.MusicHandler.Circle;

public class WorldManager {

	protected Handler handler;
	private Circle circle;
	public EntityManager entityManager;

	ArrayList<Game.World.Walls> worldWalls;

	public WorldManager(Handler handler, EntityManager entityManager) {
		this.handler = handler;
		this.entityManager = entityManager;

		circle = handler.getGame().getMusicHandler().new Circle(5627,380, this.handler);
		this.entityManager.AddEntity(new Tree(handler, 600, 600));
		this.entityManager.AddEntity(new SmokeHouse(handler, 1153, 335));

		this.entityManager.AddEntity(handler.newEnemy(Images.PEnemyIdle,handler,500, 800,"MapState","Jovan","None","EnemyOne",100,25,0,1,8,12,20,10,20,10,1,5,"None","Fire",null,null)); // lvl 0 dificulty
		this.entityManager.AddEntity(handler.newEnemy(Images.PEnemyIdle,handler,1400, 600,"MapState","Jovan","None","EnemyOne",100,25,0,1,8,12,20,10,20,10,1,5,"None","Fire",null,null)); // lvl 0 dificulty
		this.entityManager.AddEntity(circle);

		AddWalls();

	}

	public void tick() {

        for (Walls w: this.worldWalls) {
            w.tick();
        }
        
	}

	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;


		
		  if(GameSetUp.DEBUGMODE){
	            for (Walls w: this.worldWalls) {
	            	
	            	if (w.getType().equals("Wall"))
	            		g2.setColor(Color.black);
	            	else
	            		g2.setColor(Color.PINK);
	            	
	                w.render(g2);
	            }
	        }
	}
	
	// adds all the walls in game
	private void AddWalls() {
		worldWalls = new ArrayList<>();
		
		//Bridge Walls
		worldWalls.add(new Walls(handler, 150, 120, 210, 360, "Wall"));
		worldWalls.add(new Walls(handler, 150, 600, 210, 495, "Wall"));
		worldWalls.add(new Walls(handler, 0, 450, 150, 200, "Wall"));
		
		//Walls of the Island
		///Left Bottom Border of the Island
		worldWalls.add(new Walls(handler, 360, 950, 480, 5, "Wall" ));
		worldWalls.add(new Walls(handler, 845, 950, 5, 250, "Wall"));
		///Bottom of the Island
		worldWalls.add(new Walls(handler, 850, 1200, 670, 5, "Wall"));
		///Bottom of the Island (right-ish)
		worldWalls.add(new Walls(handler, 1500, 830, 5, 370, "Wall"));
		worldWalls.add(new Walls(handler, 1500, 820, 500, 5, "Wall"));
		worldWalls.add(new Walls(handler, 2000, 440, 5, 390, "Wall"));
		///Right Side of the Island
		worldWalls.add(new Walls(handler, 2020, 440, 400, 5, "Wall"));
		worldWalls.add(new Walls(handler, 2400, 50, 5, 400, "Wall"));
		////Top right of the Island
		worldWalls.add(new Walls(handler, 2420, 40, 600, 5, "Wall"));
		worldWalls.add(new Walls(handler, 3000, -400, 5, 450, "Wall"));
		worldWalls.add(new Walls(handler, 1365, -380, 1650, 5, "Wall"));
		///Top of the Island
		//worldWalls.add(new Walls(handler, 1365, -380, 5, 250, "Wall"));
		worldWalls.add(new Walls(handler, 670, -130, 700, 5, "Wall"));
		///Top right of the Island
		worldWalls.add(new Walls(handler, 670, -130, 5, 250, "Wall"));
		worldWalls.add(new Walls(handler, 360, 120, 310, 5, "Wall"));
		///Right Mountains
		worldWalls.add(new Walls(handler, 1860, -320, 50, 50 , "Wall"));
		worldWalls.add(new Walls(handler, 1830, -270, 120, 50 , "Wall"));
		worldWalls.add(new Walls(handler, 1800, -220, 80, 70 , "Wall"));
		worldWalls.add(new Walls(handler, 1710, -150, 250, 250, "Wall"));
		worldWalls.add(new Walls(handler, 1600, 0, 60, 100, "Wall"));
		worldWalls.add(new Walls(handler, 1662, -60, 50, 80, "Wall"));
		worldWalls.add(new Walls(handler, 1950, -270, 200, 50, "Wall"));
		worldWalls.add(new Walls(handler, 1950, -300, 100, 50, "Wall"));
		
		worldWalls.add(new Walls(handler, 1980, -350, 50, 50, "Wall"));
		worldWalls.add(new Walls(handler, 1950, -250, 200, 100, "Wall"));	
		worldWalls.add(new Walls(handler, 1960, -150, 120, 100, "Wall"));
				
		worldWalls.add(new Walls(handler, 1662, 55, 50, 50, "Door Cave"));
		worldWalls.add(new Walls(handler, 5627,380, 20, 20, "Door S"));	
		
		///Left Mountains
		worldWalls.add(new Walls(handler, 700, 180, 140, 200, "Wall"));
		worldWalls.add(new Walls(handler, 620, 210, 80, 160, "Wall"));
		worldWalls.add(new Walls(handler, 840, 240, 120, 110, "Wall"));
		worldWalls.add(new Walls(handler, 580, 300, 40, 50, "Wall"));
	}
	
    public ArrayList<Walls> getWalls() {
        return worldWalls;
    }

}
