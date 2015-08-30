package com.themoffster.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {

	private FileReader reader;

	@Before
	public void setUp() {
		reader = new FileReader();
	}
	
	@Test
	public void getContents() throws IOException {
		reader.setFile(new File("src/test/resources/com/themoffster/util/sample.txt"));
		assertEquals("this is a file containing words",	reader.getFileContents());
	}

	@Test(expected=IOException.class)
	public void getContentsThrowsIOException() throws IOException {
		final FileReader mockedReader = spy(reader);
		when(mockedReader.getFile()).thenReturn(new File("src/test/resources/com/themoffster/util/this-should-not-be-found.txt"));
		mockedReader.getFileContents();
		fail();
	}
}
