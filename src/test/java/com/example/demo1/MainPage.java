package com.example.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//span[text()='Join']")
    public WebElement joinButton;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
