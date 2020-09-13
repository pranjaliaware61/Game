package com.springboot.rest.FirstRestApplication.service;

import static org.apache.commons.io.comparator.LastModifiedFileComparator.LASTMODIFIED_REVERSE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.rest.FirstRestApplication.model.FileDetails;

@Component
public class FileService {

	@Autowired
	FileDetails filedetails;
	// = new FileDetails();

	public void fetchModifiedFilesDesc(int number) throws IOException {
		File dir = new File(filedetails.getSrcLocation());
		File[] files = dir.listFiles();

		System.out.println("Inside fetchModifiedFilesDesc");

		if (files != null) {
			System.out.println("\nSort files in descending order base on last modification date");

			Arrays.sort(files, LASTMODIFIED_REVERSE);

			for (int i = 0; i < number; i++) {
				System.out.println("files[i]:" + files[i]);
				File file = files[i];
				System.out.println("file:" + file);

				File fTarget = new File(new File(filedetails.getDstLocation()), file.getName());
				copyFileUsingStream(file, fTarget);
				fTarget.setReadOnly();
			}

		}

	}

	private static void copyFileUsingStream(File source, File dest) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (Exception ex) {
			System.out.println("Unable to copy file:" + ex.getMessage());
		} finally {
			try {
				is.close();
				os.close();
			} catch (Exception ex) {
			}
		}
	}

}
