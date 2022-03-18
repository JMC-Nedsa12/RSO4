import java.util.*;
public class KroEnPovSez extends LinEnPovSez implements ShowableList{
    class Node{
        char value;
        Node next;
        public Node(){}

        public Node(char value){
            this.value = value;
            this.next=this;
        }

    } 
    private Node prvi = null;   

    public Node getPrvi_(){
        return this.prvi;
    }

    public KroEnPovSez() {}

    
    public void showSezLast2First( Node first ){       
        if ( first.next != prvi){
            showSezLast2First(first.next);
            System.out.print(first.value);
            return;
        }
        if(prvi!=null){
            System.out.print(first.value);
        }
    }

    public void showSezFirst2Last( Node first ){       
        if ( first.next != prvi){
            System.out.print(first.value);
            showSezFirst2Last(first.next);
            return;
        }
        if(prvi!=null){
            System.out.print(first.value);
        }
    }

    public void showSezLast2FirstOrdered ( Node first ){       
        Node placeholder= first;
        home(first);
        first=prvi;
        if ( first != null){
            showSezLast2First(first.next);
            System.out.print(first.value);
        }
        prvi=placeholder;
    }

    public void showSezFirst2LastOrdered ( Node first ){       
        Node placeholder= first;
        home(first);
        first=prvi;
        if ( first != null){
            System.out.print(first.value);
            showSezFirst2Last(first.next);

        }
        prvi=placeholder;
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
            //prvi.next=prvi;
            return;
        }
        if (prvi.value==element){
            Node n=new Node(element);
            n.next = prvi.next;
            prvi.next=n;
            // while(prvi.next!=n.next){
            // prvi=prvi.next;
            // }
            // prvi.next.next=n;
            return;
        }
        if(prvi.value>element){
            Node n= new Node (element);
            Node last = prvi.next;
            while(last.next.value>element&&last!=prvi&&last.next.value>=last.value){
                last=last.next;
            }
            if(last.next.value>=element){
                n.next=last.next;
                last.next=n;
                return;
            }
            if (last.next.value<element){
                Node trail=last;
                Node lead=last.next;
                if(lead.value < element){
                    lead=lead.next;
                    trail=trail.next;
                    while(lead.value < element && lead.next!=last){
                        lead=lead.next;
                        trail=trail.next;
                    }
                    trail.next=n;
                    n.next=lead;
                    return;
                }

            }
            else{
                Node trail=null;
                Node lead=prvi;
                if(lead.value < element){
                    lead=lead.next;
                    trail=prvi;
                    while(lead.value < element && lead.next!=prvi){
                        lead=lead.next;
                        trail=trail.next;
                    }
                    trail.next=n;
                    n.next=lead;
                    return;
                }
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
            while(prvi.next!=tmp){
                while (curr.next!=tmp){
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
            while(prvi.next!=tmp){
                while (curr!=tmp){
                    curr=curr.next;
                    if (curr==prvi){
                        curr=curr.next;
                        if (curr==tmp){
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
            //System.out.println(duplicirane);
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

            while(prvi.next!=tmp){
                if (duplikati.length()!=0){
                    for(int i = 0; i< duplikati.length();i++){
                        if (duplikati.charAt(i)==prvi.value){
                            flag=true;

                        }
                    }
                }
                while (curr.next!=tmp && flag!=true){
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
        // System.out.println(duplikati);
        prvi=tmp;
        return dup;

    }        

    public void normaliziraj(){
        if(soDuplikati()==false){
            return;
        }
        if (prvi != null){
            Node trail=prvi;
            Node lead=prvi.next;
            while (trail.next!=prvi){
                lead=trail.next;
                while(lead!=prvi){
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

    public char showCurrent(){
        return prvi.value;
    } 

    public void next(){
        prvi=prvi.next;
    }

    public void home(Node first){
        if(first.next.value>=first.value){
            home(first.next);
            return;
        }
        prvi=first.next;
    }
}
