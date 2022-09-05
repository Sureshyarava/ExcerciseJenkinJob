package in.amazon.common;


import in.amazon.browserfactory.Browser;
import in.amazon.browserfactory.WebBrowsers;

import java.net.MalformedURLException;


public class TestBase extends Browser {

    public void initializeDriver() throws MalformedURLException {
        Browser browser = new Browser();
        browser.selectBrowser(WebBrowsers.CHROME);
    }

    public void quitDriver() {
        driver.quit();
    }

}
