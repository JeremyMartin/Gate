package com.jmc.commons.utils.helpers.file;

import com.jmc.commons.utils.constants.message.MessageHelper;
import com.jmc.commons.utils.exceptions.FileException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * This class consists of static utility files
 *
 * @author Jeremy MARTIN CATANI
 * @created 09/10/2021
 */
public class FileHelper {

	private static final Logger LOG = LoggerFactory.getLogger(FileHelper.class);
	public static final String PATTERN_PREFIX = "yyyy_MM_dd_HH_mm_ss_SSS";
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(PATTERN_PREFIX);

	/**
	 * Generate directory if not exist
	 *
	 * @param pathname A directory pathname, not blank
	 * <p>
	 * pathname can recursive
	 * </p>
	 *
	 * @throws FileException if it can't be created
	 */
	public static void createDirectoryIfNotExist(@NotBlank final String pathname) {
		File file = new File(pathname);
		if (!file.exists()) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Create directory {}", pathname);
			}
			if (!file.mkdirs()) {
				throw new FileException(MessageHelper.ERROR_CAN_NOT_CREATE_FILE, pathname);
			}
		}
	}

	/**
	 * Remove file or directory
	 *
	 * @param pathname A pathname, not blank
	 *
	 * @throws FileException if it can't be deleted
	 */
	public static void remove(@NotBlank final String pathname) {
		File file = new File(pathname);
		if (file.exists()) {
			try {
				FileUtils.forceDelete(file);
			} catch (IOException ex) {
				LOG.error(ex.getMessage(), ex);
				throw new FileException(MessageHelper.ERROR_CAN_NOT_REMOVE_FILE, pathname);
			}
		}
	}

	/**
	 * Generate {@link FileFilter} to count existing
	 *
	 * @param prefixHistoricFile prefix historic, not blank
	 * @param filename filename to be checked, not blank
	 * @param withDirectory is a directory to check, not null
	 *
	 * @return new fileFilter depending on the conditions
	 */
	private static FileFilter getFilterForCountExisting(@NotBlank final String prefixHistoricFile,
														@NotBlank final String filename,
														@NotNull final Boolean withDirectory) {
		return pathname -> {
			String name = pathname.getName();
			if (withDirectory) {
				return pathname.isDirectory() && name.contains(prefixHistoricFile) && name.contains(filename);
			} else {
				return pathname.isFile() && name.contains(prefixHistoricFile) && name.contains(filename);
			}
		};
	}

	/**
	 * Count existing file with the same name
	 *
	 * @param parent parent pathname, not blank
	 * @param prefixHistoryFile prefix historic, not blank
	 * @param filename filename to be checked, not blank
	 * @param isDirectory is a directory, not null
	 *
	 * @return number of files who have the same name
	 */
	public static int countExistingFileByFilename(@NotBlank final String parent,
												  @NotBlank final String prefixHistoryFile,
												  @NotBlank final String filename,
												  @NotNull final Boolean isDirectory) {
		File parentDir = new File(parent);
		if (parentDir.exists()) {
			File[] files = parentDir.listFiles(getFilterForCountExisting(prefixHistoryFile, filename, isDirectory));
			if (Objects.nonNull(files)) {
				return files.length;
			}
		}
		return 0;
	}

	/**
	 * Generate historized pathname
	 *
	 * @param isDirectory is a directory, not null
	 * @param filename filename to be checked, not blank
	 * @param extension filename extension without dot, nullable
	 * @param prefixHistoricFile prefix historic, not blank
	 * @param parentPathname parent pathname, not blank
	 *
	 * @return file or directory pathname historized
	 */
	public static String buildPathnameHistorized(@NotNull final Boolean isDirectory,
												 @NotBlank final String filename,
												 @Nullable final String extension,
												 @NotBlank final String prefixHistoricFile,
												 @NotBlank final String parentPathname) {
		int count = countExistingFileByFilename(parentPathname, prefixHistoricFile, filename, isDirectory);
		String pathFilename = parentPathname + File.separator + prefixHistoricFile + FilenameUtils.removeExtension(filename);
		if (count > 0) {
			pathFilename += "(" + count + ")";
		}
		if (!isDirectory & Objects.nonNull(extension)) {
			pathFilename = pathFilename + "." + extension;
		}
		return pathFilename;
	}

	/**
	 * Historize file or directory
	 *
	 * @param pathFilename file pathname to be historized, not blank
	 * @param prefixHistoricFile prefix historic, not blank
	 */
	public static void historize(@NotBlank final String pathFilename, @NotBlank final String prefixHistoricFile) {
		File file = new File(pathFilename);
		if (file.exists()) {
			String filename = file.getName();
			String pathname = buildPathnameHistorized(file.isDirectory(), filename, FilenameUtils.removeExtension(filename), prefixHistoricFile, file.getParent());
			try {
				if (file.isDirectory()) {
					FileUtils.copyDirectory(file, new File(pathname), Boolean.TRUE);
				} else {
					FileUtils.copyFile(file, new File(pathname), Boolean.TRUE);
				}
				remove(file.getPath());
			} catch (IOException e) {
				LOG.error(e.getMessage(), e);
				throw new FileException(MessageHelper.ERROR_CAN_NOT_COPY_FILE, file.getPath(), pathname);
			}
		} else {
			LOG.warn("File not exist {}", file.getPath());
			throw new FileException(MessageHelper.ERROR_FILE_NOT_EXIST, file.getPath());
		}
	}

	private FileHelper() {}

}
