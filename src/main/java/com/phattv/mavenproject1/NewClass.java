/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phattv.mavenproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Administrator
 */
public class NewClass {

    public static void main(String[] args) throws InterruptedException {
        //Test case - test the registration feature
        //Test procedures
        //1. Open a browser, chrome
        //2. Navigate to: https://phptravels.net/register
        //3. Fill all of information regarding to the user account
        // First name: Phat | Last name: Tran Vinh | Mobile: 033....
        // Email: khaphat128@gmail.com | password: 12345678
        //repass: 12345678
        //4. Click Sign-up button
        //5. Expected results: 
        //4.1 The system foward to a new page - the Main Menu page
        //5. The system show a  welcome message: Hi, Phat Tran
        testPHPTravelsRegistration();
    }

    public static void testPHPTravelsRegistration() throws InterruptedException {
        String driver = "chromedriver.exe";
        System.setProperty("webdriver.chrome.drive", driver);
        WebDriver myBrowser = new ChromeDriver();
        myBrowser.get("https://phptravels.net/register");
//        WebElement firstName=myBrowser.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[3]/div[1]/div/label/input"));
        //nói app test đợi trinh duyệt 1 xíu, cho control hiển thị xong
        //wait ở trong Test Automation
        Thread.sleep(5000);
        WebElement firstName = myBrowser.findElement(By.name("firstname"));
        firstName.sendKeys(("Phat"));
        myBrowser.findElement(By.name("lastname")).sendKeys("Tran");
        myBrowser.findElement(By.name("email")).sendKeys("khaphat128@gmail.com");
        myBrowser.findElement(By.name("phone")).sendKeys("0333332323");
        myBrowser.findElement(By.name("password")).sendKeys("12345678");
        myBrowser.findElement(By.name("confirmpassword")).sendKeys("12345678");
        myBrowser.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[8]/button")).click();

        Thread.sleep(5000);

        String message = myBrowser.findElement(By.tagName("h3")).getText();
        //in chuoi chào nếu thấy Hi, Phat Tran coi như chào đúng
        System.out.println("Welcome message: " + message);
    }

}
