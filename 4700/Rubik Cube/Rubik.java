// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class Rubik extends JPanel{
  public static int TOP = 0;
  public static int BOTTOM = 1;
  public static int BACK = 4;
  public static int FRONT = 5;


  public static int UP = 0;
  public static int DOWN = 1;
  public static int LEFT = 2;
  public static int RIGHT = 3;

  private Face[] faces = new Face[6];
  private Color[] colorList = {Color.yellow, Color.blue, Color.green, Color.white, Color.orange, Color.red};
  private int width, height;
  private int current = 0;
  private int top = 4;

  // first dimension is top panel, second is front panel, third is neighbor on up/down/left/right
  // direction refers to direction in which current (front) panel moves

  private int[][][] neighbors = {
		{{-1,-1,-1,-1}, {2,0,4,5}, {-1,-1,-1,-1}, {2,0,5,4}, {2,0,3,1}, {2,0,1,3}},
		{{3,1,5,4}, {-1,-1,-1,-1}, {3,1,4,5}, {-1,-1,-1,-1}, {3,1,0,2}, {3,1,2,0}},
		{{-1,-1,-1,-1}, {0,2,5,4}, {-1,-1,-1,-1}, {0,2,4,5}, {0,2,1,3}, {0,2,3,1}},
		{{1,3,4,5}, {-1,-1,-1,-1}, {1,3,5,4}, {-1,-1,-1,-1}, {1,3,2,0}, {1,3,0,2}},
		{{5,4,1,3}, {5,4,2,0}, {5,4,3,1}, {5,4,0,2}, {-1,-1,-1,-1}, {-1,-1,-1,-1}},
		{{4,5,3,1}, {4,5,0,2}, {4,5,1,3}, {4,5,2,0}, {-1,-1,-1,-1}, {-1,-1,-1,-1}},
  };

  public Rubik(int w, int h){
    width = (w >=0 ? w : 300);
    Reset();
  }

  public void Reset(){
    for (int i=0; i<6; i++)
	faces[i] = new Face(i);
    current = 0;
    top = 4;
    repaint();
  }

  public void Turn(int direction){

      for (int i=0; i<3; i++){
	Twist(direction,i);
      }
      repaint();
  }

  public void Twist(int direction, int rowOrCol){

	int front_face = current;
	int top_face = top;
	int left_face = neighbors[top][current][RIGHT];
	int right_face = neighbors[top][current][LEFT];
	int bottom_face = neighbors[top][current][UP];
        int back_face = neighbors[current][bottom_face][UP];

	int face1, face2, face3, face4;

	/* Row Twist */
        if ( (direction == LEFT) || (direction == RIGHT)){
	int[] rowCopy = new int[3];
		/* determine involved faces */
		face1 = current;
		face2 = neighbors[top][face1][direction];
		face3 = neighbors[top][face2][direction];
		face4 = neighbors[top][face3][direction];

		/* copy face 1 */
		 rowCopy[0] = faces[face1].getValue(rowOrCol,0);
		 rowCopy[1] = faces[face1].getValue(rowOrCol,1);
		 rowCopy[2] = faces[face1].getValue(rowOrCol,2);


		/* twist */
		for (int j=0; j<3; j++)
			faces[face1].setValue(rowOrCol,j, faces[face2].getValue(rowOrCol,j));

		for (int j=0; j<3; j++)
			faces[face2].setValue(rowOrCol,j, faces[face3].getValue(rowOrCol,j));

		for (int j=0; j<3; j++)
			faces[face3].setValue(rowOrCol,j, faces[face4].getValue(rowOrCol,j));

		for (int j=0; j<3; j++)
			faces[face4].setValue(rowOrCol,j, rowCopy[j]);
      }


	/* Column Twist 	*/
      else if ( (direction == UP) || (direction == DOWN)){
	int[] colCopy = new int[3];

        int i,x,y;

	/* on twist-up:
		back <- reverse(top)
		bottom <- reverse(back)
		front <- bottom
		top  <- front
	*/

	if (direction == UP){
		/* copy front */
       		colCopy[0] = faces[front_face].getValue(0,rowOrCol);
		colCopy[1] = faces[front_face].getValue(1,rowOrCol);
		colCopy[2] = faces[front_face].getValue(2,rowOrCol);

		/* front <- bottom */
		for (i=0; i<3; i++)
		   faces[front_face].setValue(i,rowOrCol, faces[bottom_face].getValue(i,rowOrCol));
		/* bottom <- reverse(back) */
		y = Math.abs(2-rowOrCol);
		for (i=0; i<3; i++){
		   x = Math.abs(2-i);
		   faces[bottom_face].setValue(i,rowOrCol, faces[back_face].getValue(x,y));
		}

		/* back <- reverse(top) */
		y = Math.abs(2-rowOrCol);
		for (i=0; i<3; i++){
		   x = Math.abs(2-i);
		   faces[back_face].setValue(x,y, faces[top_face].getValue(i,rowOrCol));
		}

		/* top <- front */
		for (i=0; i<3; i++)
		   faces[top_face].setValue(i,rowOrCol, colCopy[i]);
	}

	/* on twist-down:
		top <- reverse(back)
		back  <- reverse(bottom)
		bottom <- front
		front <- top
	*/

	if (direction == DOWN){
		/* copy front */
		for (i=0; i<3; i++)
       		colCopy[i] = faces[front_face].getValue(i,rowOrCol);

		/* front <- top */
		for (i=0; i<3; i++)
		  faces[front_face].setValue(i,rowOrCol, faces[top].getValue(i,rowOrCol));

		/* top <- reverse(back) */
		y = Math.abs(2-rowOrCol);
		for (i=0; i<3; i++){
		   x = Math.abs(2-i);
		   faces[top].setValue(i,rowOrCol, faces[back_face].getValue(x,y));
		}

		/* back  <- reverse(bottom) */
		y = Math.abs(2-rowOrCol);
		for (i=0; i<3; i++){
		   x = Math.abs(2-i);
		   faces[back_face].setValue(x,y, faces[bottom_face].getValue(i,rowOrCol));
		}

		/* bottom <- front */
		for (i=0; i<3; i++)
		   faces[bottom_face].setValue(i,rowOrCol, colCopy[i]);

	}

     }

	/* if not middle row or column, twist the attached face */
	if (rowOrCol != 1){

	  /* row twist */
		/* top row */
		if ( (rowOrCol == 0) && (direction == RIGHT))
		faces[top].Rotate(Face.COUNTER);
		if ( (rowOrCol == 0) && (direction == LEFT))
		faces[top].Rotate(Face.CLOCK);

		/* bottom row */
		if ( (rowOrCol == 2) && (direction == RIGHT))
		faces[bottom_face].Rotate(Face.CLOCK);
		if ( (rowOrCol == 2) && (direction == LEFT))
		faces[bottom_face].Rotate(Face.COUNTER);

	  /* col twist */
		/* left col */
		if ( (rowOrCol == 0) && (direction == UP))
		faces[left_face].Rotate(Face.COUNTER);
		if ( (rowOrCol == 0) && (direction == DOWN))
		faces[left_face].Rotate(Face.CLOCK);

		/* right col */
		if ( (rowOrCol == 2) && (direction == UP)){
			faces[right_face].Rotate(Face.CLOCK);
                }
		if ( (rowOrCol == 2) && (direction == DOWN))
		faces[right_face].Rotate(Face.COUNTER);

	}

     repaint();
  }

  public void Scramble(){

  int dir, slice;

  for (int i=0; i< 1000; i++){
	dir = (int) (Math.random() * 4);
	slice = (int) (Math.random() * 3);
	Twist(dir,slice);
  }
  repaint();

  }

  protected void paintComponent(Graphics g){
	super.paintComponent(g);

	for (int i=0; i<3; i++){
	   for (int j=0; j<3; j++){
		g.setColor(getColor(faces[current].getValue(i,j)));
		g.fillRect(j*55,i*55,50,50);
	   }
        }
  }

 protected Color getColor(int index){
        return colorList[index];
  }

  protected Face getFace(int which){
        int front_face = current;
        int top_face = top;
        int left_face = neighbors[top][current][RIGHT];
        int right_face = neighbors[top][current][LEFT];
        int bottom_face = neighbors[top][current][UP];
        int back_face = neighbors[current][bottom_face][UP];

     if (which == FRONT)
        return faces[front_face];
     else if (which == TOP)
        return faces[top_face];
     else if (which == LEFT)
        return faces[left_face];
     else if (which == RIGHT)
        return faces[right_face];
     else if (which == BOTTOM)
        return faces[bottom_face];
     else /* (which == BACK) */
        return faces[back_face];

   }


}

