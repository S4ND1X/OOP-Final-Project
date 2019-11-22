import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {

	private Handler handler;
	
	private boolean uP, 
					dP, 
					lP, 
					rP;
	
	public KeyInput(Handler handler){
		this.handler = handler;
		this.uP = this.dP = this.lP = this.rP = false;
	}	
	//Obtiene el codigo ASCII de la tecla
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();	
		for(GameObject tempObject : this.handler.gameObjects) {		
			if(tempObject.getId() == ID.Player){
				switch(key) {
					case KeyEvent.VK_W:
						uP = true;
						tempObject.setVelY(-5);
						break;
					case KeyEvent.VK_S:
						dP = true;
						tempObject.setVelY(5);
						break;
					case KeyEvent.VK_D:
						rP = true;
						tempObject.setVelX(5);
						break;
					case KeyEvent.VK_A:
						lP = true;
						tempObject.setVelX(-5);
						break;
					case KeyEvent.VK_ESCAPE:
						System.exit(1);
						break;
				}
			}
		}
	}	
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		//Obtiene el valor ascci de la tecla soltada
		//Si el bojeto es un jugador, se dejara de mover
		for(GameObject tempObject : this.handler.gameObjects) {		
			if(tempObject.getId() == ID.Player) {
				switch(key) {
				
					case KeyEvent.VK_W:
						uP = false;
						if(dP) { tempObject.setVelY(5);}
						else {tempObject.setVelY(0);}
						break;
						
					case KeyEvent.VK_S: 
							dP = false;
							if(uP) {tempObject.setVelY(-5);}
							else {tempObject.setVelY(0);}
							break;
		
					case KeyEvent.VK_D:
						rP = false;
						if(lP) {tempObject.setVelX(-5);}
						else {tempObject.setVelX(0);}
						break;
						
					case KeyEvent.VK_A:
							lP = false;
							if(rP) {tempObject.setVelX(5);}
							else {tempObject.setVelX(0);}
							break;
				}		
			}
		}
	}


}
