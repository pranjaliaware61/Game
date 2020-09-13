package com.filerest;

import static org.apache.commons.io.comparator.LastModifiedFileComparator.LASTMODIFIED_REVERSE;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileServlet() {
	}

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("D:\\Source");
		boolean src_exist = FileExists(file);// check whether source location exists or not
		if (src_exist == true)
		{
			List<File> src_files = listSourceFiles(file);// fetching files and folders at source location
			File[] fetch_allfiles = AllFiles(src_files);// fetching all files,also within the folders
			Arrays.sort(fetch_allfiles, LASTMODIFIED_REVERSE);// sorting all files according to lastmodified date
			request.setAttribute("fiction", fetch_allfiles);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}

	}

	public boolean FileExists(File file) {
		boolean fileExists = file.exists();
		return fileExists;
	}

	public File[] AllFiles(List<File> list_file) {
		int count = 0;
		File[] allfiles = new File[list_file.size()];
		for (int i = 0; i < list_file.size(); i++) {
			File fetch = list_file.get(i);
			allfiles[count] = fetch;
			count++;
		}
		return allfiles;
	}

	public static List<File> listSourceFiles(File dirPath) {
		File[] srcLevelFiles = dirPath.listFiles();
		List<File> list_file = new ArrayList<File>();
		if (srcLevelFiles != null && srcLevelFiles.length > 0) {
			for (File aFile : srcLevelFiles) {
				if (aFile.isDirectory()) {
					List<File> list_file1 = listSourceFiles(aFile);
					list_file.addAll(list_file1);
				} else {
					list_file.add(aFile);

				}
			}
		}

		return list_file;
	}

	public void destroy() {
	}

}
