package wbs.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

class MyFileFilter implements FileFilter {
	@Override
	public boolean accept(File pathname) {
		return pathname.length() >= 50 && pathname.length() <= 100;
	}
}

class MyFilenameFilter implements FilenameFilter {
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".java");
	}
}

public class FilterDemo {
	public static void main(String[] args) {
		// lösung mit hilfsklassen
		String path = "E:\\workspace\\ocp\\src\\wbs\\io";
		File dir = new File(path);
		File[] files = dir.listFiles(new MyFileFilter());
		for (File file : files) {
			System.out.println(file.getName());
		}
		files = dir.listFiles(new MyFilenameFilter());
		for (File file : files) {
			System.out.println(file.getName());
		}
		// lösung mit mit anonymen klassen
		files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.length() > 50 && pathname.length() < 100;
			}
		});
		files = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".ser");
			}
		});
	}
}