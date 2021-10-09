package com.CrudDemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CrudDemo.DBConnect.DbConnection;
import com.CrudDemo.model.Employee;

public class EmpDao {
	
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	ResultSet rs = null;
	int a = 0;
	
	public ResultSet getEmployee() {
		String GET_EMP = "select * from employee";
		try {
			PreparedStatement st = con.prepareStatement(GET_EMP);
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int insertData(Employee emp) {
		String INSERT_EMP = "insert into employee (name,city,salary)values (?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(INSERT_EMP);
			st.setString(1, emp.getName());
			st.setString(2, emp.getCity());
			st.setFloat(3, emp.getSalary());
			a = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public ResultSet beforeUpdate(Employee e) {
		String GET_BY_ID = "select * from employee where id=?";
		try {
			PreparedStatement st= con.prepareStatement(GET_BY_ID);
			st.setInt(1, e.getId());
			rs = st.executeQuery();
			while(rs.next()) {
				e.setName(rs.getString("name"));
				e.setCity(rs.getString("city"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return rs;
	}

	public int updateEmp(Employee em) {
		String UPDATE_EMP = "update employee set name=?,city=? where id=?";
		try {
			PreparedStatement st = con.prepareStatement(UPDATE_EMP);
			st.setString(1, em.getName());
			st.setString(2, em.getCity());
			st.setInt(3, em.getId());
			a = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public int deleteEmp(Employee em) {
		String DELETE_EMP = "delete from employee where id=?";
		try {
			PreparedStatement st = con.prepareStatement(DELETE_EMP);
			st.setInt(1, em.getId());
			a = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
}
