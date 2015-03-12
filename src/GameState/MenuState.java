package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import Tilemap.Background;

public class MenuState extends GameState{
	
	private Background bg;
	private int currentOption;
	private String[] options = {"Start","Help","Quit"};
	private Font optionFont;

	private Color titleColor;
	private Font titleFont;
	
	public MenuState(GameStateManager man){
		this.gsm = man;
		try{
			bg = new Background("/Backgrounds/menubg.gif",1);
			bg.setVector(.1, 0);
			titleColor = new Color(128,0,0);
			titleFont = new Font("Century Gothic",Font.PLAIN,28);
			optionFont = new Font ("Arial",Font.PLAIN,12);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void init() {}
	public void update() {
		bg.update();
	}
	public void draw(Graphics2D g) {
		bg.draw(g);
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Vidya Game", 80, 70);
		g.setFont(optionFont);
		for(int i = 0; i<options.length;i++){
			if(i == currentOption){
				g.setColor(Color.WHITE);
			}else{
				g.setColor(Color.BLACK);
			}
			g.drawString(options[i], 145, 140 + i * 15);
		}
		
	} 
	
	public void select(){
		if(currentOption == 0){
			//start game
			gsm.setState(GameStateManager.LEVEL1STATE);
			
		}
		if(currentOption == 1){
			//display help
		}
		if(currentOption == 2){
			//quit game
			System.exit(0);
		}
	}
	public void keyPressed (int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_DOWN){
			currentOption++;
			if(currentOption >= options.length){
				currentOption = 0;
			}
		}
		if(k == KeyEvent.VK_UP){
			currentOption--;
			if(currentOption < 0){
				currentOption = options.length - 1;
			}
		}
	}
	public void keyReleased (int k) {}
	
	
}
