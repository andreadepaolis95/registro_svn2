package test.TestStefanHuma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//La seguente Test visualizza i voti dell alunno Alberto di matematica
class testSelenum {
    public static void main(String[] args){
        System.out.println("Prova Selenium");
        System.setProperty("webdriver.chrome.driver","Drivers_chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/registro_svn/");
        driver.findElement(By.xpath("//*[@id=\"sbc\"]/form/input[1]")).sendKeys("alberto");
        driver.findElement(By.xpath("//*[@id=\"sbc\"]/form/input[2]")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"sbc\"]/form/input[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbar\"]/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"flp\"]/div[2]/form[8]/button")).click();

        WebElement TxtBoxContent = driver.findElement(By.xpath("//*[@id=\"flp\"]/div[3]/div"));
        System.out.println("Stampo: " + TxtBoxContent.getText());
        driver.close();
    }
}
