package com.themoffster.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class FileReaderTest {

	@Autowired
	private FileReader reader;

	@Test
	public void checkConstructor() {
		final File file = reader.getFile();
		reader.setFile(file);
		assertEquals(file, reader.getFile());
	}
	
	@Test
	public void getContents() throws IOException {
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
