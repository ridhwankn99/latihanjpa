package com.eksad.latihanjpa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eksad.latihanjpa.dao.EmployeeDAO;
import com.eksad.latihanjpa.model.Employee;

@Configuration
public class Action {

	@Autowired
	EmployeeDAO employeeDAO;

	@Bean
	public List<Employee> getAll() {
		List<Employee> employees = employeeDAO.getAll();

		//for (Employee employee : employees) {
			/*
			 * System.out.println("ID :  "+employee.getId());
			 * System.out.println("Name :  "+employee.getName());
			 * System.out.println("Address :  "+employee.getAddress());
			 * System.out.println("DOB :  "+employee.getDob());
			 * System.out.println("======================================");
			 */
	//	}

		return employees;
	}

	/*
	 * @Bean public Employee getById() { Employee employee = employeeDAO.getById(2);
	 * 
	 * System.out.println("GET BY ID");
	 * System.out.println("ID :  "+employee.getId());
	 * System.out.println("Name :  "+employee.getName());
	 * System.out.println("Address :  "+employee.getAddress());
	 * System.out.println("DOB :  "+employee.getDob());
	 * System.out.println("======================================");
	 * 
	 * return employee; }
	 */
	//@Bean
	public boolean save() {
		try {
			Employee employee = new Employee();
			employee.setName("bambang");
			employee.setAddress("Bandung");

			String dateString = "2019-05-05";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

			employee.setDob(date);
			
			employeeDAO.save(employee);
			System.out.println("Data Berhasil Tersimpan Hore");
			return true;
		} catch (Exception e) {
			System.out.println("Gagal Menyimpan");
			e.printStackTrace();
			return false;
		}
	}
	//@Bean
	public boolean update() {
		try {
			Employee employee = new Employee();
			
			employee.setId(15);
			employee.setName("basuki");
			employee.setAddress("Bogor");

			String dateString = "1975-01-05";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

			employee.setDob(date);
			
			employeeDAO.update(employee);
			System.out.println("Data Berhasil Tersimpan Hore");
			return true;
		} catch (Exception e) {
			System.out.println("Gagal Menyimpan");
			e.printStackTrace();
			return false;
		}
	}
	//@Bean
	public boolean delete() {
		try {
			employeeDAO.delete(14);
			System.out.println("Data Berhasil Dihapus");
			return true;
		} catch (Exception e) {
			System.out.println("Data Gagal Dihapus");
			e.printStackTrace();
			return false;
		}
	}
	@Bean
	public List<Employee> getByName() {
		List<Employee> employees = employeeDAO.getByName("Ridhwan");
		
		for (Employee employee : employees) {
			
			  System.out.println("ID :  "+employee.getId());
			  System.out.println("Name :  "+employee.getName());
			  System.out.println("Address :  "+employee.getAddress());
			  System.out.println("DOB :  "+employee.getDob());
			  System.out.println("======================================");
	 
		}
		return employees;
	}
}
