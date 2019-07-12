package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class VendDaoJdbc implements VendedorDao {

	private Connection conn;

	public VendDaoJdbc(Connection con) {
		this.conn = con;
	}

	@Override
	public void insert(Vendedor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = instanciarDepartment(rs);
				Vendedor vend = instanciarVendedor(rs, dep);
				return vend;

			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);

		}
	}

	private Vendedor instanciarVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor vend = new Vendedor();
		vend.setId(rs.getInt("Id"));
		vend.setNome(rs.getString("Name"));
		vend.setEmail(rs.getString("Email"));
		vend.setSalBase(rs.getDouble("BaseSalary"));
		vend.setAniv(rs.getDate("BirthDate"));
		vend.setDepartamento(dep);
		return vend;
	}

	private Departamento instanciarDepartment(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setNome(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendedor> findByDepartmento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE DepartmentId = ? " + "ORDER BY Name");

			st.setInt(1, departamento.getId());

			rs = st.executeQuery();
			List<Vendedor> list = new ArrayList<>();
			// esse integer é o id do departamento, e o valor de cada obj vai ser do tipo
			// Departamento
			Map<Integer, Departamento> map = new HashMap<>();

			while (rs.next()) {
				Departamento dep = map.get(rs.getInt("DepartmentId"));

				if (dep == null) {

					dep = instanciarDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				Vendedor vend = instanciarVendedor(rs, dep);
				list.add(vend);
			}
			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);

		}

	}

}
