package pdfBox;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;


import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

//import org.apache.pdfbox.pdmodel.PDPageStreamstreament;

/**
 * Write a description of class DrawPDF_01 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrawPDF_02{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class DrawPDF_01
     */
    public DrawPDF_02()
    {
        // initialise instance variables
        x = 0;
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
        
        //PDPageContentStream.AppendMode.APPEND this part is must if you want just add new data in exsitnig one
        PDPageContentStream stream = new PDPageContentStream(document, page,
            PDPageContentStream.AppendMode.APPEND, true, true);
            
        //PDPageContentStream stream = new PDPageContentStream(document, page);
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
        stream.endText();
    
        //for second line
        stream.beginText();
        stream.newLineAtOffset( page.getMediaBox().getWidth() - titleWidth - 10,685);
        stream.setLeading(40.5f);
        stream.showText("this is line     second");
        stream.newLine();
        stream.showText("this is line     second");
        stream.newLine();
        stream.showText("this is line     second");
        stream.endText();
        stream.moveTo(50,50);
        stream.lineTo(200,200);
        
        /*
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
        */
        System.out.print(page.getMediaBox().getWidth() +" -2- ");
        System.out.println(page.getMediaBox().getHeight());
        
        
        stream.beginText();
        // centrira na sredino strani
        stream.newLineAtOffset((page.getMediaBox().getWidth() - titleWidth) / 2, (page.getMediaBox().getHeight() - marginTop - marginBottom - titleHeight) / 2 );
        
        stream.showText(title); //stream.drawString(title);
        stream.endText();
        stream.close();
        
        document.save("hm.pdf");
    }
}
