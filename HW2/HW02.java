import java.awt.*;
/**
 * Part One of the program is portion of my own drawing.
 * Part Two of the  program create six different sizes of image that contains
 * blue , white and yellow diagonals line.
 * it has 3 methods including main. 
 
 * @author (Mohamed Gas)
 * @version (Graphics 04-17-2021)
 */
public class HW02
{
  public static void main (String[] args)
  {
      partOne(); // Part One
      partTwo(); //Part Two
       
       
    }
    
    //Part One 
    public static void partOne()

    {
        // This Method is to draw a panel with different Colors
        DrawingPanel dp1=new DrawingPanel(200,200);
        
       dp1.setBackground(Color.white);
       dp1.setGridLines(true);
       
       Graphics dpg=dp1.getGraphics();
       dpg.drawString("Mohamed gas ",20,110);
       
       dpg.setColor(Color.green);
       dpg.fillRect(0,0,200,50);
       
       dpg.setColor(Color.red);
       dpg.fillRect(0,140,200,60);
       
    }
    
    
    //Part Two
    public static DrawingPanel dp2= new DrawingPanel(800,700);
   
    public static void partTwo()
    { 
        /*
         x-coordinate, y-coordinate, w-width ,l-length,xw-whitebox coordinate ,yw-whitebox coordinate, numoftiles
        */
       drawRect(0,0,20,20,0,20,6);// Left Boxes
       drawRect(700,220,50,50,700,270,4); // Right Box
       
       // smallest grid
       int var=30;
       
       for( int i=0;i<8;i++)
       {
           drawRect(var,580,10,10,var,590,4);
           var+=11;
        }
        
       // Largest grid
       
       int varLarge1=150;
       int varLarge2=190;
       int varLarge3=varLarge1;
       int offsetLarge=10;
       for (int i=0;i<10;i++)
       {
           drawRect(varLarge1,varLarge3,40,40,varLarge1,varLarge2,5);
           varLarge2+=offsetLarge;
           varLarge3+=offsetLarge;
           offsetLarge*=-1;
           varLarge1+=41;
        }
       
        // Medium
       int varMed1=600;
       int varMed2=40;
       int varMed3=15;
       int offsetMed=15;
        for (int i=0;i<7;i++)
       {
           drawRect(varMed1,varMed3,25,25,varMed1,varMed2,3);
           varMed2+=offsetMed;
           varMed3+=offsetMed;
           offsetMed*=-1;
           varMed1+=26;
        }
    }
    
    public static void drawRect(int x,int y,int w, int l,int xw ,int yw,int numOfTiles )
    {
        int ywhite=yw;
        int ycoor=y;
        dp2.setBackground(Color.gray);
        
        Graphics dpg= dp2.getGraphics();
        //dpg.setColor(Color.blue);
       
        dpg.setColor(Color.blue); 
        // Blue Boxes
        for (int i=0;i<numOfTiles;i++)
        {
            dpg.fillRect(x,ycoor,w,l);
            ycoor+=2*l;
        }
        
        // White Boxes
        
         for (int i=0;i<numOfTiles;i++)
        {
            dpg.setColor(Color.white);
            dpg.fillRect(xw,ywhite,w,l);
            ywhite+=2*l;
        }
        
        //DrawLine 
       int x1=x;
       int y1=y;
       int x2=x1+w;
       int y2=y1+l;
            
        for(int i=0;i<numOfTiles;i++)
        {
            
            
            dpg.setColor(Color.yellow);
            dpg.drawLine(x1,y1,x2,y2);
            dpg.drawLine(x2,y1,x1,y2);
            
            y1=y1+(2*l);
            y2=y2+(2*l);
            
        
        }
         
         
         
        
    }
    
    
     
}
