package com.study.java.nio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExampleFiles {
	
	public static void main(String[] args) throws IOException {

		FileSystem fileSystem = FileSystems.getDefault();
		for (FileStore store : fileSystem.getFileStores()) {
            System.out.println("드라이버명: " + store.name());
            System.out.println("파일시스템: " + store.type());
            System.out.println("전체 공간: " + store.getTotalSpace() + " 바이트");
            System.out.println("사용 중인 공간: " + (store.getTotalSpace() - store.getUnallocatedSpace()) + " 바이트");
            System.out.println("사용 가능한 공간: " + (store.getTotalSpace() - store.getUsableSpace()) + " 바이트");
            System.out.println();
        }
		System.out.println("파일 구분자: " + fileSystem.getSeparator());
        System.out.println();

        
		Path path = Paths.get("d:/tmp/contents.json");
		System.out.println(Files.exists(path) ? "File exists" : "File not exists");		
		if(Files.notExists(path)){
			Files.createFile(path);
		}
		
		System.out.println("디렉토리 여부: " + Files.isDirectory(path));
        System.out.println("파일 여부: " + Files.isRegularFile(path));
        System.out.println("마지막 수정 시간: " + Files.getLastModifiedTime(path));
        System.out.println("파일 크기: " + Files.size(path));
        System.out.println("소유자: " + Files.getOwner(path));
        System.out.println("숨김 파일 여부: " + Files.isHidden(path));
        System.out.println("읽기 가능 여부: " + Files.isReadable(path));
        System.out.println("쓰기 가능 여부: " + Files.isWritable(path));
		
		
		
		
	}
	
}
