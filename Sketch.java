import processing.core.PApplet;

public class Sketch extends PApplet {

  public void settings() {
	// put your size call here
    size(500, 500);
  }

  float[] snowY;
  float speed = 1;

  float[] snowPile;
  float snowHeight = height;

  int num = 25;
  float[] mousePositionX = new float[num];
  float[] mousePositionY = new float[num];
  int indexPosition = 0;

  public void setup() {
    snowY = new float[width / 2];
    snowPile = new float[width / 2];
    background(0);
    for(int i = 0; i < snowY.length; i++){
      snowY[i] = random(0, height);
    }
  }


  public void draw() {
    //snow 
    background(0);
    fill(255);

    for(int i = 0; i < snowY.length; i++){
      ellipse(i * 2, snowY[i], width / 80, height / 80);
      snowY[i] += speed;

      if(snowY[i] > height){
        snowY[i] = 0;
        snowPile[i] += (width / 80);
      }
    }

    // snow piling up

    
    for(int i = 0; i < snowPile.length; i++){
      rect(i * 2, height - snowPile[i], width / 80, height);
    }

    

    // mouse cursor thing

    noStroke();
    mousePositionX[indexPosition] = mouseX;
    mousePositionY[indexPosition] = mouseY;

    indexPosition = (indexPosition + 1) % num;
    for(int i = 0; i < num; i++){
      int pos = (indexPosition + i) % num;
      fill(255, 255, 255, 255 - i * 2);
      ellipse(mousePositionX[pos], mousePositionY[pos], i * (width / 200), i * (height / 200));
    }

  }
  
  public void keyPressed(){
    if(keyCode == UP){
      speed += 3;
    }
    else if (keyCode == DOWN && speed > 3){
      speed -= 3;
    }
  }
  // define other methods down here.
}