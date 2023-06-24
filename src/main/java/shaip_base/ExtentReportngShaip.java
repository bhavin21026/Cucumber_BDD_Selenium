package shaip_base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import shaip_utilitiescomponents.PropertiesOperationsShaip;


public class ExtentReportngShaip {
	
	static ExtentReports extent;

	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String reportPath = System.getProperty("user.dir")+
				"\\Shaip_Resources\\AutomationReports\\"+actualDate+".html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		
		 extent = new ExtentReports();
		 extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("ShaipCloud2.0 Automation Report");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("ShaipCloud2.0 QA Automation Report");
		
		extent.setSystemInfo("Executed on Environment: ", PropertiesOperationsShaip.getPropertyValueByKey("url"));
		extent.setSystemInfo("Executed on Browser: ", PropertiesOperationsShaip.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

		return extent;
	}


}
