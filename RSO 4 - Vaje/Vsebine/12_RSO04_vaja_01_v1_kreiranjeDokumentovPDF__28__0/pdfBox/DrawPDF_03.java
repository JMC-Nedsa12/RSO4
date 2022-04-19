package pdfBox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.Color;

//import org.apache.pdfbox.pdmodel.PDPageStreamstreament;
/**
 * Write a description of class DrawPDF_01 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrawPDF_03{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class DrawPDF_01
     */
    public DrawPDF_03()
    {
        // initialis3 instance variables
        x = 0;
    }

    public void testRow() throws java.io.IOException{

        // -- record data 
        String[] record = {"AB","C","DE","fgh","ijklmn"};
        int[] offSets={0,100,200,300,400};

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();        
        document.addPage(page);

        //--- MediaBox daje velikost strani
        float xSize = page.getMediaBox().getWidth();
        float ySize = page.getMediaBox().getHeight();

        //--- v pokončni usmeritvi A4 bi želeli absolutno postaviti robe v znanih dimenzijah v mm
        float etaX = xSize/210;
        float etaY = ySize/297;

        //--- margins za PDF document
        float marginLeft = 20*etaX, marginRight=20*etaX;
        float marginTop = 30*etaY, marginBottom = 30*etaY;

        float headerHeight = 50*etaX;

        System.out.print(page.getMediaBox().getWidth() +" -2- ");
        System.out.println(page.getMediaBox().getHeight());

        // torej lahko za tabelo zapisov izračunamo prvo uporabno y pozicijo kot:
        float nextY = ySize - marginTop - headerHeight;

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDFont font = PDType1Font.HELVETICA_BOLD; // Or whatever font you want.
        int fontSize=10;

        contentStream.setFont(font, fontSize);

        // tole so nastavitve za ćrto; realizacija 'podčrtavanja je LAZY, jasno z veliimi črtami
        // realno je potrebno : najprej izrisati črte, črte grejo vsaj 3 pike pod spodnji rob besedila in
        // šele potem se izriše preko tega tekst. S tem dosežete, da tekst morebiti prekrije črto
        // ----
        // spodaj : naredimo črto lasno-tanko in rahlo zelo svetlo sivo, tako se ne vidi, da je dejansko 
        //          izrisano čez spodnji rob črk, in nad črkami, ki segajo pod spodnji rob (j,g,q)
        //          hkrati pa naredimo še redek vzorec črte
        contentStream.setLineDashPattern (new float[]{1,3}, 0.0f);  //pattern : 1 on 3 off ... + frequency
        contentStream.setStrokingColor(219/256,219/256,219/256);   // very light gray 0xDBDBDB . a int ne dela več ?
        contentStream.setStrokingColor(Color.lightGray);           // zgleda, da zgornji rgb nima učinka, torej uporabimo barvo iz awt.Color
        contentStream.setLineCapStyle(1);                          // hm, zaokroženi konci črt ?
        contentStream.setLineWidth(0.1f);                          // koliko je to ? je še vidno ?

        // draw line ot-top (before first line ..
        contentStream.moveTo(marginLeft, nextY+fontSize); 
        contentStream.lineTo(xSize-marginRight, nextY+fontSize); 

        //  test s petimi vrsticami ....
        for (int j=0;j<5;j++){

            // a) narišemo črto (pod besedilom; draw ali line ?  -- pazi naslednja vrsta gre proti nič ..... 
            contentStream.moveTo(marginLeft, nextY); 
            contentStream.lineTo(xSize-marginRight, nextY);

            // b) izpišemo še besedilo (nad narisano črto
            for (int i = 0; i < record.length; i++) {
                String text = record[i]+((i==1)?j:"");
                contentStream.beginText();
                contentStream.newLineAtOffset(marginLeft + offSets[i], nextY);
                contentStream.showText(text != null ? text : "-");
                contentStream.endText();
                //--- nextTextX = offseTs+= table.getColumns().get(i).getWidth();
            }

            // naslednja vrstica se bo vertikalno izpisovala na ...
            nextY -= fontSize;           
        }

        contentStream.stroke();   //dejansko 'nariše' črte
        contentStream.close();
        document.save("5records_03.pdf");
    }

    
    static int fontSize = 10;
    static Color barva = Color.lightGray;
    static PDFont font = PDType1Font.HELVETICA_BOLD; // Or whatever font you want.
    
    static float xSize = 0;  // values from first init
    static float ySize = 0;
    
    static float etaX = 0;
    static float etaY = 0;

    //--- margins za PDF document
    static float marginLeft = 0, marginRight=0;
    static float marginTop = 0, marginBottom=0;

    static float headerHeight = 0;
    static float footerHeight = 0;
    
    static float nextY=0;
    
    PDPageContentStream mojPageContentStream(PDDocument document, PDPage page)  throws java.io.IOException {
        
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
       
        contentStream.setFont(font, fontSize);
        contentStream.setLineDashPattern (new float[]{1,3}, 0.0f);  //pattern : 1 on 3 off ... + frequency
        contentStream.setStrokingColor(219/256,219/256,219/256);   // very light gray 0xDBDBDB . a int ne dela več ?
        contentStream.setStrokingColor(barva);           // zgleda, da zgornji rgb nima učinka, torej uporabimo barvo iz awt.Color
        contentStream.setLineCapStyle(1);                          // hm, zaokroženi konci črt ?
        contentStream.setLineWidth(0.1f); 

        nextY = ySize - marginTop - headerHeight; 
        
        // draw line ot-top (before first line ..
        contentStream.moveTo(marginLeft, nextY+fontSize); 
        contentStream.lineTo(xSize-marginRight, nextY+fontSize);
        
        
        
        return contentStream;
    };

    /**
     *   recimo, da skušamo izrisati 5 strani: aka tabela se nadaljuje na naslednji strani;
     *   upoštevati je potrebne headerje in footerje na vseh straneh: hočemo, da so
     *   ti enaki na vseh straneh in da so vse strani enake
     *   
     *   - strani so v footerju številčene zgolj s imenom dokumenta in številko strani ne pa tudi
     *     s številom vseh strani (to bi bilo potrebno : ali vnaprej izračunati ali pa generiranju vseh
     *     strani popraviti na vseh prej zgeneriranih straneh, pa se nam ne da tega početi)
     */
    public void testPages() throws java.io.IOException{

        String fileName= "N-pages_04.pdf";

        // -- record data 
        String[] record = {"AB","C","DE","fgh","ijklmn"};
        int[] offSets={0,100,200,300,400};
        int recCount=0;
        int stevilkaStrani=1;
        
        
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();        
        document.addPage(page);

        //--- MediaBox daje velikost strani
        xSize = page.getMediaBox().getWidth();
        ySize = page.getMediaBox().getHeight();

        //--- v pokončni usmeritvi A4 bi želeli absolutno postaviti robe v znanih dimenzijah v mm
        etaX = xSize/210;
        etaY = ySize/297;

        //--- margins za PDF document
        marginLeft = 20*etaX; marginRight=20*etaX;
        marginTop = 30*etaY; marginBottom = 30*etaY;

        headerHeight = 50*etaY;
        footerHeight = 30*etaY;

        System.out.print(page.getMediaBox().getWidth() +" -2- ");
        System.out.println(page.getMediaBox().getHeight());

        PDPageContentStream contentStream =  mojPageContentStream(document, page);

        int j=0;
        int NNN=500;   //hm blefiramo 500-1 zapisov - številke so torej 1-499 (glej pogoj < !)
        
        boolean soSe=true;
        
        for (;soSe;) {
            //  test s petimi vrsticami ....
            for (;j<NNN;j++){

                // a) narišemo črto (pod besedilom; draw ali line ?  -- pazi naslednja vrsta gre proti nič ..... 
                contentStream.moveTo(marginLeft, nextY); contentStream.lineTo(xSize-marginRight, nextY);

                // b) izpišemo še besedilo (nad narisano črto
                for (int i = 0; i < record.length; i++) {
                    String text = record[i]+((i==1)?(++recCount):"");
                    contentStream.beginText();
                    contentStream.newLineAtOffset(marginLeft + offSets[i], nextY);
                    contentStream.showText(text != null ? text : "-");
                    contentStream.endText();
                    //--- nextTextX = offseTs+= table.getColumns().get(i).getWidth();
                }

                // naslednja vrstica se bo vertikalno izpisovala na ...
                nextY -= fontSize;  
                
                //ali je naslednja vrsta še na isti strani ?, če ne končaš stran
                // smo zelo zoprni ?
                // če je nexY < footerHeight+marginBottom              
                if (nextY < footerHeight + marginBottom || recCount+1>=NNN)  
                    break;   
                
            }

            //-------------------  v footer gre ime dokumenta in številka strani
            narisiNogo(contentStream,fileName,stevilkaStrani);

            
            contentStream.stroke();   //dejansko 'nariše' črte
            contentStream.close();

            //if there is another record, form new page ...
            if ( recCount+1<NNN ) {
                // poskusimo najprej s tem, da de-referenciramo stare; če ne bo šlo ....
                page = new PDPage();        
                document.addPage(page);
                contentStream = mojPageContentStream(document, page);
                stevilkaStrani++;
            } else
                soSe=false;  // no records left to print

        }
        document.save("N_pages_04.pdf");
    }

    void narisiNogo(PDPageContentStream contentStream, String fileName, int stevilkaStrani) throws java.io.IOException{
                            //line delimiter
                   contentStream.stroke();   // prejšnjega moraš izpisati, drugače bodo vsi isti !
                   contentStream.setLineDashPattern (new float[]{1,0},0f);    // very light gray 0xDBDBDB . a int ne dela več ?
                   contentStream.setStrokingColor(Color.black);           // zgleda, da zgornji rgb nima učinka, torej uporabimo barvo iz awt.Color
                  contentStream.setLineCapStyle(1);                          // hm, zaokroženi konci črt ?
                  contentStream.setLineWidth(0.5f); 
                   contentStream.moveTo(marginLeft+300, footerHeight + marginBottom - fontSize); 
                   contentStream.lineTo(xSize-marginRight,footerHeight + marginBottom - fontSize);
                  
                   contentStream.beginText();
                   contentStream.newLineAtOffset(marginLeft + 360, footerHeight + marginBottom - 4*fontSize);
                   contentStream.showText(fileName + " - stran: " + stevilkaStrani);
                   contentStream.endText();
    }
    
    /**
     * Naj bi na sredo strani izrisala dano besedilo
     *  povzeto po : https://www.javaer101.com/en/article/3700796.html
     *  korekcija: izogib rabe 'depreceted' metod, kompatibilnost s 3.0.+
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void testMethod() throws java.io.IOException {
        String title = "This is my wonderful title!"; // Or whatever title you want.
        int marginTop = 30; // Or whatever margin you want.
        int marginBottom = 30;

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();        
        document.addPage(page);

        PDPageContentStream stream = new PDPageContentStream(document, page);
        PDFont font = PDType1Font.HELVETICA_BOLD; // Or whatever font you want.

        int fontSize = 16; // Or whatever font size you want.
        float titleWidth = font.getStringWidth(title) / 1000 * fontSize;
        float titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;

        System.out.print(page.getMediaBox().getWidth() +" ");
        System.out.println(page.getMediaBox().getHeight());

        stream.beginText();
        stream.setFont(font, fontSize);
        //stream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);

        // centira 'naslov'
        stream.newLineAtOffset((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
        stream.showText(title);
        stream.newLine();
        stream.showText("                                                              barbara");
        stream.newLine();
        stream.setFont(PDType1Font.TIMES_ROMAN, 12);
        stream.setLeading(14.5f);

        stream.newLineAtOffset(10, 40);
        String line1 = "World War II (often abbreviated to WWII or WW2), "
            + "also known as the Second World War,";
        stream.showText(line1);

        stream.newLine();

        String line2 = "was a global war that lasted from 1939 to 1945, "
            + "although related conflicts began earlier.";
        stream.showText(line2);
        stream.newLine();

        String line3 = "It involved the vast majority of the world's "
            + "countries—including all of the great powers—";
        stream.showText(line3);
        stream.newLine();

        String line4 = "eventually forming two opposing military "
            + "alliances: the Allies and the Axis.";
        stream.showText(line4);
        stream.newLine();

        System.out.print(page.getMediaBox().getWidth() +" -2- ");
        System.out.println(page.getMediaBox().getHeight());

        // centrira na sredino strani
        //stream.newLineAtOffset((page.getMediaBox().getWidth() - titleWidth) / 2, (page.getMediaBox().getHeight() - marginTop - marginBottom - titleHeight) / 2 );
        //stream.moveTo((page.getMediaBox().getWidth() - titleWidth) / 2, 400 );

        stream.showText(title); //stream.drawString(title);
        stream.endText();
        stream.close();

        document.save("hm.pdf");
    }
}
