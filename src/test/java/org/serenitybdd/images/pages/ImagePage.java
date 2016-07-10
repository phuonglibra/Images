package org.serenitybdd.images.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public class ImagePage extends PageObject {

	public WebElement getElement(String element) {

		return getDriver().findElement(getObject(element));
	}

	private By getObject(String element) {
		By by = null;
		try {
			if (element.startsWith("css=")) {
				element = element.substring(4);
				by = By.cssSelector(element);
				return by;
			}
		} catch (Exception e) {
			System.out.println("Canot find element: " + element);
		}
		return null;
	}
}
