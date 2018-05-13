package com.baidu.www.quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Que {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fi = new File("D:"+File.separator+"Employee.txt");
		File fo = new File("dir");
		fo.mkdir();
		fo = new File("dir"+File.separator+"new.txt");
		InputStream is = null;
		OutputStream os = null;
		if(!fi.exists()){
			try {
				fi.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try{
			is = new FileInputStream(fi);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try {
			os = new FileOutputStream(fo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] temp = new byte[1024];
		int len = 0;
		try {
			while((len = is.read(temp))!=-1){
				os.write(temp, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		
	}

}
