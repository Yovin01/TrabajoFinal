/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pruebas;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.Component;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yovin
 */
public class pa {

//    public void tablaPDF(String nomEmpresa, String art, String cod, ,PlantillaPDF pdf) {
//        ControladorPlantillaPDF doc = new ControladorPlantillaPDF(pdf.getNombreUsuario(),pdf.getNombreArchivo());
//        Image im = null;
//        try {
//            im = new Image(ImageDataFactory.create("C:\\Users\\LENOVO\\OneDrive\\Escritorio\\CCB\\src\\Vista\\Imagen\\logo.png"));
//            im.scaleAbsolute(150, 100).setFixedPosition(670,494);
//        } catch (MalformedURLException e) {
//            System.out.println("no se encuentra la imagen ");
//        }
//        Table table = new Table(11);
//        table.addCell(new Cell(1, 11).setTextAlignment(TextAlignment.CENTER).add(new Paragraph(nomEmpresa)));
//        table.addCell(new Cell(1, 11).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("TARJETA KARDEX")));
//        table.addCell(new Cell(1, 4).setTextAlignment(TextAlignment.LEFT).add(new Paragraph("Articulo: " + art)));
//        table.addCell(new Cell(1, 3).setTextAlignment(TextAlignment.LEFT).add(new Paragraph("Codigo: " + cod)));
//        table.addCell(new Cell(1, 4).setTextAlignment(TextAlignment.LEFT).add(new Paragraph("Metodo : Promedio ")));
//        table.addCell(new Cell(2, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("Fecha"))).addCell(new Cell(2, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("Detalle"))).addCell(new Cell(1, 3).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("ENTRADAS"))).addCell(new Cell(1, 3).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("SALIDAS"))).addCell(new Cell(1, 3).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("SALDOS")));
//        table.addCell("Cant").addCell("Vr/U").addCell("Total").addCell("Cant").addCell("Vr/U").addCell("Total").addCell("Cant").addCell("Vr/U").addCell("Total");
//        for (ControladorKardex kar : kars) {
//            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            String dateToStr = dateFormat.format(kar.kar1.getFecha());
//            table.addCell(new Cell().setTextAlignment(TextAlignment.LEFT).add(new Paragraph(dateToStr))).addCell(new Cell().setTextAlignment(TextAlignment.LEFT).add(new Paragraph(kar.kar1.getDetalle())));
//            celdas(table, kar.kar1.getCantidadEntrada(), kar.kar1.getValorUnitarioEntrada(), kar.kar1.getTotalEntrada());
//            celdas(table, kar.kar1.getCantidadSalida(), kar.kar1.getValorUnitarioSalida(), kar.kar1.getTotalSalida());
//            celdas(table, kar.kar1.getCantidadTotal(), kar.kar1.getValorUnitarioTotal(), kar.kar1.getTotalTotal());
//        }
//        doc.CrearPlantilla(PageSize.A4.rotate(),im,table);
//    }
//    public void celdas(Table table, Integer num, Double num2, Double num3) {
//        table.addCell(new Cell().setTextAlignment(TextAlignment.RIGHT).add(new Paragraph(Integer.toString(num))))
//                .addCell(new Cell().setTextAlignment(TextAlignment.RIGHT).add(new Paragraph(Double.toString(num2))))
//                .addCell(new Cell().setTextAlignment(TextAlignment.RIGHT).add(new Paragraph(Double.toString(num3))));
//    }
    public void tablaPDF() throws IOException {
        File file = new File("datos" + File.separatorChar +"facturas" + File.separatorChar + "Factura.pdf");
        //ControladorPlantillaPDF doc = new ControladorPlantillaPDF(pdf.getNombreUsuario(),pdf.getNombreArchivo());
        PdfWriter pdfW = new PdfWriter(file);
        PdfDocument docPDF = new PdfDocument(pdfW);
        Document document = new Document(docPDF, PageSize.A4);
        document.add(new Paragraph("Elaborado por: "));
        Table table = new Table(16);

        table.addCell(new Cell(1, 6).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("FACTURA")));

        table.addCell(new Cell(1, 4).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 2).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("34")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 4).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("  ")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        table.addCell(new Cell(1, 1).setTextAlignment(TextAlignment.CENTER).add(new Paragraph("GATO")));
        document.add(table);
        document.close();
    }

    public static void main(String[] args) {
        try {
            pa p = new pa();
            p.tablaPDF();
        } catch (IOException ex) {
            Logger.getLogger(pa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
