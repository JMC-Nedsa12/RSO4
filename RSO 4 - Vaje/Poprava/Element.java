class Element{
    public int vrednost;
    public Element nasl;
    public Element(){}

    public Element(int value){
        this.vrednost = value;
        this.nasl=this;
    }
    public Element getNasl(){return this.nasl;}
    public int getVrednost(){return this.vrednost;}
    public void setNasl(Element v){this.nasl=v;}
    public void setVrednost(int s){this.vrednost=s;}
} 