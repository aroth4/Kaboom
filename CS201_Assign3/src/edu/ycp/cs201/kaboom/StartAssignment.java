package edu.ycp.cs201.kaboom;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class StartAssignment {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Copy files from CS201_Assign2 (yes/no)? ");
		String response = keyboard.nextLine();
		if (response == null || !response.toLowerCase().equals("yes")) {
			System.out.println("OK, exiting");
			return;
		}
		
		final String[] files = {
				"src/edu/ycp/cs201/kaboom/Point.java",
				"src/edu/ycp/cs201/kaboom/Circle.java",
				"src/edu/ycp/cs201/kaboom/Rectangle.java",
				"junit/edu/ycp/cs201/kaboom/PointTest.java",
				"junit/edu/ycp/cs201/kaboom/CircleTest.java",
				"junit/edu/ycp/cs201/kaboom/RectangleTest.java",
		};
		
		int numErrors = 0;
		for (String file : files) {
			try {
				InputStream in = null;
				OutputStream out = null;
				
				try {
					in = read(file);
					out = write(file);
					copy(in, out);
					System.out.println("Copied " + file + "...");
				} finally {
					closeQuietly(in);
					closeQuietly(out);
				}
			} catch (IOException e) {
				System.err.println("Error copying " + file.substring(file.lastIndexOf('/') + 1) + ": " + e.getMessage());
				numErrors++;
			}
		}
		
		if (numErrors == 0) {
			System.out.println("All files copied successfully (don't forget to refresh the project)");
		}
	}

	private static InputStream read(String file) throws FileNotFoundException {
		return new BufferedInputStream(new FileInputStream("../CS201_Assign2/" + file));
	}

	private static OutputStream write(String file) throws FileNotFoundException {
		return new BufferedOutputStream(new FileOutputStream(file));
	}

	private static void copy(InputStream in, OutputStream out) throws IOException {
		byte[] buf = new byte[4096];
		while (true) {
			int n = in.read(buf);
			if (n < 0) {
				break; // end of input file
			}
			out.write(buf, 0, n);
		}
	}

	private static void closeQuietly(Closeable obj) {
		if (obj != null) {
			try {
				obj.close();
			} catch (IOException e) {
				// ignore
			}
		}
	}
}
