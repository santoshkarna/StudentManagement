package com.santosh.studentinfosystems.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class ImageUtil {

	public static final String imageUploadPath = "C:/Users/user/Desktop/stuff/imageupload/";

	public static String writeImageToFile(String imageUrl, Part part) {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = part.getInputStream();
			out = new FileOutputStream(new File(imageUrl));
			int length;
			byte[] b = new byte[1024];
			while ((length = in.read(b)) != -1) {
				out.write(b, 0, length);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return imageUrl;
	}

	public static String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
