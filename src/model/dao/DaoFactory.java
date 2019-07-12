package model.dao;

import db.DB;
import model.dao.impl.VendDaoJdbc;

public class DaoFactory {
	
	public static VendedorDao createVendDao() {
		return new VendDaoJdbc(DB.getConnection());
	}

}
