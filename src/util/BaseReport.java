
package util;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;

public class BaseReport {
    
    private String titleReport;
    private String[] nameHeaders;
    private JTable jTable;  
    
    public BaseReport(String reportTitle, String[] headerNames) {
        this.titleReport = reportTitle;
        this.nameHeaders = headerNames;
    }
    
    public void runReport(JTable jtable, String pathSaveFile, String fileName) throws Exception {
        
         String dataAtual;
         dataAtual = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        
        this.jTable = jtable;
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(pathSaveFile + "/" + fileName +".pdf"));
        document.open();
        Image image1 = Image.getInstance("../img/logoPDF.png");
        image1.setAlignment(Element.ALIGN_CENTER);
        document.add(image1);
        document.add(new Paragraph(" "));
        document.add(new Paragraph("                 Data: "+dataAtual+"                                                 CNPJ: 20.233.245/00001-12"));
        document.add(new Paragraph(" "));
        document.add(getPdfPTable());
        document.close();
    }
    private PdfPTable getPdfPTable() throws Exception {
        PdfPTable tab = new PdfPTable(nameHeaders.length);
        tab.addCell(getCellTitle());
        for (int i = 0; i < nameHeaders.length; i++){
            tab.addCell(nameHeaders[i]);
        }
        int rowCount = jTable.getRowCount();
        int collumCount = jTable.getColumnCount();
        for (int x = 0; x < rowCount; x++) {
            for (int y = 0; y < collumCount; y++) {
                tab.addCell(GetData(jTable, x, y).toString());
            }
        }
        return tab;
    }
    private Object GetData(JTable table, int row_index, int col_index) throws Exception {
        return table.getModel().getValueAt(row_index, col_index);
    }
    private PdfPCell getCellTitle() {
        PdfPCell cell = new PdfPCell(new Paragraph(titleReport));
        cell.setColspan(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.LIGHT_GRAY);
        return cell;
    }
}
