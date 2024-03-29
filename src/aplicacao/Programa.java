package aplicacao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		VendedorDao vendDao = DaoFactory.createVendDao();
		System.out.println("=====TESTE 1: vendedor findById =====");
		Vendedor vend = vendDao.findById(3);
		System.out.println(vend);

		System.out.println("\n=====TESTE 2: vendedor findByIdDepartment =====");
		Departamento depart = new Departamento(2, null);
		List<Vendedor> list = vendDao.findByDepartmento(depart);
		for (Vendedor v : list) {
			System.out.println(v);
		}

		System.out.println("=============================================");

		System.out.println("\n=====TESTE 3: vendedor findAll =====");

		List<Vendedor> listv = vendDao.findAll();
		for (Vendedor v : listv) {
			System.out.println(v);
		}

		/*
		 * System.out.println("\n=====TESTE 4: vendedor Insert =====");
		 * 
		 * Vendedor newVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new
		 * Date(), 4000.0, depart); vendDao.insert(newVendedor);
		 * System.out.println("INSERIDO !!! Novo ID = " + newVendedor.getId());
		 */

		System.out.println("=========== 5 ==========");
		System.out.println("\n=====TESTE 5: Update do Vendedor =====");

		vend = vendDao.findById(1);
		vend.setNome("Martha Waine");
		vendDao.update(vend);

		System.out.println("\n=====TESTE 6: Deletando um Vendedor =====");
		System.out.println("Entre com um ID para deletar: ");
		int id = sc.nextInt();
		vendDao.deleteById(id);
		System.out.println("Usu�rio deletado !!");
		sc.close();

	}

}
