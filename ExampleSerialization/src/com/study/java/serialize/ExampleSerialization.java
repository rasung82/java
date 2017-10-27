package com.study.java.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ExampleSerialization {
	
	public static final String FILENAME = "data.ser";

	
	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point();
		p1.x = 10;
		p1.y = 20;
		p1.rho = 3.14F;
		p1.theta = 12.15F;
		
		try {
			writeObject(p1);
			p2 = (Point)readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(p1);
		System.out.println(p2);
	}
	
	
	public static void writeObject(Object o) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(FILENAME);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(o);

		fos.close();
		oos.close();
	}
	
	
	public static Object readObject() throws FileNotFoundException, ClassNotFoundException, IOException {
		FileInputStream fio = new FileInputStream(FILENAME);
		ObjectInputStream ois = new ObjectInputStream(fio);
		
		Object result = ois.readObject();
		fio.close();
		ois.close();
		
		return result;
	}

}


class Point implements Serializable {

	private static final long serialVersionUID = 4164989030597946873L;

	protected int x;
	protected int y;
	
	/*
	 * transient ���� �����ڴ� Object�� ����ȭ(serialize)�Ͽ� �ٸ������� �����ϰų� ��ü�� ������ �� 
	 * transient �����ڰ� ����� ������ ������� �ʴ´�.
	 * 
	 * transient ���������ڴ� ���� Ŭ������������ ������ �� ������, ������������ ������ �� �����ϴ�. static �������� �����Ҽ��� ������ �� ����� ���õ˴ϴ�. 
	 * transient�� ����� ������ ����ȭ���� ������ writeObject(), readObject() ���� Ŀ���� serialization�� ���� ����ȭ �� �� �ֽ��ϴ�.(?)
	 *
	 */
	protected transient float rho;
	protected transient float theta;
	
	
	@Override
	public String toString() {
		return String.format("x=%d, y=%d, rho=%f, theta=%f", x, y, rho, theta);
	}
	
}