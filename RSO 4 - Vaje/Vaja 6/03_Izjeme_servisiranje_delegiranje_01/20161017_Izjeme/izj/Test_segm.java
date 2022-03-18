
public class Test_segm
{
   public static void showAllSegments(Segment s) {
       
       while (s != null){
           System.out.print(s+" - ");
           s = s.nasl;
        }
        System.out.println();
    }
    
    
    
   public static void main(String[] args){
       
       Segment s = new Segment();
       
       // make another two segments
       Segment s1 = new Segment(s);
       s.nasl = s1;
       
       Segment s2 = new Segment(s1);
       s1.nasl=s2;
       
       for (int i=0;i<30;i++)
       
          try {
             s.up();
            } catch(MOverFlowException e){
                s.overflow();
            } finally {
                // show all segments
                //System.out.println(s);
                showAllSegments( s );
            }
       
       
   }
}
