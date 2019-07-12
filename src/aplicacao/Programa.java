package aplicacao;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		
		VendedorDao vendDao = DaoFactory.createVendDao();
		System.out.println("=====TESTE 1: vendedor findById ====="); 
		Vendedor vend = vendDao.findById(3);
		System.out.println(vend);
		
		
		

	}

}
