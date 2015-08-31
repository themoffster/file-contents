package com.themoffster.util.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import com.google.common.base.CharMatcher;
import com.themoffster.util.FileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FileContentsStepDefs {

	private FileReader reader;
	private String fileContents;
	private static final String BASE_PATH = "src/it/resources/com/themoffster/util/";

	@Given("^I have a text file containing text$")
	public void processTextFile() throws Throwable {
		final File file = new File(BASE_PATH + "non-empty-file.txt");
		reader = new FileReader(file);
	}

	@When("^I read the contents of the file$")
	public void readFileContents() throws Throwable {
		fileContents = reader.getFileContents();
	}

	@Then("^I should be returned a string which matches the file contents$")
	public void fileContentsShouldBeReadable() throws Throwable {
		assertEquals("this is a file containing words", fileContents);
	}

	@Given("^I have an empty text file$")
	public void processEmptyTextFile() throws Throwable {
		final File file = new File(BASE_PATH + "empty-file.txt");
		reader = new FileReader(file);
	}
	
	@Then("^I should be returned an empty string$")
	public void fileContentsShouldBeEmpty() throws Throwable {
		assertTrue(fileContents.isEmpty());
	}
	
	@Given("^I have a non text file$")
	public void processNonTextFile() throws Throwable {
		final File file = new File(BASE_PATH + "non-text-file.pdf");
		reader = new FileReader(file);
	}

	@Then("^I should get be returned a string which is not human readable$")
	public void returnedStringShouldNotBeHumanReadable() throws Throwable {
		//non-AASCI format means that the string isn't human readable
		assertFalse(CharMatcher.ASCII.matchesAllOf(fileContents));
	}
}
