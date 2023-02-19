package assertions;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {

    protected WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement element){
        return new WebElementAssert(element);
    }

    public WebElementAssert isDisplayed(){
        isNotNull();
        if(!actual.isDisplayed()){
            failWithMessage("Expected element to be displayed, but is not...!");
        }
        return this;
    }

    public WebElementAssert isEnabled(){
        isNotNull();
        if(!actual.isDisplayed()){
            failWithMessage("Expected element to be enabled, but is not...!");
        }
        return this;
    }

    public WebElementAssert isButton(){
        isNotNull();
        boolean isButton = actual.getTagName().equalsIgnoreCase("button") || actual.getAttribute("type").equalsIgnoreCase("button");
        if(!isButton){
            failWithMessage("Expected element to be button, but is not...!");
        }
        return this;
    }

    public WebElementAssert hasAttributeValue(String attribute, String expectedValue){
        isNotNull();
        var actualValue = actual.getAttribute(attribute);
        if(!actualValue.equalsIgnoreCase(expectedValue )){
            failWithMessage("Expected element to have attribute <%s> value as <%s>. But it was <%s>", attribute, expectedValue, actualValue);
        }
        return this;
    }
}
