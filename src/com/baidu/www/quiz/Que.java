package com.baidu.www.quiz;

import java.io.*;
import java.util.*;

public class Que {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Employee> eList = new ArrayList<Employee>();

		// �ļ�����
		System.out.println("-------------�ڶ���--------------------");
		test2();

		// �ļ����뼯��
		System.out.println("-------------������--------------------");
		test3(eList);

		// �Թ���Ϊ����Ա������Ϊֵ����HashMap��.��ʹ��entrySet�������Map�����е����ݣ�
		System.out.println("-------------������--------------------");
		test4(eList);

		/*
		 * ����˾��¼����Ϣ��ְԱ����Ϣ������������������ʱ��������һЩ��Ϣ¼�������Ҫ�ڼ����н��������޸ģ� �� *
		 * �����贸�Ϊ����··�ҹ��ʸ�Ϊ��7500.0Ԫ(4��) �� ����ԭ����λŮʿ(4��) �۹��������е�2��Ӧ��Ϊ7(4��)
		 * �޸���ɺ�������м������������ݲ���ӡ
		 */
		System.out.println("-------------������--------------------");
		test5(eList);

		/*
		 * ���޸ĺ��ְ����Ϣ�����ʴӸߵ������򣬹�����ͬ�İ����Ŵ�С��������
		 */
		System.out.println("-------------������--------------------");
		test6(eList);

		/*
		 * �ж���Ŀ��Ŀ¼���Ƿ���result�ļ���,���û��,���ó����½��ļ���result,
		 * �����޸Ĳ���������Ϣ���л�����result�ļ��е�Employee-new�ļ���, ���÷����л��ķ�ʽ��ȡ����ӡ��Ϣ
		 */
		System.out.println("-------------������--------------------");
		test7(eList);

		/*
		 * ��д�ͻ��˺ͷ���������,ͨ���ͻ��˽�dir�ļ�����Employee.txt�ļ����͵���������,
		 * �浽��Ŀ��result�ļ�����
		 * IPʹ��127.0.0.1
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
		// ����1
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

		// ����2
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
			if (e.getName() == "����") {
				e.setName("��··");
				e.setPay(7500.0);
			}
			if (e.getName() == "����") {
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
			eList.add(new Employee(s[0], s[1], s[2] == "��" ? gender.male : gender.female,
					Double.parseDouble(s[3].replaceAll("Ԫ", ""))));
		}
		input.close();
		Iterator<Employee> iter = eList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		// System.out.println(System.getProperty("file.encoding"));
	}

	public static void test2() {
		// �ļ�����
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
