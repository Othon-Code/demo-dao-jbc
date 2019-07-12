package aplicacao;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		
		VendedorDao vendDao = DaoFactory.createVendDao();
		
		Vendedor vend = vendDao.findById(3);
		System.out.println(vend);
		
		
		

	}

}
