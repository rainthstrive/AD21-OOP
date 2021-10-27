package com.claseoop.pia;

import java.util.ArrayList;

public class EmpDao {
	
	private static ArrayList<Emp> EmpList = new ArrayList<Emp>();
	private static int id = 0;
	
	public static int SaveEmp(Emp e) {
		if(e.getName()!=null) {
			System.out.println(e.getName());
			e.setId(id);
			id++;
			EmpList.add(e);
			return 1;
		} else
			return 0;
	}
	public static void DeleteEmp(int id) {
		EmpList.remove(id);
	}
	public static int UpdateEmp(int id, Emp e) {
		EmpList.set(id, e);
		return 1;
	}
	public static Emp GetEmp(int id) {
		return EmpList.get(id);
	}
	public static ArrayList<Emp> GetAllEmps() {
		return EmpList;
	}
}
