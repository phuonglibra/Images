package org.serenitybdd.images.steps.serenity;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.serenitybdd.images.pages.ImagePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ImageSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImagePage imgPage;

	@Step
	public void openLinkVisit(String linkPage) {
		imgPage.openAt(linkPage);
	}

	@Step
	public File captureElement(String element) throws IOException {
		WebElement ele = imgPage.getElement(element);
		File screenshot = ((TakesScreenshot) getDriver())
				.getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);
		// Get the location of element on the page
		Point point = ele.getLocation();
		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		// Rectangle rect = new Rectangle(eleWidth, eleHeight);
		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(),
				point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		return screenshot;
	}

	@Step
	public boolean checkImg(String element, String img) {
		return (Boolean) null;
	}
}
