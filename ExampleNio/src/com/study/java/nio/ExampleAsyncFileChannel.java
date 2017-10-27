package com.study.java.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleAsyncFileChannel {
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		String pwd = System.getProperty("user.dir");
		Path path = Paths.get(String.format("%s/%s", pwd, "test.dat"));
		
		try{
			AsynchronousFileChannel afc = AsynchronousFileChannel.open( path
					,EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ)
					,executorService);
			
			Charset charset = Charset.defaultCharset();
			ByteBuffer buffer = charset.encode("Who is DAS owner ?");
			Attachment attachment = new Attachment(path, afc);
			
			afc.write(buffer, 0, attachment, new CompletionHandler<Integer, Attachment>() {
				@Override
				public void completed(Integer result, Attachment attachment) {
					System.out.println(String.format("%s-completed", Thread.currentThread().getName()));
					if(attachment.afc!=null){
						try{
							attachment.afc.close();
						}catch(IOException ie){ }
					}
				}
	
				@Override
				public void failed(Throwable exc, Attachment attachment) {
					System.out.println(String.format("%s-failed", Thread.currentThread().getName()));
					if(attachment.afc!=null){
						try{
							attachment.afc.close();
						}catch(IOException ie){ }
					}
				}
			});
			
		}catch(IOException ie){ }
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ie) {}
		
		System.out.println("end...");
	}

}

class Attachment {
	Path path;
	AsynchronousFileChannel afc;
	
	public Attachment(Path path, AsynchronousFileChannel afc) {
		super();
		this.path = path;
		this.afc = afc;
	}

}
