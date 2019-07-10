package model.dao;

import model.dao.impl.VendDaoJdbc;

public class DaoFactory {
	
	public static VendedorDao createVendDao() {
		return new VendDaoJdbc();
	}

}
