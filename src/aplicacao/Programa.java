package aplicacao;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		
		VendedorDao vendDao = DaoFactory.createVendDao();
		System.out.println("=====TESTE 1: vendedor findById ====="); 
		Vendedor vend = vendDao.findById(3);
		System.out.println(vend);
		
		System.out.println("\n=====TESTE 2: vendedor findByIdDepartment =====");
		Departamento depart = new Departamento(2, null);
		List<Vendedor> list = vendDao.findByDepartmento(depart);
		for(Vendedor v: list) {
			System.out.println(v);
		}
		
		System.out.println("=============================================");
		
		System.out.println("\n=====TESTE 3: vendedor findAll =====");
		
		List<Vendedor> listv = vendDao.findAll();
		for(Vendedor v: listv) {
			System.out.println(v);
		}
		
		

	}

}
