package com.rest.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileFetch")
public class FileFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Stream<Path> stream;
	private Stream<Path> stream1;
	private List<Path> ListDirectoriesFiles = new ArrayList<Path>();
	private List<Path> ListAllFiles = new ArrayList<Path>();
	Map<Path, FileTime> map = new HashMap<Path, FileTime>();
	Stack<Path> stack = new Stack<Path>();

	//Default Constructor
	public FileFetch() {
	}

	//init method
	public void init(ServletConfig config) throws ServletException {
	}

	//doPost method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	//doGet method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int number = 5;
		Path path = Paths.get("D:\\Source");
		boolean srcExist = SourceLocationExists(path);
		if (srcExist == true) {
			List<Path> fetchListDirectoriesFiles = ListAllDirectoriesFiles(path);//To list all files and directories at source location
			List<Path> fetchListAllFiles = AllFiles(fetchListDirectoriesFiles);//To list all files
			Map<Path, FileTime> fetchmap = createMap(fetchListAllFiles);//create map key=filename value=lastmodifiedtime
			Map<Path, FileTime> result = sortMap(fetchmap, number);//sorts the map using Linkedhashmap in ascending order and stores only last 5 modified files in result
			Stack<Path> temp=StackOperations(result);

			request.setAttribute("stack", temp);

			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);

		}

	}

	public boolean SourceLocationExists(Path path) {
		boolean srcExist = Files.exists(path);
		return srcExist;

	}

	public List<Path> ListAllDirectoriesFiles(Path path) throws IOException {
		//System.out.println(
			//	"---------------------------List of all directories and files inside source location---------------------------");
		stream = Files.list(path);
		ListDirectoriesFiles = stream.collect(Collectors.toList());
		/*for (Path p : ListDirectoriesFiles) {
			System.out.println(p);
		}*/
		return ListDirectoriesFiles;
	}

	public List<Path> AllFiles(List<Path> fetchListDirectoriesFiles) throws IOException {
		for (Path temp : fetchListDirectoriesFiles) {
			if (Files.isRegularFile(temp) == false) {
				stream1 = Files.list(temp);
				Files.getLastModifiedTime(temp);
				stream1.collect(Collectors.toCollection(() -> ListAllFiles));
			} else {
				ListAllFiles.add(temp);
			}
		}

		//System.out
			//	.println("---------------------------List of all files with modified date---------------------------");

		return ListAllFiles;
	}

	public Map<Path, FileTime> createMap(List<Path> fetchListAllFiles) throws IOException {
		for (int i = 0; i < fetchListAllFiles.size(); i++) {
			map.put(fetchListAllFiles.get(i), Files.getLastModifiedTime(fetchListAllFiles.get(i)));
		}
		return map;
	}

	public LinkedHashMap<Path, FileTime> sortMap(Map<Path, FileTime> fetchmap, int number) {
		int count = 0;
		List<Map.Entry<Path, FileTime>> capitalList = new LinkedList<>(fetchmap.entrySet());

		Collections.sort(capitalList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		int ans = capitalList.size() - number;
		LinkedHashMap<Path, FileTime> result = new LinkedHashMap<>();
		for (Map.Entry<Path, FileTime> entry : capitalList) {
			count++;
			//System.out.println("count:" + count);
			if (count > ans) {
				result.put(entry.getKey(), entry.getValue());
			}
		}

		return (LinkedHashMap<Path, FileTime>) result;
	}

	public Stack<Path> StackOperations(Map<Path, FileTime> result)
	{

		for (Entry<Path, FileTime> entry : result.entrySet()) {
			stack.push(entry.getKey());
		}
		//System.out.println("stack size:" + stack.size());

		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.println(stack.get(i));
			//stack.get(i).getFileName();
		}
		return stack;
	}
	
	public void destroy() {
		System.out.println("Inside destroy");
	}

}

/*
 * for (Path temp : fetchListDirectoriesFiles) { if (Files.isRegularFile(temp)
 * == false) { countD++; System.out.println("count of directory:" + countD);
 * stream1 = Files.list(temp); ListAllFiles =
 * stream1.collect(Collectors.toList());// overwrites each time
 * System.out.println("----" + ListAllFiles); L.addAll(ListAllFiles);
 * 
 * } else { countF++; System.out.println("count of file:" + countF);
 * L.add(temp); } }
 */
