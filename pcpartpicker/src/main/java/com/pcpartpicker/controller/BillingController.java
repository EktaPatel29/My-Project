package com.pcpartpicker.controller;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pcpartpicker.repository.BillingRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;


@RestController
public class BillingController {
	
	@Autowired
	BillingRepository billingRepo;

	/*@RequestMapping("/listofbuyers")
	public static void main(String[] args) throws FileNotFoundException, JRException {
        JasperReport jasperReport = null;
        String path = "jasper/";
        JasperPrint jasperPrint = null;

        //Getting the connection object
        Connection conn = getConnection();

        //Provide path for your JRXML template.
        String templateName = path + "ReportSQL.jrxml";

        //Provide path for your final pdf file.
        String destinationFile = path + "ReportSQL.pdf";

        //Compiling the template.
        jasperReport = JasperCompileManager.compileReport(templateName);

        //Sending a parameter with the logged in user name as value
        HashMap parameters = new HashMap();

        // Filling the report template with data
        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

        //Sending a Complete print of the report.
        JasperPrintManager.printReport(jasperPrint, true);

        //Exporting it to an PDF
        JasperExportManager.exportReportToPdfFile(jasperPrint, destinationFile);

    }
  //Getting the JDBC Connection object to be used in the template.The data base used for the sample is MYSQL running on localhost at port 3306
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "amc";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        return conn;
		
    }
}*/	
	@RequestMapping("/listofbuyers")
	public byte[] exportResume(String emailId, String format, HttpServletRequest request)
			throws JRException {
	
		byte[] byteArray = null;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
		
		File reportFile = new File( request.getServletContext().getRealPath("/jasper/buyerDemo.jasper"));
       
         JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
				parameterMap, new JREmptyDataSource());
		byteArray = JasperExportManager.exportReportToPdf(jasperPrint);
		
	    return byteArray;
		
		
	}
}

/*@RequestMapping(value = "/displaypdf", method = RequestMethod.GET)
	//@Timed
	public @ResponseBody byte[] getOpenedEventsInPdf(HttpServletResponse response) {
	    response.setHeader("Content-Disposition", "inline; filename=file.pdf");
	    response.setContentType("application/pdf");
	// get file in bytearray from my custom service in backend
	    byte[] file = jasperReportsService.getOpenedEventsReport(ReportFormat.PDF);
	    return file;
	}
	*/

//}