
public class Test_Exceptions
{
   
    static int a=0,b=0;
    
    
    /**
     * Constructor for objects of class Test_Exceptions
     */
    public Test_Exceptions()
    {
       
    }

    
    
    public static void countUp() throws MOverFlowException{
        
        a++;
        if (a>9){
           throw new MOverFlowException();
        }
        
    }
    
    
     
    
    
    
    public static void main(String[] args) {
        
        for(int i=0;i<30;i++){
        
            try {
            
                    countUp(); 
                    //System.out.println("a: "+a+" b: "+b);
             
            
                } catch (MOverFlowException e){
                    b++;
                    a=0;
                } finally {
                   System.out.println("b: "+b+" a: "+a);
                }
        
            }
        
        
        
        
    }
}
