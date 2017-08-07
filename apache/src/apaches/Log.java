package apaches;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log {
	 public static void main(String[] args) throws  IOException, Exception{
		 System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver.exe");
	    	ChromeDriver driver = new ChromeDriver();

         
         FileInputStream fsIP= new FileInputStream(new File("D:\\workspace\\apache\\login.xlsx")); //Read the spreadsheet that needs to be updated
           
         XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
           
         XSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
           
         Cell cell = null; // declare a Cell object
         
        // cell = worksheet.getRow(0).getCell(2);   // Access the second cell in second row to update the value
         //cell = worksheet.getRow(1).getCell(2);
        // cell.setCellValue("Login Success");  // Get current cell value value and overwrite the value
           
        // fsIP.close(); //Close the InputStream
          
         //FileOutputStream output_file =new FileOutputStream(new File("D:\\workspace\\apache\\login.xlsx"));  //Open FileOutputStream to write updates
           
         //wb.write(output_file); //write changes
           
         //output_file.close();  //close the stream   
         for (int i = 0; i<=1; i++) {
     		
      	   
 	    	driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

 	driver.findElement(By.xpath("//.//*[@id='identifierId']")).sendKeys(worksheet.getRow(i).getCell(0).getStringCellValue());
 	driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  //  String passwordvalue =worksheet.getRow(i).getCell(1).getStringCellValue();
    driver.findElement(By.xpath("//.//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(worksheet.getRow(i).getCell(1).getStringCellValue());
    driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    Thread.sleep(1000);
    WebElement wrng=driver.findElement(By.xpath("//.//*[@id='password']/div[2]/div[2]"));
 //  Thread.sleep(1000);
    String ro = wrng.getText();
    //Cell ro=worksheet.getRow(i).getCell(1);
    if(ro.equals("Wrong password. Try again.")){
    	cell = worksheet.getRow(i).getCell(2); 
     	cell.setCellValue("LoginN fail");
        
        fsIP.close(); //Close the InputStream
         
        FileOutputStream output_file1 =new FileOutputStream(new File("D:\\workspace\\apache\\login.xlsx"));  //Open FileOutputStream to write updates
          
        wb.write(output_file1); //write changes
    
     //   ro.createCell(3).setCellValue(cell1value);
        
    	
        
     
} else {
	driver.findElement(By.cssSelector(".gb_8a.gbii")).click();
	driver.findElement(By.cssSelector("#gb_71")).click();
	cell = worksheet.getRow(i).getCell(2); 
	cell.setCellValue("Login Success");
   
   fsIP.close(); //Close the InputStream
    
   FileOutputStream output_file =new FileOutputStream(new File("D:\\workspace\\apache\\login.xlsx"));  //Open FileOutputStream to write updates
     
   wb.write(output_file); //write changes
     
   output_file.close();
	
	Thread.sleep(1000);
        
}
   /* output_file1.close();
 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//.//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(worksheet.getRow(i).getCell(1).getStringCellValue());
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     Thread.sleep(1000);
     driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
  //   ro.createCell(3).setCellValue(cell1value);
     driver.findElement(By.cssSelector(".gb_8a.gbii")).click();
 	driver.findElement(By.cssSelector("#gb_71")).click();
 	cell = worksheet.getRow(i).getCell(2); 
 	cell.setCellValue("Login Success");
    
    fsIP.close(); //Close the InputStream
     
    FileOutputStream output_file =new FileOutputStream(new File("D:\\workspace\\apache\\login.xlsx"));  //Open FileOutputStream to write updates
      
    wb.write(output_file); //write changes
      
    output_file.close();
 	
 	Thread.sleep(1000);*/
 	
         
 
}
         driver.quit();
	 }}
