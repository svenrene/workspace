package wbs.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo1 {
	public static void main(String[] args) {
//		String path1 = "resources/ocp_preparation/src/wbs";

		String path1 = "E:\\workspace\\ocp\\src\\wbs";
		String path2 = "E:\\workspace\\ocp\\resources\\io\\characterdata\\aNewFile.txt";
		String path3 = "E:\\workspace\\ocp\\resources\\io\\characterdata";
		File file1 = new File(path1);
		File file2 = new File(path2);
		File file3 = new File(path3);
		long lastModified;
		System.out.println(File.pathSeparator); // ;
		System.out.println(File.pathSeparatorChar); // ;
		System.out.println(File.separator); // \
		System.out.println(File.separatorChar); // \
		System.out.println(file1.isAbsolute()); // true
		System.out.println(file1.isDirectory()); // true
		System.out.println(file1.isHidden()); // false
		System.out.println(file1.isFile()); // false
		System.out.println(file1.canExecute()); // true
		System.out.println(file1.canRead()); // true
		System.out.println(file1.canWrite()); // true
		System.out.println(file1.length()); // 4096
		lastModified = file1.lastModified();
		System.out.println(new Date(lastModified)); // datum
		try {
			file2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			File.createTempFile("prefix", "suffix", file3);
			// prefix6885917375789059249suffix
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}