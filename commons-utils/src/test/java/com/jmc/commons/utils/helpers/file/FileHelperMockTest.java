package com.jmc.commons.utils.helpers.file;

import com.jmc.commons.utils.AbstractMockTest;
import com.jmc.commons.utils.constants.message.MessageHelper;
import com.jmc.commons.utils.exceptions.FileException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * @author Jeremy MARTIN CATANI
 * @created 11/10/2021
 */
@PrepareForTest(value = {FileHelper.class})
public class FileHelperMockTest extends AbstractMockTest {

	private static final String IO_EXCEPTION_MESSAGE = "IOException for mocked test";
	private static final String PATH = ".\\";
	private static final String DIRNAME = "test";
	private static final String DIRNAME_1 = "test(1)";
	private static final String FILENAME = "test.txt";
	private static final String FILENAME_1 = "test(1).txt";
	private static final String PATH_DIRNAME = PATH + DIRNAME;
	private static final String PATH_DIRNAME_1 = PATH + DIRNAME_1;
	private static final String PATH_FILENAME = PATH + FILENAME;
	private static final String PATH_FILENAME_1 = PATH + FILENAME_1;
	private static final String PREFIX_HISTORIC_FILE = "1";

	public FileHelperMockTest() {
		AbstractMockTest.LOG = LoggerFactory.getLogger(FileHelperMockTest.class);
	}

	@Test
	public void createDirectoryIfNotExistMockTest() throws Exception {
		File mockedFile = Mockito.mock(File.class);
		Mockito.when(mockedFile.exists()).thenReturn(Boolean.FALSE);
		Mockito.when(mockedFile.getPath()).thenReturn(PATH_DIRNAME);
		Mockito.when(mockedFile.mkdirs()).thenReturn(Boolean.FALSE);
		PowerMockito.whenNew(File.class)
					.withParameterTypes(String.class)
					.withArguments(anyString())
					.thenReturn(mockedFile);
		try {
			FileHelper.createDirectoryIfNotExist(PATH_DIRNAME);
		} catch (FileException e) {
			assertEquals("Error message must be equals", MessageHelper.ERROR_CAN_NOT_CREATE_FILE, e.getMessage());
			assertEquals("Source must be equals", PATH_DIRNAME, e.getSource());
		}
	}

	@Test
	public void removeFileMockTest() throws Exception {
		File mockedFile = Mockito.mock(File.class);
		Mockito.when(mockedFile.exists()).thenReturn(Boolean.TRUE);
		Mockito.when(mockedFile.getPath()).thenReturn(PATH_FILENAME);
		PowerMockito.whenNew(File.class)
					.withParameterTypes(String.class)
					.withArguments(anyString())
					.thenReturn(mockedFile);
		try (MockedStatic<FileUtils> fileUtilsMockedStatic = Mockito.mockStatic(FileUtils.class)) {
			fileUtilsMockedStatic.when(() -> FileUtils.forceDelete(mockedFile))
								 .thenThrow(new IOException(IO_EXCEPTION_MESSAGE));
			try {
				FileHelper.remove(PATH_FILENAME);
			} catch (FileException e) {
				assertEquals("Error message must be equals", MessageHelper.ERROR_CAN_NOT_REMOVE_FILE, e.getMessage());
				assertEquals("Source must be equals", PATH_FILENAME, e.getSource());
			}
		}
	}

	@Test
	public void buildPathFilenameHistorizedMockTest() {
		PowerMockito.stub(PowerMockito.method(FileHelper.class, "countExistingFileByFilename", String.class, String.class, String.class, Boolean.class))
					.toReturn(1);
		String prefix = "1_";
		String expected = PATH + File.separator + prefix + DIRNAME + "(1)";
		String pathFilename = FileHelper.buildPathnameHistorized(Boolean.TRUE, DIRNAME, null, "1_", PATH);
		assertEquals("PathFilenames must be equals", expected, pathFilename);
	}

	@Test
	public void historizeDirectoryMockTest() throws Exception {
		File mockedDirectory = Mockito.mock(File.class);
		Mockito.when(mockedDirectory.exists()).thenReturn(Boolean.TRUE);
		Mockito.when(mockedDirectory.isDirectory()).thenReturn(Boolean.TRUE);
		Mockito.when(mockedDirectory.getPath()).thenReturn(PATH_DIRNAME);
		Mockito.when(mockedDirectory.getParent()).thenReturn(PATH);
		PowerMockito.stub(PowerMockito.method(FileHelper.class, "buildPathnameHistorized", Boolean.class, String.class, String.class, String.class, String.class))
					.toReturn(PATH_DIRNAME_1);
		PowerMockito.whenNew(File.class)
					.withParameterTypes(String.class)
					.withArguments(anyString())
					.thenReturn(mockedDirectory);
		try (MockedStatic<FileUtils> fileUtilsMockedStatic = Mockito.mockStatic(FileUtils.class)) {
			fileUtilsMockedStatic.when(() -> FileUtils.copyDirectory(mockedDirectory, new File(PATH_DIRNAME_1), Boolean.TRUE))
								 .thenThrow(new IOException(IO_EXCEPTION_MESSAGE));
			try {
				FileHelper.historize(PATH_DIRNAME, PREFIX_HISTORIC_FILE);
			} catch (FileException e) {
				assertEquals("Error message must be equals", MessageHelper.ERROR_CAN_NOT_COPY_FILE, e.getMessage());
				assertEquals("Source must be equals", PATH_DIRNAME, e.getSource());
				assertEquals("Destination must be equals", PATH_DIRNAME_1, e.getDestination());
			}
		}
	}

}
