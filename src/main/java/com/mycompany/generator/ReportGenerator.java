package com.mycompany.generator;

import ConnectBean.ConnectionProvider;
import ConnectBean.Provider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

// import com.mycompany.helper.* ;
// import com.mycompany.dbi.*;

public class ReportGenerator {
    
 public static void main(String[] args) {
  HashMap hm = null;
  // System.out.println("Usage: ReportGenerator ....");

  try {
   System.out.println("Start ....");
   // Get jasper report
   String jrxmlFileName =Provider.REPORT_PATH+ "C:/reports/C1_report.jrxml";
   String jasperFileName = Provider.REPORT_PATH+"\\Baocaochinhanh.jasper";
   String pdfFileName = "F:\\Duan\\Lab\\Report\\C1_report.pdf";

    ConnectionProvider provider=new ConnectionProvider();
    Connection con=provider.getCon();

   // Create arguments
   // Map params = new HashMap();
    hm = new HashMap();
  // hm.put("ID", "123");
   //hm.put("DATENAME", "April 2006");

   // Generate jasper print
   JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, hm, con);

   // Export pdf file
   JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
   
   System.out.println("Done exporting reports to pdf");
   
  } catch (Exception e) {
   System.out.print("Exceptiion" + e);
  }
 }
}