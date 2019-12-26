/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Life;

/**
 *
 * @author corwinman
 */
import java.util.Random;
public class Life {

        private static int sideLength=90;
        protected boolean currentFrame [];
    
    public Life(){
        currentFrame = new boolean[(int) Math.pow(sideLength,2)];       
        for(int i = 0; i<sideLength; i++)
            currentFrame[i] = false;
    
        /*
        for(int i = 0; i<sideLength; i++){
           currentFrame[i] = true;
           currentFrame[sideLength*sideLength-1-i]=true;
        }
        
        for(int i = 10; i<sideLength-10;i++){
            currentFrame[i]=true;
            currentFrame[sideLength*sideLength-1-i]=true;
        }
        
        for(int i=0; i<sideLength*(sideLength-1); i+=sideLength){
            currentFrame[i]=true;
            currentFrame[i+(sideLength-1)]=true;
        }
        
        for(int i=10; i<sideLength*(sideLength-1)-10; i+=sideLength){
            currentFrame[i]=true;
            currentFrame[i+(sideLength-1)]=true;
        }
        */
        
        /*random population*/
        for(int i =0; i<Math.pow(sideLength,2)/10; i++){
            Random randy = new Random();
            currentFrame[randy.nextInt((int)Math.pow(sideLength,2))]=true;
        }
        
        
        
      
      /*Glider
      currentFrame[1]=true;
      currentFrame[2+sideLength]=true;
      for(int i = 2*sideLength; i<=2*sideLength+2; i++)
          currentFrame[i] = true;
      */
      
    }
    
    public int getSideLength(){
        return sideLength;
    }
        
        
    private boolean isTopRow(int x){
        return (x/sideLength==0);
    }
    private boolean isBottomRow(int x){
        return (x/sideLength==sideLength-1);
    }
    private boolean isLeftMostColumn(int x){
        return (x%sideLength==0);
    }
    private boolean isRightMostColumn(int x){
        return (x%sideLength==sideLength-1);
    }
    
    private int findNeighbors(int x){
        int livingNeighbors=0;
        if(!isTopRow(x)){
            if(currentFrame[x-sideLength])
                livingNeighbors++;
            if(!isLeftMostColumn(x) && currentFrame[x-(sideLength+1)])
                livingNeighbors++;
            if(!isRightMostColumn(x) && currentFrame[x-(sideLength-1)])
                livingNeighbors++;
        }
        if(!isBottomRow(x)){
            if(currentFrame[x+sideLength])
                livingNeighbors++;
            if(!isLeftMostColumn(x) && currentFrame[x+(sideLength-1)])
                livingNeighbors++;
            if(!isRightMostColumn(x) && currentFrame[x+(sideLength+1)])
                livingNeighbors++;
        }
        if(!isLeftMostColumn(x) && currentFrame[x-1])
            livingNeighbors++;
        if(!isRightMostColumn(x) && currentFrame[x+1])
            livingNeighbors++;  
        return livingNeighbors;
    } 
    public void getFrame(){
         boolean [] newFrame = new boolean[(int) Math.pow(sideLength,2)];
        for(int i = 0; i<Math.pow(sideLength,2); i++){
            newFrame[i]=false;
           if(currentFrame[i]){
               if(findNeighbors(i)<4 && findNeighbors(i)>1)
                   newFrame[i]=true;
           }
           else if(findNeighbors(i)==3)
               newFrame[i]=true;
           }
        currentFrame=newFrame;
    }
}
            
   
