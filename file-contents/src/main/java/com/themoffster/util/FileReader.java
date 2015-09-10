package com.themoffster.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

/**
 * Simple class which will allow the reading of the contents of the file
 * variable belonging to this class.
 * 
 * @author themoffster
 *
 */
public class FileReader {

    /**
     * The File which we will get the contents of.
     */
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(final File file) {
        this.file = file;
    }

    /**
     * Gets the contents of the current file in String format.
     * 
     * @return The String representation of the contents of the file
     * @throws IOException
     */
    public String getFileContents() throws IOException {
        final InputStream is = new FileInputStream(getFile());
        return IOUtils.toString(is);
    }
}
