package customerpackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Servlet implementation class CustomerExcelReportCalendar
 */
@WebServlet("/CustomerExcelReportCalendar")
public class CustomerExcelReportCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerExcelReportCalendar() {
        super();
        
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String form_date=request.getParameter("form_date");
    	String to_date=request.getParameter("to_date");
		try(Connection con= DBConnection.getConnection()){
		      Statement statement = con.createStatement();
		      ResultSet resultSet = statement
		      .executeQuery(" SELECT  * FROM customer WHERE DATE(complaint_date)  BETWEEN  '+DATE(form_date)+'    AND      '+DATE(to_date)+' ");
 
		 
		      XSSFWorkbook workbook = new XSSFWorkbook(); 
		      XSSFSheet spreadsheet = workbook.createSheet("CustomerExcelReport");
		      XSSFRow row=spreadsheet.createRow(0);
		      CreationHelper createHelper = workbook.getCreationHelper();
		    //  Row row =spreadsheet.create
		      //iterate rows to add numbers
		   /*    Iterator<Row> rowIterator = spreadsheet.rowIterator();
		       while (rowIterator.hasNext()){
		    	   Row row = (Row) rowIterator.next();
		       } */
		      
		      
		      XSSFCellStyle style2 = workbook.createCellStyle();
		      style2.setBorderLeft(XSSFCellStyle.BORDER_THICK );
		      style2.setBorderTop(XSSFCellStyle.BORDER_THICK);
		      style2.setBorderRight(XSSFCellStyle.BORDER_THICK);
		      style2.setBorderBottom(XSSFCellStyle.BORDER_THICK);
		      
		      
		      XSSFFont font =workbook.createFont();
		      font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
		      font.setFontHeightInPoints((short)10);
		      font.setBold(true);
		      style2.setFont(font);
		      
		      
		     XSSFCell cell;
		       
		   
		 
		     short rowNum = 0;
		     

		     row = spreadsheet.createRow(rowNum++);
		   
		     
		     cell=row.createCell(0);
		      cell.setCellValue("S/N");
		      cell.setCellStyle(style2);
		      
		      cell=row.createCell(1);
		      cell.setCellValue("EMPLOYEENAMES");
		      cell.setCellStyle(style2);
		      
		      cell=row.createCell(2);
		      cell.setCellValue("EMPLOYEENUMBER");
		      cell.setCellStyle(style2);
		      
		      cell=row.createCell(3);
		      cell.setCellValue("PHONE NUMBER");
		      cell.setCellStyle(style2);
		      
		      cell=row.createCell(4);
		      cell.setCellValue("CHARGE TO");
		      cell.setCellStyle(style2);
		      
		      cell=row.createCell(5);
		      cell.setCellValue("TICKET NO");
		      cell.setCellStyle(style2);
		      
		      cell=row.createCell(6);
		      cell.setCellValue("MESSAGE");
		      cell.setCellStyle(style2);
		      
		      cell=row.createCell(7);
		      cell.setCellValue("DATE");
		      cell.setCellStyle(style2);
		      
		       
		       
		     
		      int i=1;
		      
		      
		      
		      
		   // Style the cell with borders all around.
		     // CellStyle style = workbook.createCellStyle();
		      //style.setBorderBottom(CellStyle.BORDER_THIN);
		      //style.setBorderTop(CellStyle.BORDER_THICK);
		      
		     //CellStyle style = workbook.createCellStyle();
		      XSSFCellStyle style = workbook.createCellStyle();
		      style.setBorderLeft(XSSFCellStyle.BORDER_THIN );
		      style.setBorderTop(XSSFCellStyle.BORDER_THIN);
		      style.setBorderRight(XSSFCellStyle.BORDER_THIN);
		      style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		      
		      
		      
	  

		      
		      while(resultSet.next())
		      {
		         row=spreadsheet.createRow(i);
		         cell.setCellStyle(style);

		         cell=row.createCell(1);
		         
		         cell.setCellValue(resultSet.getString("employeenames"));
		         cell.setCellStyle(style);

		         cell=row.createCell(2);
		         cell.setCellValue(resultSet.getString("employeenumber"));
		         cell.setCellStyle(style);

		         cell=row.createCell(3);
		         cell.setCellValue(resultSet.getString("phonenumber"));
		         cell.setCellStyle(style);

		         cell=row.createCell(4);
		         cell.setCellValue(resultSet.getString("charge_to"));
		         cell.setCellStyle(style);

		         cell=row.createCell(5);
		         cell.setCellValue(resultSet.getString("ticket_no"));
		         cell.setCellStyle(style);

		         cell=row.createCell(6);
		         cell.setCellValue(resultSet.getString("message"));
		         cell.setCellStyle(style);

		         cell=row.createCell(7);
		         cell.setCellValue(resultSet.getString("complaint_date"));
		         cell.setCellStyle(style);

		         
		         
		         i++;
		         
		        
		         
		      }
		      
		      
		      
		     
		     
		     
		      FileOutputStream out = new FileOutputStream(
		      new File("employee.xls"));
		      
		      response.setContentType("application/vnd.ms-excel");
		       workbook.write(response.getOutputStream());
		       response.getOutputStream().close();
		 
		      System.out.println(
		      "exceldatabase.xls written successfully");
			    }
		
		      catch (Exception e ) {
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
