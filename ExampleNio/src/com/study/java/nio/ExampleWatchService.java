package com.study.java.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/*
 * 와치 서비스는 자바 7에서 처음 소개된 것으로
 * 디렉토리 내부에서 파일 생성, 삭제, 수정 등의 내용 변화를 감시하는데 사용된다.
 * 
 * 와치 서비스는 일반적으로 파일 변경 통지 메커니즘으로 알려져 있습니다
 *
 */
public class ExampleWatchService extends Thread {
	
	@Override
	public void run() {
		try{
			System.out.println("WatchService start..");
			
			// WatchService 생성
			WatchService watcher = FileSystems.getDefault().newWatchService();
			
			// WatchService 등록(생성, 삭제, 수정)
			Path directory = Paths.get("d:/tmp");
			directory.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
			
			while(true){
				System.out.println("Waching...");
				WatchKey watchKey = watcher.take();
				System.out.println("Wake...");
				
				for(WatchEvent<?> watchEvent : watchKey.pollEvents()){
					Kind<?> kind = watchEvent.kind();
					Path path = (Path) watchEvent.context();
					if(kind == StandardWatchEventKinds.ENTRY_CREATE ){
						System.out.println("파일 생성 > " + path.getFileName());
					}else if(kind == StandardWatchEventKinds.ENTRY_DELETE){
						System.out.println("파일 삭제 > " + path.getFileName());
					}else if(kind == StandardWatchEventKinds.ENTRY_MODIFY){
						System.out.println("파일 수정 > " + path.getFileName());
					}else{
						
					}
				}
				
				if(!watchKey.reset()){
					break;
				}
			}
		} catch(InterruptedException ie){
			System.out.println("Occoured Interrupt exception");
		} catch(IOException ie){
			System.out.println("Occoured IO exception");
		}
		
		System.out.println("WatchService end..");
	}

	
	public static void main(String[] args) throws IOException {
		ExampleWatchService watchService = new ExampleWatchService();
		watchService.start();
	}

}
