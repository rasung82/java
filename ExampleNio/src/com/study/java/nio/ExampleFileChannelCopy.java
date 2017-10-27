package com.study.java.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExampleFileChannelCopy {
	
	public static void main(String[] args) {
		String pwd = System.getProperty("user.dir");
		Path orig = Paths.get(String.format("%s/%s", pwd, "video.mp4"));
		Path dest = Paths.get(String.format("%s/%s", pwd, "copy-video.mp4"));
		
		FileChannel ofc = null;
		FileChannel dfc = null;
		
		try {
			ofc = FileChannel.open(orig, StandardOpenOption.READ );
			dfc = FileChannel.open(dest, StandardOpenOption.CREATE, StandardOpenOption.WRITE );
			
			ByteBuffer buffer = ByteBuffer.allocate(10240);
			
			int readCount = 0;
			while(true){
				buffer.clear();
				int size = ofc.read(buffer);
				readCount += size;
				System.out.println(String.format("%d(%d) / %d", readCount, size, ofc.size()));
				if(readCount >= ofc.size()){
					break;
				}
				
				buffer.flip();
				dfc.write(buffer);
			}
		} catch (IOException e) { 
			
		} finally {
			try {
				if(ofc!=null) ofc.close();
				if(dfc!=null) dfc.close();
			} catch (IOException e) {}
		}
	}

}
