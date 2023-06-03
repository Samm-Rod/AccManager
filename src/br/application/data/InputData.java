package br.application.data;

public class InputData {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String owner;
	private String nNetwork;
	private String password;
	
	
	public InputData() {}
	
	
	public InputData(Integer id, String owner, String nNetwork, String password) {
		this.id = id;
		this.owner = owner;
		this.nNetwork = nNetwork;
		this.password = password;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public String getnNetwork() {
		return nNetwork;
	}


	public void setnNetwork(String nNetwork) {
		this.nNetwork = nNetwork;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Stored Data => ID " + id + ", Owner: " + owner + ", NetWork: " + nNetwork + ", Password: " + password;
	}


	


	
	
	
	

}
