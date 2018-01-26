/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testCollage2()
  {
    Picture canvas = new Picture("640x480.jpg");
    Picture can2 = new Picture ("seagull.jpg");
    canvas.copy2(can2, 232, 345, 327, 334, 145, 240);
    canvas.explore();
  }
  
  public static void testMyCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    Picture can2 = new Picture ("seagull.jpg");
    canvas.MyCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection2(30);
    swan.explore();
  }
  
  public static void testEdgeDetectionNew()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetectionNew(30);
    swan.explore();
  }
  
  public static void testKeepOnlyBlue(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
      beach.keepOnlyBlue();
      beach.explore();
  }
  
  public static void testNegate(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
      beach.negate();
      beach.explore();
  }
  
  public static void testGrayscale(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
      beach.grayscale();
      beach.explore();
  }
  
  public static void testFixUnderwater(){
	  Picture water = new Picture("water.jpg");
	  water.explore();
      water.underwater();
      water.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontal()
  {
    Picture redMotorcycle = new Picture("redMotorcycle.jpg");
    redMotorcycle.explore();
    redMotorcycle.mirrorHorizontal();
    redMotorcycle.explore();
  }
  
  public static void testMirrorHorizontalBotToTop()
  {
    Picture redMotorcycle = new Picture("redMotorcycle.jpg");
    redMotorcycle.explore();
    redMotorcycle.mirrorHorizontalBotToTop();
    redMotorcycle.explore();
  }
  
  public static void testMirrorDiagonal()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
      beach.mirrorDiagonal();
      beach.explore();
  }
  
  public static void testMirrorArms()
  {
	  Picture Snowman = new Picture("snowman.jpg");
	  Snowman.explore();
      Snowman.mirrorArms();
      Snowman.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
      gull.mirrorGull();
      gull.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorVerticalRightToLeft();
	//testMirrorHorizontal();
	//testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
	// testCollage();
    //testCollage2();
	//testMyCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
	//testEdgeDetectionNew();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}