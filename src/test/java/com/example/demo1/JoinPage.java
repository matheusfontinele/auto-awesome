package com.example.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoinPage {

    @FindBy(css = "div.enroll-join-hero")
    public WebElement imageJoinHero;

    public JoinPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
