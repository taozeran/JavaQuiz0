package com.baidu.www.quiz;

import java.io.*;
import java.util.*;

public class Que {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Employee> eList = new ArrayList<Employee>();

		// 文件复制
		System.out.println("-------------第二题--------------------");
		test2();

		// 文件读入集合
		System.out.println("-------------第三题--------------------");
		test3(eList);

		// 以工号为键，员工对象为值存入HashMap中.再使用entrySet遍历输出Map集合中的内容；
		System.out.println("-------------第四题--------------------");
		test4(eList);

		/*
		 * 当公司记录该信息的职员将信息交给经理，经理进行审查时，发现有一些信息录入错误，需要在集合中进行数据修改： ① *
		 * 将陈璐璐改为：张路路且工资改为：7500.0元(4分) ② 程曦原本是位女士(4分) ③工号中所有的2都应改为7(4分)
		 * 修改完成后更新所有集合中所有数据并打印
		 */
		System.out.println("-------------第五题--------------------");
		test5(eList);

		/*
		 * 将修改后的职工信息按工资从高到低排序，工资相同的按工号从小到大排序
		 */
		System.out.println("-------------第六题--------------------");
		test6(eList);

		/*
		 * 判断项目根目录下是否有result文件夹,如果没有,则用程序新建文件夹result,
		 * 并将修改并排序后的信息序列化到到result文件夹的Employee-new文件中, 并用反序列化的方式读取并打印信息
		 */
		System.out.println("-------------第七题--------------------");
		test7(eList);

		/*
		 * 编写客户端和服务器程序,通过客户端将dir文件夹下Employee.txt文件发送到服务器端,
		 * 存到项目下result文件夹中
		 * IP使用127.0.0.1
		 */
		synchronized(Employee.class);

	}

	public static void test7(ArrayList<Employee> eList) throws Exception {
		File f = new File("result" + File.separator + "Employee-new");
		File fParent = f.getParentFile();
		if (!fParent.exists()) {
			fParent.mkdirs();
		}
		f.createNewFile();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		for (Employee e : eList) {
			oos.writeObject(e);
			e::
		}
		oos.flush();
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		Employee e = null;

		try {
			while ((e = (Employee) ois.readObject()) != null) {
				System.out.println(e);
			}
			ois.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
		}

	}

	public static void test6(ArrayList<Employee> eList) throws Exception {
		// 方法1
		eList.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				// TODO Auto-generated method stub
				if (e1.getPay() > e2.getPay()) {
					return 1;
				} else if (e1.getPay() < e2.getPay()) {
					return -1;
				} else {
					return e1.getEmployeeNumber().compareTo(e2.getEmployeeNumber());
				}
			}

		});

		Iterator<Employee> iter = eList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		// 方法2
		TreeSet<Employee> tSet = new TreeSet<>();
		for (Employee e : eList) {
			tSet.add(e);
		}
		Iterator<Employee> iter1 = tSet.iterator();
		while (iter1.hasNext()) {
			System.out.println(iter1.next());
		}
	}

	public static void test5(ArrayList<Employee> eList) throws Exception {
		for (int i = 0; i < eList.size(); i++) {
			Employee e = eList.get(i);
			if (e.getName() == "陈璐璐") {
				e.setName("张路路");
				e.setPay(7500.0);
			}
			if (e.getName() == "程曦") {
				e.setGender(gender.female);
			}
			e.setEmployeeNumber(e.getEmployeeNumber().replaceAll("2", "7"));
		}
		System.out.println(eList);
	}

	public static void test4(ArrayList<Employee> eList) throws Exception {
		HashMap<String, Employee> map = new HashMap<String, Employee>();
		for (Employee e : eList) {
			map.put(e.getEmployeeNumber(), e);
		}

		Set<Map.Entry<String, Employee>> set = map.entrySet();
		Iterator<Map.Entry<String, Employee>> iter = set.iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Employee> entry = iter.next();
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

	public static void test3(ArrayList<Employee> eList) throws IOException {
		File f = new File("dir" + File.separator + "Employee.txt");
		BufferedReader input = null;
		input = new BufferedReader(new FileReader(f));
		String str = null;
		while ((str = input.readLine()) != null) {
			String[] s = str.split(",");
			eList.add(new Employee(s[0], s[1], s[2] == "男" ? gender.male : gender.female,
					Double.parseDouble(s[3].replaceAll("元", ""))));
		}
		input.close();
		Iterator<Employee> iter = eList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		// System.out.println(System.getProperty("file.encoding"));
	}

	public static void test2() {
		// 文件复制
		File fi = new File("D:" + File.separator + "Employee.txt");
		File fo = new File("dir" + File.separator + "Employee.txt");
		fo.mkdirs();

		try {
			InputStream is = null;
			OutputStream os = null;
			if (!fi.exists()) {
				fi.createNewFile();
			}
			is = new FileInputStream(fi);

			os = new FileOutputStream(fo);

			byte[] temp = new byte[1024];
			int len = 0;

			while ((len = is.read(temp)) != -1) {
				os.write(temp, 0, len);
			}
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
