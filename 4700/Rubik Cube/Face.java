// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class Face {
  private int side;
  private int[][] blocks = new int[3][3];
  public static int CLOCK = 0;
  public static int COUNTER = 1;

  public Face(int sideOfCube){
    side = sideOfCube;
    for (int i=0; i<3; i++){
    	for (int j=0; j<3; j++){
		blocks[i][j] = sideOfCube;
	}
    }
  }

  public int getValue(int i, int j){
	return blocks[i][j];
  }

  public void setValue(int i, int j, int colorNum){
	blocks[i][j] = colorNum;
  }

  public void Rotate(int direction){
  int [][] blocks_old = new int[3][3];
  int x, y;

  for (int i=0; i<3; i++){
	for (int j=0; j<3; j++){
	  blocks_old[i][j] = blocks[i][j];
	}
  }

  if (direction == CLOCK){
    for (int i=0; i<3; i++){
	for (int j=0; j<3; j++){
	   y = i;
	   x = Math.abs(2-j);
	   blocks[i][j] = blocks_old[x][y];
	}
    }

  }
  if (direction == COUNTER){
    for (int i=0; i<3; i++){
	for (int j=0; j<3; j++){
	   x = j;
	   y = Math.abs(2-i);
	   blocks[i][j] = blocks_old[x][y];
	}
    }
  }


  }
}

