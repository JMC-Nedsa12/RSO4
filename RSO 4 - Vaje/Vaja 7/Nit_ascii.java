public class Nit_ascii implements Runnable{
    char crka;
    
    public Nit_ascii(char crka){
        this.crka=crka;
    }    
    public void run(){
            for (int i = 0; i<10*(int)crka; i++){
            System.out.println(crka);
            
            /*
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){}
            */
        }
    }
}