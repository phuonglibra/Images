package org.serenitybdd.images.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.serenitybdd.images.steps.serenity.ImageSteps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ImageDef {
	@Steps
	ImageSteps imgStep;

	@Given("^the page \"([^\"]*)\" is visited$")
	public void the_page_is_visited(String linkPage) throws Throwable {
		imgStep.openLinkVisit(linkPage);
	}

	@When("^capture image of \"([^\"]*)\" element and save as \"([^\"]*)\"$")
	public void capture_image_of_element_and_save_as(String element, String img)
			throws Throwable {
		try {
			FileUtils.copyFile(imgStep.captureElement(element), new File(img));
		} catch (IOException e) {

		}
	}

	@Then("^assert that image of \"([^\"]*)\" element and expected \"([^\"]*)\" image is similar$")
	public void assert_that_image_of_element_and_expected_image_is_similar(
			String element, String img) throws Throwable {
		// /imgStep.checkImg(element, img);
		Assert.assertTrue(imgStep.checkImg(element, img));
	}
}
