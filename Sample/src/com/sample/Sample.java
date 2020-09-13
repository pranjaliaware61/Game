package com.sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Sample {

	public static List<File> listDirectory(String dirPath, int level) {
		File dir = new File(dirPath);
		File[] firstLevelFiles = dir.listFiles();
		List<File> list_file = new ArrayList<File>();
		if (firstLevelFiles != null && firstLevelFiles.length > 0) {
			for (File aFile : firstLevelFiles) {
				for (int i = 0; i < level; i++) {
					System.out.print("\t");
				}
				if (aFile.isDirectory()) {
					System.out.println("[" + aFile.getName() + "]");
					System.out.println(aFile.getAbsolutePath());
					listDirectory(aFile.getAbsolutePath(), level + 1);
				} else {
					System.out.println(aFile.getName());
					list_file.add(aFile);

				}
			}
		}

		return list_file;
	}

	public static void main(String args[]) {
		/*
		 * File file = new File("D:\\Source");
		 * System.out.println("Source Location exists:" + file.exists());
		 */

		/*
		 * Path path = Paths.get("D:\\Source");
		 * System.out.println(Paths.get("D:\\Source")); if (Files.exists(path)) {
		 * System.out.println("Source Location is available"); } else {
		 * System.out.println("Source Location is not available"); }
		 */

		// check exists for file and directory
		// if (Files.exists(path)) {
		/*
		 * String str = "abc"; String strr = str.replace('a', 'p');
		 * System.out.println(strr); String location =
		 * "E:\\Source\\Directory\\File11.txt"; System.out.println(location); //
		 * location.split(\\);
		 * 
		 * File theFile = new File(location); String parent = theFile.getParent();
		 * System.out.println("parent:" + parent);
		 * 
		 * File directory = new File(location); System.out.println(directory);
		 * directory.mkdir();
		 */

		/*
		 * List<File> list_file = listDirectory("D:\\Source", 0);
		 * System.out.println(list_file); Arrays.sort(list_file.toArray(),
		 * LASTMODIFIED_REVERSE);
		 */

	}

}
