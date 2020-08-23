package test.AndreaDePaolis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {


    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/registro_svn/");

        driver.findElement(By.xpath("//*[@id=\"lg2\"]")).click();


        driver.findElement(By.xpath("//*[@id=\"sbc\"]/form/input[1]")).sendKeys("fab");
        driver.findElement(By.xpath("//*[@id=\"sbc\"]/form/input[2]")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"sbc\"]/form/input[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"flp\"]/div[1]/div[3]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[1]/input[2]")).sendKeys("Addition");
        driver.findElement(By.xpath("//*[@id=\"form2\"]/div[2]/textarea")).sendKeys(" Detailed explanation.Example1,Example2");
        driver.findElement(By.xpath("//*[@id=\"datepick2\"]")).sendKeys("20/07/2020");
        driver.findElement(By.xpath("//*[@id=\"form2\"]/button")).click();

        driver.close();
    }


}
