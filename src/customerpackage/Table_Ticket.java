package customerpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;

import customerpackage.DBConnection;

/**
 * Servlet implementation class Table_Ticket
 */
@WebServlet("/Table_Ticket")
public class Table_Ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table_Ticket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream os = response.getOutputStream();
		  response.setContentType("application/pdf"); 
	 
		   

		   
	 
		  Document doc = new Document(PageSize.A7, 20, 20, 20, 20);
	     
		  String ticket_no = request.getParameter("ticket_no");
		  
			try(Connection con= DBConnection.getConnection()){
			PdfWriter.getInstance(doc, os);
	
	        PreparedStatement pst=con.prepareStatement("SELECT  employeenames,employeenumber,charge_to,phonenumber,complaint_date,ticket_no from customer  where ticket_no=? " );
	        pst.setString(1,ticket_no);
	        ResultSet rs=pst.executeQuery();
	        ResultSetMetaData rsmd = rs.getMetaData(); 
	        while(rs.next()){
	        	
	    
		 
		   doc.open();
		
		   Paragraph paragraph22 = new Paragraph();
		   paragraph22 = new Paragraph("CHAMS PLC TICKETING SYSTEM",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK));
		   paragraph22.setAlignment(Element.ALIGN_CENTER);
		   doc.add(paragraph22);
		   
		   Paragraph paragraph2 = new Paragraph();
		   paragraph2 = new Paragraph("Abere Osogbo. Osun State",FontFactory.getFont(FontFactory.TIMES_ROMAN,6,Font.BOLD,BaseColor.BLACK));
		   paragraph2.setAlignment(Element.ALIGN_CENTER);
		   doc.add(paragraph2);
		   
		    
		  
		    doc.add(new Paragraph(new Date().toString()));
		    
		    
		    Paragraph paragraph5 = new Paragraph();
			   paragraph5 = new Paragraph("COMPLAINT\n\n",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK));
			   paragraph5.setAlignment(Element.ALIGN_CENTER);
			   doc.add(paragraph5);

	    
		    doc.add(new LineSeparator());
		    LineSeparator sep = new LineSeparator();
		    sep.setOffset(2);
		    doc.add(sep);
     
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell = new PdfPCell(new Paragraph("Thank you"));
		cell.setColspan(2);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.GRAY);
		table.addCell(cell);
		
		
		 
	
		/*table.addCell("LH:");
		 
		/*patient_name,
		mobile_number,
		gender,
		marital_status,
		contact_address,
		bookappointment.patient_inst_id,
		test_name,
		department,
		amount,
		last_mod_ts*/
		 
		table.setSpacingBefore(3);	
	
		Paragraph paragraph11 = new Paragraph();
		   paragraph11 = new Paragraph("Names: " + rs.getString("employeenames"));
		   paragraph11.setAlignment(Element.ALIGN_JUSTIFIED);
		   doc.add(paragraph11);  
		   
		 
		 
		 doc.add( new Paragraph("Employeenumber: " + rs.getString("employeenumber")));
		doc.add( new Paragraph("Mobile: " + rs.getString("phonenumber")));
		doc.add( new Paragraph("Ticket ID: " + rs.getString("ticket_no")));
		doc.add( new Paragraph("Date: " + rs.getString("complaint_date")));
	
		//doc.add( new Paragraph("Hospital Name: " + rs.getString("hospital_name")));
		
		doc.add(table);
		
		
		doc.add(cell);
		
		   Paragraph paragraph32 = new Paragraph();
		   paragraph32 = new Paragraph("09053936474",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLACK));
		   paragraph32.setAlignment(Element.ALIGN_CENTER);
		   doc.add(paragraph32);
		
		Chunk linebreak2 = new Chunk(new DottedLineSeparator());
		   doc.add(linebreak2);
		  
	
			// rs.close();                                                                
			                                                             
			 
			   //con.close();                                                              
		                                               
			//   pst.close();                                                              
			 
		
		
		
		  
		  doc.close(); 
		  
		  
		  
		  
	  
	        }
			 
			  }catch(DocumentException e){
			   e.printStackTrace();
			  }
			  catch(Exception e){
			   e.printStackTrace();
			  } 

			}
		
		    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
