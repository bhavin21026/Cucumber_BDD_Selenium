package shaip_cucumberoptions;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;




@RunWith(Cucumber.class)
@CucumberOptions(features = { "src//test//java//shaip_features"}, 
glue ={"shaip_stepdefinations"},
//tags= "@one",
plugin  = {"pretty","json:target/cucumber.json","junit:target/cucumber.xml"},
monochrome=true,
publish = true

)

public class runCucumberTest_Junit {
	
	

}