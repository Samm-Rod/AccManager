package br.application.impl;

import java.util.List;

import br.application.data.InputData;

public interface DaoImplet {
	
	
	void insertNet(InputData obj);
	void deleteNet(Integer id);
	void updateDatas(InputData obj);
	List<InputData> findAll();
	InputData findById(Integer id);
	

}
