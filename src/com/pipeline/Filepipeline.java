package com.pipeline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Filepipeline {
	public void printResult(String resource, boolean append, String toFileName) {
		if (resource == null) {
			return;
		}
		File resultFile = new File(toFileName);
		if (!resultFile.exists()) {
			try {
				resultFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileWriter writer = null;
		try {
			writer = new FileWriter(resultFile, append);
			writer.write(resource + "\r\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
