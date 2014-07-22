package com.zeroturnaround.rebelanswers.tests.functional;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(JUnit4.class)
public class SiteTest {

  private WebDriver driver;

  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName("chrome");
    driver = new RemoteWebDriver(capabilities);
  }

  @After
  public void tearDown() {
    driver.quit();
    driver = null;
  }

  @Test
  public void testIndex() {
    driver.get(System.getProperty("remoteUrl"));
    assertEquals("Rebel Answers - Questions", driver.getTitle());
  }
}