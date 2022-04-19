import com.itextpdf.html2pdf.*;
import com.itextpdf.kernel.pdf.PdfDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Html2PDF_iText {

public static void main(String[] args) throws IOException {
        // IO
        File htmlSource = new File("input.html");
        File pdfDest = new File("output_2.pdf");
        
         // pdfHTML specific code
        ConverterProperties converterProperties = new ConverterProperties();
        
        HtmlConverter.convertToPdf(new FileInputStream(htmlSource), 
               new FileOutputStream(pdfDest), converterProperties);
      
      }
}