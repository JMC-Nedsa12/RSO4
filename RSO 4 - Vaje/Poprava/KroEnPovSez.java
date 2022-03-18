public class KroEnPovSez{

    private Element prvi = null;   

    public Element getPrvi_(){
        return this.prvi;
    }

    public KroEnPovSez() {}

    public void dodaj(int element){
        if(prvi==null){
            prvi = new Element(element);
            //prvi.nasl=prvi;
            return;
        }

        Element n= new Element (element);
        Element last = prvi.nasl;
        while(last.nasl.vrednost>element&&last!=prvi&&last.nasl.vrednost>=last.vrednost){
            last=last.nasl;
        }
        last.nasl=n;
        n.nasl=prvi;        
    }

    public int prestejElemente(){
        if(prvi==null){return 0;}
        if(prvi.nasl==prvi){return 1;}

        int count=1;
        Element curr=prvi;
        while(curr.nasl!=prvi){count++;curr=curr.nasl;}
        return count;
    }
}