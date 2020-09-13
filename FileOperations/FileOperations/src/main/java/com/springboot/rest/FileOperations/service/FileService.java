package com.springboot.rest.FileOperations.service;

import static org.apache.commons.io.comparator.LastModifiedFileComparator.LASTMODIFIED_REVERSE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.springboot.rest.FileOperations.model.FileDetails;

@Component
public class FileService {

	@Autowired
	FileDetails filedetails;
	// = new FileDetails();

	@Value("${file.errorMessage}")
	String errorMessage;

	@Value("${file.successMessage}")
	String successMessage;

	@Value("${file.emptyMessage}")
	String emptyMessage;

	public String fetchModifiedFilesDesc(int number) throws IOException {

		System.out.println("-------------------------------------------");
		System.out.println("SourceLocation:" + filedetails.getSrcLocation());
		System.out.println("DestinationLocation:" + filedetails.getDstLocation());
		System.out.println("-------------------------------------------");

		File fTarget;
		int count = 0;
		if ((!filedetails.getSrcLocation().equals("")) && (!filedetails.getDstLocation().equals(""))) {
			if (!filedetails.getSrcLocation().equalsIgnoreCase(filedetails.getDstLocation())) {
				List<File> list_file = listDirectory(filedetails.getSrcLocation(), 0);
				System.out.println("Size of List:" + list_file.size());
				System.out.println("-----------------------FileInList-----------------------");
				File[] fiction = new File[list_file.size()];
				for (int i = 0; i < list_file.size(); i++) {
					File fetch = list_file.get(i);
					fiction[count] = fetch;
					System.out.println("fiction[" + count + "] :" + fiction[count]);
					count++;
				}

				Arrays.sort(fiction, LASTMODIFIED_REVERSE);

				System.out.println("-----------------------------------------------------");
				System.out.println("Following files are fetched to destination location");
				for (int i = 0; i < number; i++) {
					System.out.println(fiction[i]);
					File file = fiction[i];
					String parent = file.getParent();
					if (!filedetails.getSrcLocation().equalsIgnoreCase(parent)) {
						String parent_updated = parent.replace(filedetails.getSrcLocation(),
								filedetails.getDstLocation());
						System.out.println("updated parent:" + parent_updated);
						File directory = new File(parent_updated);
						if (!directory.exists()) {
							System.out.println(directory + " mkdir: " + directory.mkdirs());
						}
						fTarget = new File(new File(parent_updated), file.getName());

					} else {
						File directory = new File(filedetails.getDstLocation());
						if (!directory.exists()) {
							directory.mkdir();
						}
						fTarget = new File(new File(filedetails.getDstLocation()), file.getName());
					}
					copyFileUsingStream(file, fTarget);

					// fTarget.setReadOnly();
				}

			}
			return successMessage;
		} else {
			return errorMessage;
		}

	}

	public static List<File> listDirectory(String dirPath, int level) {
		File dir = new File(dirPath);
		File[] firstLevelFiles = dir.listFiles();

		System.out.println("-------------------------firstLevelFiles-------------------------");
		for (File s : firstLevelFiles) {
			System.out.println(s);
		}
		List<File> list_file = new ArrayList<File>();
		if (firstLevelFiles != null && firstLevelFiles.length > 0) {
			for (File aFile : firstLevelFiles) {
				for (int i = 0; i < level; i++) {
					System.out.print("\t");
				}
				if (aFile.isDirectory()) {
					System.out.println("[" + aFile.getName() + "]");
					List<File> list_file1 = listDirectory(aFile.getAbsolutePath(), level + 1);
					list_file.addAll(list_file1);
				} else {
					System.out.println(aFile.getName() + " present at path " + aFile.getAbsolutePath()
							+ " added to list: " + list_file.add(aFile));
					System.out.println("After each iteration list size is: " + list_file.size() + " "
							+ list_file.get(list_file.size() - 1));

				}
			}
		}

		return list_file;
	}

	public static void copyFileUsingStream(File source, File dest) {
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
