package com.jmc.commons.utils.helpers.file;

import com.jmc.commons.utils.AbstractFinalClassHelperTest;
import com.jmc.commons.utils.constants.message.MessageHelper;
import com.jmc.commons.utils.exceptions.FileException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jeremy MARTIN CATANI
 * @created 10/10/2021
 */
public class FileHelperTest extends AbstractFinalClassHelperTest {

	private static final String PATH = ".\\";
	private static final String DIRNAME = "test";
	private static final String DIRNAME_1 = "1_test";
	private static final String FILENAME = "test.txt";
	private static final String PATH_DIRNAME = PATH + DIRNAME;
	private static final String PATH_DIRNAME_1 = PATH + DIRNAME_1;
	private static final String PATH_FILENAME = PATH + FILENAME;
	private static final String PREFIX_HISTORIC_FILE = "1";

	private void removeTestFiles() {
		File[] files = new File(PATH).listFiles(new FileFilter() {
			@Override
			public boolean accept(final File pathname) {
				return pathname.getName().contains("test");
			}
		});
		if (Objects.nonNull(files)) {
			for (File file : files) {
				FileHelper.remove(file.getPath());
			}
		}
	}

	@Override
	protected void setClassToTest() {
		CLASS_TO_TEST = FileHelper.class;
	}

	@BeforeEach
	@Override
	public void beforeEach(final TestInfo testInfo) {
		super.beforeEach(testInfo);
		removeTestFiles();
	}

	@Order(value = 1)
	@Test
	public void createDirectoryIfNotExistTest() {
		File test = new File(PATH_DIRNAME);
		assertFalse(test.exists(), "Test directory must not be existing");
		FileHelper.createDirectoryIfNotExist(PATH_DIRNAME);
		assertTrue(test.exists(), "Test directory must be existing");
		FileHelper.remove(PATH_DIRNAME);
		assertFalse(test.exists(), "Test directory must not be existing");
	}

	@Order(value = 2)
	@Test
	public void countExistingFileByFilenameTest() {
		int count = FileHelper.countExistingFileByFilename("./test2", "", "test.txt", Boolean.FALSE);
		assertEquals(0, count, "Count must be equals");
	}

	@Order(value = 3)
	@Test
	public void historizeTest() {
		File test = new File(PATH_DIRNAME);
		assertFalse(test.exists(), "Test directory must not be existing");
		FileHelper.createDirectoryIfNotExist(PATH_DIRNAME);
		assertTrue(test.exists(), "Test directory must be existing");
		FileHelper.historize(PATH_DIRNAME, PREFIX_HISTORIC_FILE);
		assertFalse(test.exists(), "Test directory must not be existing");
		test = new File(PATH_FILENAME);
		assertFalse(test.exists(), "Test file must not be existing");
		boolean createdFile = Boolean.FALSE;
		try {
			createdFile = test.createNewFile();
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			removeTestFiles();
		}
		assertTrue(createdFile, "Test file must be existing");
		FileHelper.historize(PATH_FILENAME, PREFIX_HISTORIC_FILE);
		assertFalse(test.exists(), "Test file must not be existing");
		removeTestFiles();
		test = new File(PATH_DIRNAME_1);
		try {
			FileHelper.historize(PATH_DIRNAME_1, PREFIX_HISTORIC_FILE);
		} catch (FileException e) {
			assertEquals(MessageHelper.ERROR_FILE_NOT_EXIST, e.getMessage(), "Exception message must be equals");
			assertEquals(test.getPath(), e.getSource(), "Exception source must be equals");
		}
	}

}
