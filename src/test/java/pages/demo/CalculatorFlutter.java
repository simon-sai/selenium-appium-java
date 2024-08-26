package pages.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.abstractclass.AbstractAndroid;

public class CalculatorFlutter extends AbstractAndroid {

    protected By resultXPath = By.xpath("//android.widget.EditText[@content-desc=\"Calculator input field\"]");
    protected By minusXpath = By.xpath("//android.widget.Button[@content-desc=\"Minus\"]");
    protected By plusXpath = By.xpath("//android.widget.Button[@content-desc=\"Plus\"]");
    protected By equalXpath = By.xpath("//android.widget.Button[@content-desc=\"Equal\"]");
    protected By clearXpath = By.xpath("//android.widget.Button[@content-desc=\"Clear\"]");

    public CalculatorFlutter() {
        super();
    }

    @Override
    protected String appPackage() {
        return "com.example.simplistic_calculator";
    }

    @Override
    protected String mainActivity() {
        return ".MainActivity";
    }

    public CalculatorFlutter clickNumber(String buttonText) {
        By button = this.byText(buttonText);
        this.clickElement(button);
        return this;
    }

    public CalculatorFlutter clickPlus() {
        By button = this.byText("+");
        this.clickElement(button);
        return this;
    }

    public CalculatorFlutter clickEqual() {
        By button = this.byText("=");
        this.clickElement(button);
        return this;
    }

    public CalculatorFlutter clickMinus() {
        this.clickElement(this.minusXpath);
        return this;
    }

    public CalculatorFlutter clickClear() {
        this.clickElement(this.clearXpath);
        return this;
    }

    public CalculatorFlutter verifyResult(String result) {
        WebElement element = this.findElement(this.resultXPath);
        this.elementAssert.HasText(element, result);
        return this;
    }
}
