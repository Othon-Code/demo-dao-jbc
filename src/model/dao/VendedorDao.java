package model.dao;

import java.util.List;

import model.entidades.Departamento;
import model.entidades.Vendedor;

public interface VendedorDao {

	void insert(Vendedor obj);

	void update(Vendedor obj);

	void deleteById(Integer id);

	Vendedor findById(Integer ig);// se existr retorna o vendedor, se não retorna null

	List<Vendedor> findAll();
	List<Vendedor> findByDepartmento(Departamento departamento);
}
