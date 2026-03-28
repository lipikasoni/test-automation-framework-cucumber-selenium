package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class RetryListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        result.setAttribute("retry", new RetryAnalyzer());
    }
}