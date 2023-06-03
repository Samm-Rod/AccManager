package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.application.dao.DaoFactoryData;
import br.application.data.InputData;
import br.application.impl.DaoImplet;

public class Application {
	
	static Scanner sc = new Scanner(System.in);
	static DaoImplet dao = DaoFactoryData.createInputDataDao();

	public static void main(String[] args) {
		
		
		System.out.println("Storage password network internet: ");
		System.out.println("INSERT VALUE  [1] ");
		System.out.println("FIND BY ID:   [2] ");
		System.out.println("FIND ALL:     [3] ");
		System.out.println("UPDATE:       [4] ");
		System.out.println("DELETE BY ID: [5] ");
		System.out.println(" ---------------- ");
		System.out.print("Enter a value: ");
		int value = sc.nextInt();
		switch(value){
			case 1:
				InsertData();
				break;
			case 2:
				FindById();
				break;
			case 3:
				FindAll();
				break;
			case 4:
				UpdateData();
				break;
			case 5:
				DeleteById();
				break;
			default : 
				System.out.println("Invalid number !");
			
		}
		sc.close();
		
	}
	
	
	public static void InsertData() {
		System.out.println(" ===== INSERT DATA ===== ");
		InputData newNet = new InputData();
		
		System.out.print("Owner : ");
		newNet.setOwner(sc.next());
		
		System.out.print("Name Network: ");
		newNet.setnNetwork(sc.next());
		
		System.out.print("Pass Network: ");
		newNet.setPassword(sc.next());

		dao.insertNet(newNet);
	}
	
	public static void UpdateData() {
		System.out.println("========= UPDATE =========");
		InputData net = new InputData();
		System.out.print("Id: ");
		net = dao.findById(sc.nextInt());
		
		System.out.print("Owner: ");
		net.setOwner(sc.next());
		sc.nextLine();
		
		System.out.print("Name Network: ");
		net.setnNetwork(sc.next());
		sc.nextLine();

		
		System.out.print("Password: ");
		net.setPassword(sc.next());
		sc.nextLine();

		dao.updateDatas(net);
	}
	
	public static void FindById() {
		System.out.println(" =============== FIND BY ID ================ ");
		System.out.print("ID: ");
		InputData fd = dao.findById(sc.nextInt());
		System.out.println(fd);
	}
	
	public static void FindAll() {
		System.out.println(" ======== FIND ALL DATAS ============");
		List<InputData> storage = dao.findAll();
		for(InputData stored : storage) {
			System.out.println(stored);
		}
	}
	
	public static void DeleteById() {
		System.out.println(" ============ DELETE BY ID ============== ");
		System.out.print("ID: ");
		dao.deleteNet(sc.nextInt());
	}
	
	

}
