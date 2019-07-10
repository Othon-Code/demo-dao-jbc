package model.dao;

import java.util.List;

import model.entidades.Departamento;

public interface DepartamentoDao {
	void insert(Departamento obj);

	void update(Departamento obj);

	void deleteById(Integer id);

	Departamento findById(Integer ig);// se existr retorna o dep, se n�o retorna null

	List<Departamento> findAll();
}
