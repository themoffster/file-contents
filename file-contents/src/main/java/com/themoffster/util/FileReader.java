package com.themoffster.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class FileReader {

	private File file;
	
	public File getFile() {
		return file;
	}

	public void setFile(final File file) {
		this.file = file;
	}

	public String getFileContents() throws IOException {
		final InputStream is = new FileInputStream(getFile());
		return IOUtils.toString(is);
	}
}
