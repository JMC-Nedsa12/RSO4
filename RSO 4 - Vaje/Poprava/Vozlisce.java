class Vozlisce  implements Primerjanje{
    private String vrednost;
    private Vozlisce nasl;
    public Vozlisce(){}

    public Vozlisce(String value){
        this.vrednost = value;
    }
    public Vozlisce getNasl(){return this.nasl;}
    public String getVrednost(){return this.vrednost;}
    public void setNasl(Vozlisce v){this.nasl=v;}
    public void setVrednost(String s){this.vrednost=s;}
    
    public boolean jeManjsi(Vozlisce v){
            return this.vrednost.compareTo(this.nasl.vrednost)<0;
            
    }
} 