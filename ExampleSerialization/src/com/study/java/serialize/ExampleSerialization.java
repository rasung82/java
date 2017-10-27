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
	 * transient 접근 제한자는 Object를 직렬화(serialize)하여 다른곳으로 전송하거나 객체를 저장할 때 
	 * transient 제한자가 적용된 변수는 저장되지 않는다.
	 * 
	 * transient 접근제한자는 오직 클래스변수에만 적용할 수 있으며, 지역변수에는 적용할 수 없습니다. static 변수에도 적용할수는 있지만 그 기능은 무시됩니다. 
	 * transient가 적용된 변수는 직렬화되진 않지만 writeObject(), readObject() 같은 커스텀 serialization을 통해 직렬화 할 수 있습니다.(?)
	 *
	 */
	protected transient float rho;
	protected transient float theta;
	
	
	@Override
	public String toString() {
		return String.format("x=%d, y=%d, rho=%f, theta=%f", x, y, rho, theta);
	}
	
}