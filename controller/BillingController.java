package com.pcpartpicker.controller;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import com.pcpartpicker.repository.BillingRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;


@RestController
public class BillingController {
	
	@Autowired
	BillingRepository billingRepo;

	
	
	@RequestMapping("/listofbuyers")
	public byte[] exportResume(String emailId, String format, HttpServletRequest request)
			throws JRException, SQLException {
	    Connection conn = getConnection();
		byte[] byteArray = null;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
		File reportFile = new File( request.getServletContext().getRealPath("/jasper/buyerDemo.jasper"));
       
         JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
		Map<String, Object> parameterMap = new HashMap<String, Object>();
	/*	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
				parameterMap, new JREmptyDataSource());*/
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, conn);

		byteArray = JasperExportManager.exportReportToPdf(jasperPrint);
		
	    return byteArray;
	}
	
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

}