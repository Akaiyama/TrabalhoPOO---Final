/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;
import mvc.model.Alimento;
import mvc.model.AlimentoDAO;


/**
 *
 * @author mb780
 */
public class GerarRelatorio {
    List<Pessoa> pessoas = new ArrayList();
    PessoaDAO pessoaDAO = new PessoaDAO();
    List<Alimento> alimentos = new ArrayList();
    AlimentoDAO alimentoDAO = new AlimentoDAO();
    
    public static final String RESULT = "reports/Relatorio.pdf";

    public static void main(String[] args)
        throws DocumentException, IOException {
       // List<pessoa> listp;
        GerarRelatorio a = new GerarRelatorio();
        a.createPdf(RESULT);
    }

    
    public void createPdf(String filename)
        throws DocumentException, IOException {
        
        Document document = new Document();
 
        PdfWriter.getInstance(document, new FileOutputStream(filename));
    
        document.open();
        
        Paragraph p = new Paragraph("RELATÓRIO DO TRABALHO");
        p.setAlignment(1);
        document.add(p);
        Paragraph authors = new Paragraph("Discentes: Ana Cristina e Maria Luísa Borges");
        p.setAlignment(1);
        document.add(authors);
        Paragraph title1 = new Paragraph("PESSOAS");
        p.setAlignment(1);
        document.add(title1);
        
        
        PdfPTable table = new PdfPTable(4);
        
        
        PdfPCell c1 = new PdfPCell(new Paragraph("ID"));
        PdfPCell c2 = new PdfPCell(new Paragraph("NOME"));
        PdfPCell c3 = new PdfPCell(new Paragraph("SEXO"));
        PdfPCell c4 = new PdfPCell(new Paragraph("NASCIMENTO"));
        
        table.addCell(c1);
        table.addCell(c2);
        table.addCell(c3);
        table.addCell(c4);
        
        pessoas = pessoaDAO.mostrarTodos(null);
        //criar for para acessar as pessoas (list no projeto parte 2)
        for (Pessoa p1 : pessoas) {
        
            c1 = new PdfPCell(new Paragraph(p1.getId() + ""));
            c2 = new PdfPCell(new Paragraph(p1.getNome()+ ""));
            c3 = new PdfPCell(new Paragraph(p1.getSexo()+ ""));
            c4 = new PdfPCell(new Paragraph(p1.getNascimento()+ ""));
            
            table.addCell(c1);
            table.addCell(c2);
            table.addCell(c3);
            table.addCell(c4);  
            
        }
        document.add(table);
       
        
        
        Paragraph title2 = new Paragraph("ALIMENTOS");
        p.setAlignment(1);
        document.add(title2);
        
        PdfPTable table2 = new PdfPTable(6);
        
        PdfPCell c5 = new PdfPCell(new Paragraph("ID"));
        PdfPCell c6 = new PdfPCell(new Paragraph("NOME"));
        PdfPCell c7 = new PdfPCell(new Paragraph("CAL"));
        PdfPCell c8 = new PdfPCell(new Paragraph("PROT"));
        PdfPCell c9 = new PdfPCell(new Paragraph("GORD"));
        PdfPCell c10 = new PdfPCell(new Paragraph("CARB"));
        
        
        table2.addCell(c5);
        table2.addCell(c6);
        table2.addCell(c7);
        table2.addCell(c8);
        table2.addCell(c9);
        table2.addCell(c10);
      
        alimentos = alimentoDAO.mostrarTodos(null);
        //criar for para acessar as pessoas (list no projeto parte 2)
        for (Alimento a1 : alimentos) {
        
            c5= new PdfPCell(new Paragraph(a1.getId() + ""));
            c6 = new PdfPCell(new Paragraph(a1.getNome()+ ""));
            c7 = new PdfPCell(new Paragraph(a1.getCalorias()+ ""));
            c8 = new PdfPCell(new Paragraph(a1.getProteinas()+ ""));
            c9 = new PdfPCell(new Paragraph(a1.getGorduras()+ ""));
            c10 = new PdfPCell(new Paragraph(a1.getCarboidratos() + ""));
            
             
            table2.addCell(c5);
            table2.addCell(c6);
            table2.addCell(c7);
            table2.addCell(c8);
            table2.addCell(c9);
            table2.addCell(c10);
            
        }
        document.add(table2);
        document.close();
       
   
    }
}