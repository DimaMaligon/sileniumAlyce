import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPageTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;


    @Before
    public void setUp () {
        System.setProperty("WebDriver.Chrome.driver", "/usr/bin/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://hrtest.alycedev.com/");

        mainPage = new MainPage(driver);

        MainPage mainPageClickFreeButton = mainPage.clickFreeApples();


    }

    @Test

    public void grabAppleJonathan () throws InterruptedException {

        Thread.sleep(6000);

        MainPage mainPageClickJonathan = mainPage.clickJonathan();

        int nowCountBasktetJonathan = mainPageClickJonathan.countApplesJonathan();

        System.out.println(nowCountBasktetJonathan);

        Assert.assertEquals(1, nowCountBasktetJonathan);

    }


    @Test


    public void grabAppleAdrian () throws InterruptedException {
        Thread.sleep(6000);

        MainPage mainPageClickAdrian = mainPage.clickAdrian();

        int nowCountBasktetAdrian = mainPageClickAdrian.countApplesAdrian();

        System.out.println(nowCountBasktetAdrian);

        Assert.assertEquals(1, nowCountBasktetAdrian);

    }

    @Test

    public void grabAppleJulie () throws InterruptedException {

        Thread.sleep(6000);

        MainPage mainPageClickJulie = mainPage.clickJulie();

        int nowCountBasktetJulie = mainPageClickJulie.countApplesJonathan();

        System.out.println(nowCountBasktetJulie);

        Assert.assertEquals(1, nowCountBasktetJulie);

    }


    @Test

    public void checkButtonFreeApples () throws InterruptedException {

        for (int i = 1; i < 6; i++) {

            if (i == 1 || i == 3 || i == 5) {
                Thread.sleep(6000);
                MainPage mainPageClickJonathan = mainPage.clickJonathan();
            } else {
                Thread.sleep(6000);
                MainPage mainPageClickJulie = mainPage.clickJulie();
            }

        }

        MainPage mainPageClickFreeButton = mainPage.clickFreeApples();
        int currentCountBasket = mainPageClickFreeButton.checkCountBasket();
        int fullBasket = 5;



        Assert.assertEquals(currentCountBasket, fullBasket);


    }

    @Test

    public void CheckTimeBetweenClick () {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean b = true;

        MainPage mainPageClickAdrian1 = mainPage.clickAdrian();
        Date date1 = new Date();

        while (b) {
            MainPage mainPageClickAdrian2 = mainPage.clickAdrian();
            int currentCountBasket = mainPageClickAdrian2.countApplesAdrian();

            if (currentCountBasket >= 2) {
                b = false;
                break;
            }


        }


        Date date2 = new Date();

        int timeBetwenclick = (int) ((-date1.getTime() - (-date2.getTime())) / 1000);

        System.out.println(timeBetwenclick);


        Assert.assertEquals(60, timeBetwenclick);


    }

    @Test

    public void CheckUserHasOddApples () throws InterruptedException {
        Thread.sleep(6000);

        for (int i = 1; i < 6; i++) {
            if (i % 2 == 1) {
                MainPage mainPageClickJonathan = mainPage.clickJonathan();
                Thread.sleep(6000);
            }
            if (i % 2 == 0) {
                MainPage mainPageClickAdrian = mainPage.clickAdrian();
                Thread.sleep(6000);
            }
        }

        ArrayList<String> list = mainPage.applesJonathanHas();

Pattern pattern1 =Pattern.compile("Apple.*[135]");

        int countAppleOdd = 0;

        for (int i = 0; i < list.size(); i++) {   // check odd Apples
            Matcher matcher;

            if (list.get(0).matches(String.valueOf(pattern1))) {
                countAppleOdd++;
            }


        }

        Assert.assertEquals(3, countAppleOdd); // We know that there are 3 odd Apples

    }

    @Test

    public void CheckUserHasEvenApples () throws InterruptedException {
        Thread.sleep(6000);

        for (int i = 1; i < 6; i++) {
            if (i % 2 == 1) {
                MainPage mainPageClickJonathan = mainPage.clickJonathan();
                Thread.sleep(6000);
            }
            if (i % 2 == 0) {
                MainPage mainPageClickAdrian = mainPage.clickAdrian();
                Thread.sleep(6000);
            }
        }

        ArrayList<String> list = mainPage.applesAdrianHas();


        int countAppleEven = 0;
        Pattern pattern2 =Pattern.compile("Apple.*[246]");

        for (int i = 0; i < list.size(); i++) {   // check even Apples
            Matcher matcher;

            if (list.get(0).matches(String.valueOf(pattern2))) {
                countAppleEven++;
            }



        }

        Assert.assertEquals(2, countAppleEven); // We know that there are 2 even Apples

    }


    @After
    public void taarDown(){
        driver.quit();
    }


}



