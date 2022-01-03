import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Image;
	import java.awt.Toolkit;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.geom.AffineTransform;
	import java.net.URL;
public class character {
		//add location attributes
		private int x, y; 
		private int speedX, speedY; 
		private Image img; 	
		private AffineTransform tx;
		private int yLimit;
		private int count; 
		private int speedFast;
		private int speedSlow; 

		public character() {
			img = getImage("/imgs/test.jpg"); //load the image for Tree
			x = (int)(Math.random()*600);
			y = 450; 
			speedY = -6; 
			yLimit = 40;
			count = 0;
			tx = AffineTransform.getTranslateInstance(x, y);
			speedFast = 6;
			speedSlow = 2;
			init(x, y); 				//initialize the location of the image
										//use your variables
			
		}
		public void setSpeed (int speedY) {
			this.speedY = speedY;
		}
		public int getY () {
			return y; 
		}
		public int getX () {
			return x; 
		}
		public void setFast (int speedFast) {
			this.speedFast = speedFast;
		}
		public void setSlow (int speedSlow) {
			this.speedSlow = speedSlow;
		}
		public void setY (int y) {
			this.y = y;
		}
		public int getFast() {
			return speedFast; 
		}
		public void setX (int x) {
			this.x = x;
		}
		

		
		public void changePicture(String newFileName) {
			img = getImage(newFileName);
			init(x, y);
		}
		
		public void paint(Graphics g) {
			//these are the 2 lines of code needed draw an image on the screen
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(img, tx, null);
			
			
			
			if (y <= yLimit) {
				speedY = speedSlow;
			}
			
			if (y <= yLimit+20 && speedY == -speedFast) {
				speedY = -speedSlow;
			}
			if (y <= yLimit+20 && speedY == -speedFast) {
				speedY = speedSlow;
			}
			if (y >= yLimit+20 && speedY == speedSlow ) {
				speedY = speedFast; 
			}
			if (y >= 550) {
				x = (int)(Math.random()*800);
				y = 450;
				speedY = -speedFast; 
				yLimit = (int)(Math.random()*150)+10;
			}
		
			y+=speedY;
			//call update to update the actual picture location
			update();
		}
			
			//update the picture variable location
		private void update() {
			tx.setToTranslation(x,y);
			tx.scale(.10, .10);
		}
		
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(.5, .5);
		}

		private Image getImage(String path) {
			Image tempImage = null;
			try {
				URL imageURL = character.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tempImage;
		}
	}
