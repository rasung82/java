package com.study.java.nio;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ExampleByteBufferToString {
	
	public static void main(String[] args) {
		Charset charset = Charset.defaultCharset();
	
		// String -> ByteBuffer
		String s = "I'm your father";
		ByteBuffer buffer = charset.encode(s);
		
		// ByteBuffer -> String
		String p = charset.decode(buffer).toString();
		System.out.println(p);
	}

}
