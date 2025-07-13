package org.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.*;


import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	//public static JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public static void browserLaunch(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		//return driver;
		
	}
	
	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

	}
	
	public static  void urlLaunch(String url) {
		driver.get(url);
		
	}

	public static void implicitwait(long time) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}
	
	public static void getSize(WebElement e) {
		
		Dimension size = e.getSize();
	}
	public static void quit() {
		driver.quit();
	}
	public static String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}
	//WebElement
	public static void sendkeys(WebElement e, String value) {
		e.sendKeys(value);
	}
	public static void click(WebElement e) {
		e.click();
	}
	public static void clear(WebElement e) {
		e.clear();
	}
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	public static String getAttribute(WebElement e) {
		String att = e.getAttribute("value");
		return att;}
	
	public static boolean isEnabled(WebElement e) {
		boolean enable = e.isEnabled();
		return enable;
	}
	public static boolean isDisplayed(WebElement e) {
		boolean display = e.isDisplayed();
		return display;
	}
	public static boolean isSelected(WebElement e) {
		boolean select = e.isSelected();
		return select;
	}
	
	//Actions
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	}
	public static void contextClick(WebElement e) {
		Actions a=new Actions(driver);
		a.contextClick(e).perform();
	}
	public static void doubleClick(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e).perform();
	}
	public static void dragAndDrop(WebElement src, WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}
	//----select----
	public static void selectByIndex(WebElement e, int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	public static void selectByVisibleText(WebElement e,String text) {
		Select s=new Select(e);
		s.selectByVisibleText(text);
	}
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);
	}
	public static String getOption(WebElement e) {
		Select s=new Select(e);
		List<WebElement> op = s.getOptions();
		String text="";
		for(int i=0;i<op.size();i++) {
			WebElement w=op.get(i);
			text = w.getText();
			
			}
		return text;
	}	
	
	public static String getAllSelectedOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> all = s.getAllSelectedOptions();
		String text="";
		for(int i=0;i<all.size();i++) {
			WebElement w = all.get(i);
			text = w.getText();
		}
		return text;
	}
	public static String getFirstSelectedOPtion(WebElement e) {
		Select s=new Select(e);
	    WebElement first = s.getFirstSelectedOption();
		String text = first.getText();
		return text;
	}
	public static boolean isMultipe(WebElement e) {
		Select s=new Select(e);
		boolean multiple = s.isMultiple();
		return multiple;
	}
	public static void deselectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByValue(value);
	}
	public static void deselectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
	public static void deselectByVisibleText(WebElement e,String text) {
		Select s=new Select(e);
		s.deselectByVisibleText(text);
	}
	public static void deselectAll(WebElement e) {
		Select s=new Select(e);
		s.deselectAll();
	}
	
	//ScreenShot
	
	public static void screenShot(String filename) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
//		File des=new File("C:\\Users\\ADMIN\\eclipse-workspace\\MavenProject1\\src\\test\\resources\\ScreenShot"+filename+"_"+System.currentTimeMillis()+".png");
		File des=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ScreenShot"+filename+"_"+System.currentTimeMillis()+".png");
		FileUtils.copyFile(src, des);
	}
	//javascriptExecutor
	public static void jsSendkeys(WebElement e,String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+value+"')", e);		
	}
	public static String jsgetText(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String text = js.executeScript("return arguments[0].getAttribute('value')", e).toString();
		return text;
	}
	public static void scrollUp(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].ScrollIntoView(false)", e);
	}
	public static void scrollDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", e);
	}
	
	//frame
	public static void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	public static void frameByWebElement(WebElement e) {
		driver.switchTo().frame(e);
	}
	public static void frameByIdOrName(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	public static void getOutFrame() {
		driver.switchTo().defaultContent();
	}
	public static void parentFrame() {
		driver.switchTo().parentFrame();

	}
	//windows handling
	public static void windowHandle() {
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for(String eachId:allId) {
			if(!parentId.equals(eachId));{
				driver.switchTo().window(eachId);
			}
		}
	}
	
	public static void windowHandleList(int index) {
		Set<String> allId = driver.getWindowHandles();
		List<String> li=new LinkedList<String>();
		li.addAll(allId);
		driver.switchTo().window(li.get(index));
	}
	public static void windowHandlecount(int num) {
		Set<String> allId = driver.getWindowHandles();
		int count=1;
		for(String each:allId) {
			if(count==num) {
				driver.switchTo().window(each);
			}
			count++;
		}
	}
	//navigation
	public static void navigateTo(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	public static void backward() {
		driver.navigate().back();
	}
	public static void Forward() {
		driver.navigate().forward();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static boolean isDisplay(WebElement e) {
		boolean display = e.isDisplayed();
		return display;
	}
	public static boolean isEnable(WebElement e) {
		boolean enable = e.isEnabled();
		return enable;
	}
	public static boolean isSelect(WebElement e) {
		boolean select = e.isSelected();
		return select;		
	}
	
	//WebTable
	public static String particularRow(WebElement table, List<WebElement> row,int index) {
		WebElement w = row.get(index);
		String text = w.getText();
		return text;
	}
	public static String PrintAllRow(List<WebElement> row) {
		String text="";
		
		for(int i=0;i<row.size();i++) {
			WebElement w = row.get(i);
			text = w.getText();
			//break;			
			}
		return text;
	}
	public static String allRow(List<WebElement> row) {
		int count=0;
		//String text="";
		do {
			WebElement w = row.get(count);
			String text = w.getText();	
			count++;
			return text;
		}
		while(count<row.size());	
		//return text;
		}
	
	public static String printHeading(List<WebElement> head) {
	    String text="";
		for(int i=0;i<head.size();i++) {
			WebElement w = head.get(i);
			text = w.getText();
		}
		return text;
	}
	public static String printData(List<WebElement> data) {
		String text=" ";
		for(int i=0;i<data.size();i++) {
			WebElement w = data.get(i);
			text = w.getText();		
		}
		return text;
	}
	public static String lastRow(List<WebElement> row) {
		WebElement w = row.get(row.size()-1);
		String text = w.getText();
		return text;
	}
	public static String particularValue(List<WebElement> data,String value) {
		String text="";
		for(int i=0;i<data.size();i++) {
			WebElement w = data.get(i);
			text = w.getText();
			if(text.equalsIgnoreCase(value)) {
				break;
			}
		}
		return text ;
	}
//	public static String equalsIgnore(String value) {
//		String text="";
//		
//		if(text.equalsIgnoreCase(value)) {	
//			
//		}
//		return text;//}
	//robot
	
	public static void enterKey() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		}
	//excel 
	public static String excelRead(String filename, String sheetname,int row, int cell) throws IOException {
		File loc=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\"+filename+".xlsx");
		FileInputStream fs=new FileInputStream(loc);
		Workbook w= new XSSFWorkbook(fs);
		Sheet s = w.getSheet(sheetname);
		Row r= s.getRow(row);
		Cell c = r.getCell(cell);
		int type = c.getCellType();
		String value=null;
		if(type==1) {
			value = c.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy");
			value = sf.format(date);
			}
			else {
				double d = c.getNumericCellValue();
				long num=(long) d;
				value = String.valueOf(num);
		    }
	    }
		return value;
	}

	
	//Assert
	public static void asserttrue(String value) {
		Assert.assertTrue("verify url",driver.getCurrentUrl().contains(value));	
	}
	
	public static void assertequals(String message,String value,WebElement e) {
		Assert.assertEquals(message,value,e.getAttribute("value"));	
	}
	
	
	

}
