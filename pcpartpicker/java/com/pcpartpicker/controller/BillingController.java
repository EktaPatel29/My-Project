package com.pcpartpicker.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcpartpicker.repository.BillingRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;


@Controller
public class BillingController {
	
	@Autowired
	BillingRepository billingRepo;

	@RequestMapping("/enterBill")
	
	public String index(){
		
	return "billing"; 
	
	}
	
	@RequestMapping(value="/loadReport")
	
	public byte[] exportResume( HttpServletRequest request)
			throws JRException {
		//String employeeName = getEmployeeName(emailId);
		byte[] byteArray;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
		JRDocxExporter jrDocxExporter = new JRDocxExporter();
		
		
		
		File reportFile = new File( request.getServletContext().getRealPath("/jasper/buyerDemo.jasper"));
        // If compiled file is not found, then compile XML template
//        if (!reportFile.exists()) {
//                   JasperCompileManager.compileReportToFile(request.getServletContext().getRealPath("/jasper/" + "resume" + ".jrxml"),request.getSession().getServletContext().getRealPath("/jasper/" + "resume" + ".jasper"));
//            }
         JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
		Map<String, Object> parameterMap = new HashMap<String, Object>();

	//	parameterMap.put("SUBREPORT_DIR", request.getSession().getServletContext().getRealPath("/jasper/"));
	//parameterMap.put("IMAGE_URL", request.getSession().getServletContext().getRealPath("/jasper/images/")+"rishabh-logo.jpg");
		
	
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
				parameterMap, new JREmptyDataSource());

		
		byteArray = JasperExportManager.exportReportToPdf(jasperPrint);
		System.out.println("Load the Report: "+byteArray);
		return byteArray;
	
		
	}
	/*@RequestMapping("/addBill")
	@ResponseBody
	
	public String addBill(int quantity,boolean per,double amount,String description) {
		billing b = null;
		try{
			b = new billing(quantity,per,amount,description);
			billingRepository.save(b);
		}
		catch(Exception ex){
			 return "Error creating the buyer: " + ex.toString();
			}
		return "Buyer succesfully created (id = " + b.getId() + ")";
	}  */


}