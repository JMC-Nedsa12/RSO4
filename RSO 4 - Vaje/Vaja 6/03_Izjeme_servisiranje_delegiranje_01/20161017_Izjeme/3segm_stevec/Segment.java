//Odgovori na prvo vprašanje se nahajajo v readme datoteki

public class Segment
{
    // instance variables - replace the example below with your own
    private int stanje;
    
    Segment nasl, pred;

    /**
     * Constructor for objects of class Segment
     */
    public Segment()
    {
        stanje=0; nasl=null; pred=null;
    }

    public Segment(Segment pred){
        stanje=0; nasl=null; this.pred=pred;
    }
    
    public int getStanje(){
        return stanje;
    }
    
    
    public void overflow(){
        
          stanje=0;
         
          try {
              nasl.up();
            } catch ( NullPointerException e){
                
            } catch ( MOverFlowException e ){
                System.out.println(e);
                nasl.overflow();
              }
        
         
          
    }
    
    public void underflow(){
        
          stanje=9;
         
          try {
              nasl.down();
            } catch ( NullPointerException e){
                
            } catch ( MUnderFlowException e ){
                System.out.println(e);
                nasl.underflow();
              }
        
         
          
    }
    public void up() throws MOverFlowException {
        stanje++;
        if (stanje>9)
          throw new MOverFlowException();
    }
    
    
    
    
    public void down() throws MUnderFlowException {
        stanje--;
        if (stanje<0){
            throw new MUnderFlowException();
        }
    }
    
    public void setNasl(Segment nasl){
        this.nasl = nasl;
    }
    
    public void setPrev(Segment pred){
        this.pred=pred;
    }
    
    
    public String toString(){
        return ""+stanje;
    }
    
}
