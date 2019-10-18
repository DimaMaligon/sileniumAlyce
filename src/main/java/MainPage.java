import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage {


    private WebDriver driver;


    public MainPage (WebDriver driver) {

        this.driver = driver;
    }

    private By buttonFreeApples = By.xpath("//a[@class='btn btn-lg btn-success text-center free-apples']");
    private By buttonGrabApplesJonathan = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/section[1]/ul[1]/li[1]/div[1]/span[1]/button[1]");
    private By buttonGrabApplesAdrian = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/section[1]/ul[1]/li[2]/div[1]/span[1]/button[1]");
    private By buttonGrabApplesJulie = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/section[1]/ul[1]/li[3]/div[1]/span[1]/button[1]");
    private By heading = By.xpath("//div[@class='alert alert-flash alert-danger']");
    private By basket = By.xpath("//body/div[@class='container-fluid test-task']/div[@class='container']/div[@class='row']/div[2]");
    private By countApplesJonathan = By.xpath(".//section[1]/ul[1]/li[1]/div[1]/span[1]/span[1]");
    private By countApplesAdrian = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/section[1]/ul[1]/li[2]/div[1]/span[1]/span[1]");
    private By countApplesJulie = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/section[1]/ul[1]/li[3]/div[1]/span[1]/span[1]");




    public MainPage clickFreeApples () {

        driver.findElement(buttonFreeApples).click();


        return this;
    }

    public MainPage clickJonathan () {

        driver.findElement(buttonGrabApplesJonathan).click();


        return this;
    }

    public MainPage clickAdrian () {

        driver.findElement(buttonGrabApplesAdrian).click();

        return this;
    }

    public MainPage clickJulie () {

        driver.findElement(buttonGrabApplesJulie).click();

        return this;
    }

    public String getHeadText () {

        return driver.findElement(heading).getText();
    }

    public boolean getHeadTextDisplay () {

        return driver.findElement(heading).isDisplayed();
    }



    public int checkCountBasket () {

        List<WebElement> apples = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ul[1]/li[*]"));

        int count = apples.size();
        System.out.println(count);
        return count;
    }

    public int countApplesJonathan () {
        String textApplesCountJonathan = driver.findElement(countApplesJonathan).getText();

        int count = Integer.parseInt(textApplesCountJonathan);
        return count;
    }

    public int countApplesAdrian () {

        String textApplesCountAdrian = driver.findElement(countApplesAdrian).getText();


        int count = Integer.parseInt(textApplesCountAdrian);

        return count;
    }

    public int countApplesJulie () {
        String textApplesCountJulie = driver.findElement(countApplesJulie).getText();

        int count = Integer.parseInt(textApplesCountJulie);

        return count;
    }


 public ArrayList<String> applesJonathanHas () {
     List<WebElement> apples = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/section[1]/ul[1]/li[1]/div[2]/ul[1]")).findElements(By.xpath("li"));

     ArrayList<String> list = new ArrayList<>();

     for(int i = 0; i < apples.size(); i++){
         list.add(String.valueOf(apples.get(i).getText()));
     }

     return list;
    }

    public ArrayList<String> applesAdrianHas () {
        List<WebElement> apples = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/section[1]/ul[1]/li[2]/div[2]/ul[1]")).findElements(By.xpath("li"));

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < apples.size(); i++){
            list.add(String.valueOf(apples.get(i).getText()));
        }

        return list;
    }


}
