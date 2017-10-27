package com.study.java.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExampleFileChannel {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get(String.format("%s/%s", System.getProperty("user.dir"), "temp.dat"));
		FileChannel channel = FileChannel.open(path
				,StandardOpenOption.CREATE
				,StandardOpenOption.WRITE
				,StandardOpenOption.READ );
		
		Charset charset = Charset.defaultCharset();
		String data = "I'm your father";
		ByteBuffer buffer = charset.encode(data);
		int byteCount = channel.write(buffer);
		System.out.println(String.format("%d bytes written", byteCount));

		channel.position(0);
		ByteBuffer readBuffer = ByteBuffer.allocate(100);
		byteCount = channel.read(readBuffer);
		readBuffer.flip();
		data = charset.decode(readBuffer).toString();
		System.out.println(String.format("%d bytes read", byteCount));
		System.out.println(data);
	}

}

