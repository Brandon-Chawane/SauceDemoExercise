package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    //set directory
    public static String Report_Directory = System.getProperty("user.dir") + "/src/test/java/ExtentReports/ExtentReportManager.java";

    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;

    public static ExtentReports extentSetup() {

        extentReports = new ExtentReports();

        extentSparkReporter = new ExtentSparkReporter(new File(Report_Directory));
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setReportName("Sauce Extent Report");
        extentSparkReporter.config().setDocumentTitle("Extent Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports.setSystemInfo("OS", "os.name");
        extentReports.setSystemInfo("Execution Machine", System.getProperty("user.name"));

        return extentReports;

    }

}
