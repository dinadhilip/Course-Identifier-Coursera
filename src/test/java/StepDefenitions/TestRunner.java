package StepDefenitions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
	@CucumberOptions(
			
		features= {"C:\\Users\\2303752\\eclipse-workspace\\CourcesIdentifier\\FeatureFile\\IdentifyCourse.feature"},
			glue="StepDefenitions",
			plugin= {"pretty",
					"html:reports/myReport.html",
					"rerun:target/rerun.txt"
					}
			)
				
			
	public class TestRunner {

	}
