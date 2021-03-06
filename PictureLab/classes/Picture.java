import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.Random;
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
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVerticalRightToLeft()
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
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture around a 
    * Horixontal mirror in the center of the picture
    * from top to bottom */
  public void mirrorHorizontal()
  { Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels.length;
    int height = pixels[0].length;
    
    for (int row = 0; row < width; row++)
    {
      for (int col = 0; col < height; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[width-1-row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
    }
  
  /** Method that mirrors the picture around a 
    * Horizontal mirror in the center of the picture
    * from bottom to top */
    public void mirrorHorizontalBottomToTop()
  { Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels.length;
    int height = pixels[0].length;
    
    for (int row = 0; row < width; row++)
    {
      for (int col = 0; col < height; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[width-1-row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
    }
    
   /** Method that mirrors the picture around a 
    * diagonal mirror in the center of the picture
   */
    public void mirrorDiagonal()
  { Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel flipPixel = null;
    int width = pixels.length;
    int height = pixels[0].length;
    int use=0;
    if (width >height)
    {
        use= height;
    }
    else
    {
        use= width;
    }
    
    for (int row = 0; row < use; row++)
    {
      for (int col = 0; col < use; col++)
      {
        topPixel = pixels[row][col];
        flipPixel = pixels[col][row];
        flipPixel.setColor(topPixel.getColor());
      }
    } 
    }
  //** Mirror just part of a picture of a temple *
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
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        System.out.println(""+count);
      }
    }
  }
  
  public void mirrorArms()
  {
    Pixel[][] pixels = this.getPixels2D();
    int mirrorPoint = 200;
    Pixel leftPixel = null;
    Pixel leftPixel2 = null;
    Pixel rightPixel = null;
    Pixel rightPixel2 = null;
        for (int row = 155; row < 200; row++)
    {
     
      for (int col = 100; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      
        rightPixel2 = pixels[row+50]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel2.setColor(leftPixel.getColor());
        leftPixel2 = pixels[row+50][col];
        leftPixel2.setColor(rightPixel.getColor());
       
      }
    }
      
  }
  
  public void addLines()
  {
   Pixel[][] pixels = this.getPixels2D();
   Pixel rowPixels= null;
   int size= 5;
   int width= pixels.length;
   int height= pixels[0].length;
   for (int row = 0; row < width; row++)
    {
      for (int col = 0; col < height; col++)
      {
          if (row%size == 0)
          {
              rowPixels= pixels[row][col];
              Color chosenColor = new Color(0,0,0);
              rowPixels.setColor(chosenColor);
            }

      }
    }
    
  }

   /** Method that mirrors the picture around a 
    * diagonal mirror in the center of the picture
   */
    public void mirrorDiagonalAndColor()
  { Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel flipPixel = null;
    int width = pixels.length;
    int height = pixels[0].length;
    int use=0;
    if (width >height)
    {
        use= height;
    }
    else
    {
        use= width;
    }
    
    for (int row = 0; row < use; row++)
    {
      for (int col = 0; col < use; col++)
      {
        topPixel = pixels[row][col];
        flipPixel = pixels[col][row];
        int r=topPixel.getRed()/2;
        int g=topPixel.getGreen()/2;
        int b=topPixel.getBlue()/2;
        Color diff= new Color(r,g,b);
        flipPixel.setColor(diff);
      }
    } 
    }
  public void eliminateWhite()
  {
   Pixel[][] pixels = this.getPixels2D();
   Pixel onePixels= null;
   int width= pixels.length;
   int height= pixels[0].length;
   for (int row = 0; row < width; row++)
    {
      for (int col = 0; col < height; col++)
      {
          onePixels= pixels[row][col];
          int r=onePixels.getRed();
          int g=onePixels.getGreen();
          int b=onePixels.getBlue();
          Color chosenColor = new Color(r,g,b);
          Color black = new Color (0,0,0,50);
          if (r>= 240 && g>= 240 && b>=240) //the >= gives it a range for the whites.
          {
             onePixels.setColor(black);
            }
        
 
      }
    }
    
  }
   public void setWhiteToBlack()
  {
   Pixel[][] pixels = this.getPixels2D();
   Pixel onePixels= null;
   int width= pixels.length;
   int height= pixels[0].length;
   for (int row = 0; row < width; row++)
    {
      for (int col = 0; col < height; col++)
      {
          onePixels= pixels[row][col];
          int r=onePixels.getRed();
          int g=onePixels.getGreen();
          int b=onePixels.getBlue();
          Color chosenColor = new Color(r,g,b);
          Color black = new Color (0,0,0);
          if (r>= 240 && g>= 240 && b>=240) //the >= gives it a range for the whites.
          {
             onePixels.setColor(black);
            }
        
 
      }
    }
    
  }
   public void setRandomly()
  {
   Pixel[][] pixels = this.getPixels2D();
   Pixel onePixels= null;
   int width= pixels.length;
   int height= pixels[0].length;
   Random gener= new Random();
   for (int row = 0; row < width; row++)
    {
      for (int col = 0; col < height; col++)
      {
          onePixels= pixels[row][col];
          int r=onePixels.getRed();
          int g=onePixels.getGreen();
          int b=onePixels.getBlue();
          int r1=gener.nextInt(255);
          int g1=gener.nextInt(255);
          int b1=gener.nextInt(255);
          Color currentColor = new Color(r,g,b);
          Color randomColor= new Color(r1,g1,b1);
          if (r== 164 && g== 202 && b==57) //the >= gives it a range for the whites.
          {
             onePixels.setColor(randomColor);
            }
        
 
      }
    }
    
  }
   public void mirrorSeagull()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    // rows 230, 320
    // column230, 350
    for (int row = 230; row < 320; row++)
    {
     
      for (int col = 230; col < 350; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][col+150];
        rightPixel.setColor(leftPixel.getColor());
      
       
      }
    }

  }
  
  public void cropAndCopy( Picture sourcePicture, 
  int startSourceRow, int endSourceRow, 
  int startSourceCol, int endSourceCol,
  int startDestRow, int startDestCol ) 
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel grabPixel= null;
      Pixel placePixel= null;
      int k= startDestRow;
      int p=startDestCol;
      for(int i=startSourceRow; i<endSourceRow; i++)
      {
          for(int j=startSourceCol; j< endSourceCol; j++)
          {
              int kEnd= startDestRow+(endSourceRow-startSourceRow);
              int pEnd=startDestRow+(endSourceCol-startSourceCol);
              //System.out.println (k + ""+kEnd+""+p+""+pEnd); Used to see values
              grabPixel= pixels[i][j];
              placePixel= pixels[k][p];
              placePixel.setColor(grabPixel.getColor());
              if( k==kEnd)
              {p++;
               k=startDestRow;
              }
              if(p== pEnd)
              {break;
                }

              k++;            
                
          }
      }
      
      
    }
    
  public Picture scaleByHalf() // working
  {
    Pixel[][] pixels = this.getPixels2D();
    int height= pixels.length;
    int width = pixels[0].length;
    int width2;
    int height2;
    Picture newPic= new Picture(height/2+1, width/2+1 );
    Pixel grabPixel= null;
    Pixel[][] newPics= newPic.getPixels2D();
    for (int i=0; i<height;i+=2)
    {
        for(int j=0; j<width; j+=2)
        {
            grabPixel= pixels[i][j];
            width2=j/2;
            height2=i/2;
            newPics[height2][width2].setColor(grabPixel.getColor());
            
            
        }
    }
    
    return newPic;
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
  public void createAndroidCollage()
  {
      // requirements: 4 of the same image: each one will be modified
      Picture android1= new Picture("android.jpg");
      Picture android2= new Picture("android.jpg");
      Picture android3= new Picture("android.jpg");
      Picture android4= new Picture("android.jpg");
      
      Picture canvas= new Picture(1600,1600);
      //for android 2
      android1= android1.scaleByHalf();
      android1.eliminateWhite();
      android1.addLines();
      android1.mirrorDiagonalAndColor();
      android1.edgeDetection(5);
      // for android 2
      android2= android2.scaleByHalf();
      android2.addLines();
      android2.mirrorDiagonal();
      android2.mirrorHorizontal();
      android2.mirrorVertical();
      //for android 3
      android3= android3.scaleByHalf();
      android3.setWhiteToBlack();
      android3.mirrorHorizontal();
      //for android 4
      android4= android4.scaleByHalf();
      android4.mirrorVertical();
      android4.setRandomly();
      android4.setWhiteToBlack();
     
      
      this.copy(canvas,0,0);
      this.copy(android1,0,0);
      this.copy(android2,400,400);
      this.copy(android3,400,0);
      this.copy(android4,0,400);
      this.write("Android Collage Finished.jpg"); //use this to write the image for the collage
     
      
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
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
