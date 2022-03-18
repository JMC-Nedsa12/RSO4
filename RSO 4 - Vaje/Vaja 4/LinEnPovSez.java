
import java.util.*;
public class LinEnPovSez implements ShowableList{
    class Node{
        char value;
        Node next;
        public Node(){}

        public Node(char value){
            this.value = value;
        }

    } 
    private Node prvi = null;   

    public Node getPrvi(){
        return prvi;
    }

    public LinEnPovSez() {}

    public void showSezLast2First( Node first ){       
        if ( first != null){
            showSezLast2First(first.next);
            System.out.print(first.value);
        }
    }

    public void showSezFirst2Last( Node first ){       
        if ( first != null){
            System.out.print(first.value);
            showSezFirst2Last(first.next);

        }
    }

    public void dodaj_(char element){
        if(prvi==null){
            prvi = new Node(element);
            return;
        }
        Node n= new Node(element);
        n.next=prvi;
        prvi=n;
    }

    public void dodaj(char element){
        if(prvi==null){
            prvi = new Node(element);
            return;
        }
        if (prvi.value>=element){
            Node n=new Node(element);
            n.next = prvi;
            prvi=n;
            return;
        }
        else{
            Node trail=null;
            Node lead=prvi;
            Node n=new Node(element);
            if(lead.value < element){
                lead=lead.next;
                trail=prvi;
                while(lead.value < element && lead.next!=null){
                    lead=lead.next;
                    trail=trail.next;
                }
                trail.next=n;
                n.next=lead;
                return;
            }
        }
    }

    public void dodaj(String niz){
        for(int i=0;i<niz.length();i++){
            dodaj(niz.charAt(i));
        }
    }

    public boolean soDuplikati(){
        if (prvi !=null){
            Node tmp=prvi;
            Node curr=prvi;
            while(prvi!=null){
                while (curr.next!=null){
                    curr=curr.next;
                    if (curr==prvi){
                        curr=curr.next;
                        if (curr==null){
                            break;

                        }
                    }
                    if (curr.value==prvi.value){
                        prvi=tmp;
                        return true;
                    }
                }
                prvi=prvi.next;
                curr=prvi;
            }
            prvi=tmp;
        }        
        return false;
    }

    public int preštejDuplicirane(){
        Node tmp=prvi;
        int dup=0;
        if (soDuplikati()==false){return 0;}
        if (prvi !=null){
            Node curr=prvi;
            boolean flag=false;
            String duplicirane="";
            while(prvi!=null){
                while (curr.next!=null){
                    curr=curr.next;
                    if (curr==prvi){
                        curr=curr.next;
                        if (curr==null){
                            break;
                        }

                    }
                    if (curr.value==prvi.value){
                        if (duplicirane.length()!=0){
                            for(int i = 0; i< duplicirane.length();i++){
                                if (duplicirane.charAt(i)==curr.value){flag=true;}
                            }
                        }
                        if (flag==false){
                            duplicirane+=curr.value;
                            dup++;
                        }
                        flag=false;
                    }
                }

                prvi=prvi.next;
                curr=prvi;;
            }
        }
        prvi=tmp;
        return dup;
    }

    public int preštejDuplikate(){
        if(soDuplikati()==false){
            return 0;
        }
        Node tmp=prvi;
        int dup=0;
        String duplikati="";
        if (prvi !=null){
            Node curr=prvi;
            boolean flag=false;

            while(prvi!=null){
                if (duplikati.length()!=0){
                    for(int i = 0; i< duplikati.length();i++){
                        if (duplikati.charAt(i)==prvi.value){
                            flag=true;

                        }
                    }
                }
                while (curr.next!=null && flag!=true){
                    curr=curr.next;
                    if (curr.value==prvi.value){
                        if (duplikati.length()==0){
                            duplikati+=curr.value;
                            dup++;
                            flag=true;
                        }
                        if (flag==false){
                            duplikati+=curr.value;
                            dup++;
                        }
                        flag=false;
                    }
                    flag=false;
                }

                prvi=prvi.next;
                curr=prvi;;
                flag=false;
            }
        }
        //System.out.println(duplikati);
        prvi=tmp;
        return dup;

    }
        
    public void normaliziraj_(){
        if(soDuplikati()==false){
            return;
        }
        Node tmp=prvi;
        Node trail=prvi;
        Node curr=prvi;
        int dup=0;
        String duplikati="";
        if (prvi !=null){

            boolean flag=false;
            while(prvi!=null){
                if (duplikati.length()!=0){
                    for(int i = 0; i< duplikati.length();i++){
                        if (duplikati.charAt(i)==prvi.value){
                            trail.next=prvi.next;
                            prvi=prvi.next;
                            flag=true;

                        }
                    }
                }
                while (curr.next!=null && flag!=true){
                    curr=curr.next;
                    if (curr.value==prvi.value){
                        if (duplikati.length()==0){
                            duplikati+=curr.value;
                            dup++;
                            trail.next=prvi.next;
                            //prvi=prvi.next;
                            flag=true;
                        }
                        if (flag==false){
                            duplikati+=curr.value;
                            trail.next=prvi.next;
                            //curr=curr.next;
                            dup++;
                        }
                        flag=false;
                    }
                    flag=false;
                }
                if (prvi!=tmp){
                    trail.next=prvi;
                    trail=trail.next;
                }
                try{prvi=prvi.next;
                    curr=prvi;
                }catch(Exception e){}   
                flag=false;
            }
        }
        System.out.println(duplikati);
        prvi=tmp;
        return;

    }

    public void normaliziraj(){
        if(soDuplikati()==false){
            return;
        }
        if (prvi != null){
            Node trail=prvi;
            Node lead=prvi.next;
            while (trail!=null){
                lead=trail.next;
                while(lead!=null){
                    if (trail.value==lead.value){
                        trail.next=lead.next;
                    }
                    lead=lead.next;
                }
                trail=trail.next;
            }
        }
        return;
    }
}
