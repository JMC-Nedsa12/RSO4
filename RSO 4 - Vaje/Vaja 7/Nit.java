public class Nit implements Runnable{
    char crka;
    
    public Nit(char crka){
        this.crka=crka;
    }
    public void run(){
        for (int i = 0; i<100; i++){
            System.out.println(crka);
            
            /*
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){}
            */
        }
    }
}
