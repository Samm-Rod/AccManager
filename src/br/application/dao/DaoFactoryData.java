package br.application.dao;

import br.application.impl.DaoImplet;
import br.application.model.Storage;

public class DaoFactoryData {
	
	public static DaoImplet createInputDataDao() {
		return new Storage(DB.getConnect());
	}

}
