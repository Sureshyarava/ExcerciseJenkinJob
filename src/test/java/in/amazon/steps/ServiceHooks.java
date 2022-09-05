package in.amazon.steps;

import in.amazon.common.TestBase;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

import java.net.MalformedURLException;


public class ServiceHooks {
    static TestBase testBase;

    @BeforeAll
    public static void openBrowser() throws MalformedURLException {
        testBase = new TestBase();
        testBase.initializeDriver();
    }

    @AfterAll
    public static void closeBrowser() {
        testBase.quitDriver();
    }
}
