import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor()); 
        
        count++;
      }
    } 
    System.out.println("# of times Looped: "  + count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

	  public void copy2(Picture fromPic, 
	          int startRow, int startCol,int endRow, int endCol, int toStartcol, int tostartrow)
	{
	Pixel fromPixel = null;
	Pixel toPixel = null;
	Pixel[][] toPixels = this.getPixels2D();
	Pixel[][] fromPixels = fromPic.getPixels2D();
	for (int fromRow = tostartrow, toRow = startRow; 
	  fromRow < endRow &&
	  toRow < toPixels.length; 
	  fromRow++, toRow++)
	{
	for (int fromCol = toStartcol, toCol = startCol; 
	    fromCol < endCol &&
	    toCol < toPixels[0].length;  
	    fromCol++, toCol++)
	{
	 fromPixel = fromPixels[fromRow][fromCol];
	 toPixel = toPixels[toRow][toCol];
	 toPixel.setColor(fromPixel.getColor());
	}
	}   
	}
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void MyCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture swan = new Picture("swan.jpg");
    Picture robot = new Picture("robot.jpg");
    this.copy(flower1,0,0);
    this.copy(robot,100,0);
    this.copy(swan,200,0);
    Picture flowerNoBlue = new Picture(swan);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(swan,500,0);
    this.mirrorVertical();
    this.grayscale();
    this.copy(robot, 150, 50);
    this.write("collage.jpg");
  }

  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetection2(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row + 1][col];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) < 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetectionNew(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {   
    	  
    	rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        leftPixel = pixels[row][col];
     
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length; col++)
      {
    	 
         rightPixel = pixels[row + 1][col];
        rightColor = rightPixel.getColor();
        leftPixel = pixels[row][col];
       
        if (leftPixel.colorDistance(rightColor) < 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  public void keepOnlyBlue(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels){
		  for(Pixel pixelObj : rowArray){
			  pixelObj.setGreen(0);
			  pixelObj.setRed(0);
		  }
	  }
  }
  public void negate(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels){
		  for(Pixel pixelObj : rowArray){
			  pixelObj.setGreen(pixelObj.getGreen() - 255);
			  pixelObj.setRed(pixelObj.getRed() - 255);
			  pixelObj.setBlue(pixelObj.getBlue() - 255);
		  }
	  }
  }

  public void grayscale(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels){
		  for(Pixel pixelObj : rowArray){
			  int avg = (pixelObj.getBlue()+ 
					  pixelObj.getGreen() + pixelObj.getRed())/ 3;
			  
			  pixelObj.setBlue(avg);
			  pixelObj.setGreen(avg);
			  pixelObj.setRed(avg);
		  }
	  }
	  
  }
  
  public void underwater(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels){
		  for(Pixel pixelObj : rowArray){  
			  if(pixelObj.getBlue() >= 155 && pixelObj.getBlue() <= 195 && 
			     pixelObj.getRed() >= 10 && pixelObj.getBlue() <= 25 &&
				 pixelObj.getGreen() > 148 && pixelObj.getGreen() < 175){
				 pixelObj.setRed(pixelObj.getRed()+ 30); 
				 pixelObj.setBlue(pixelObj.getBlue()+ 30);
				 pixelObj.setGreen(pixelObj.getGreen()+ 30);
			  }
		  }
	  }
	 
  }
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = pixels[0].length - 1; col > width / 2; col--)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }  
  
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[(pixels.length - 1) - row][col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  } 
  
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = pixels.length - 1; row > pixels.length / 2; row--)
    {
      for (int col = 0; col < width; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[(pixels.length - 1) - row][col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  } 
  
  public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int num = 0; 
    if(pixels[0].length > pixels.length){
    	num = pixels.length;
    } 
    else{
    	num = pixels[0].length;
    }
    for (int row = 0; row < num; row++)
    {
      for (int col = 0; col < row; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[col][row];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorArms(){
	  Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int arms = 194;
      for (int row = 156; row < arms; row++)
      {
    	  for (int col = 105; col < 170 ; col++)
    	  {
    		  leftPixel = pixels[row][col];
    		  rightPixel = pixels[arms - row + arms][col];
    		  rightPixel.setColor(leftPixel.getColor());
    	  }
      }
      for (int row = 176; row < arms; row++)
      {
    	  for (int col = 238; col < 300 ; col++)
    	  {
    		  leftPixel = pixels[row][col];
    		  rightPixel = pixels[arms - row + arms][col];
    		  rightPixel.setColor(leftPixel.getColor());
    	  }
      }
  }
  
  public void mirrorGull(){
	  Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int gull = 345;
      for (int row = 230; row < gull; row++)
      {
    	  for (int col = 230; col < 355 ; col++)
    	  {
    		  leftPixel = pixels[row][col];
    		  rightPixel = pixels[row][gull - col + gull];
    		  rightPixel.setColor(leftPixel.getColor());
    	  }
      }
  }
 
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
    Picture temple = new Picture("temple.jpg");
    temple.mirrorTemple();
  } 
} // this } is the end of class Picture, put all new methods before this
