import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        Object testClass = tr.getInstance();
        if (testClass instanceof mainMethods) {
            ((mainMethods) testClass).screenshot("failure-" + tr.getName());
        }
    }
}
