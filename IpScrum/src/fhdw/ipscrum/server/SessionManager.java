package fhdw.ipscrum.server;

import fhdw.ipscrum.shared.model.Root;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class SessionManager {

	public final static String IDENTIFIER = "RootModel"; 
	private static SessionManager instance;
	
	private IPerson loginUser;
	private final Root model;
	
	
	public static SessionManager getInstance(){
		if(instance==null){
			instance = new SessionManager();
		}
		return instance;
	}
	
	private SessionManager() {
		super();
		this.model = new Root();
	}
	
	public IPerson getLoginUser() {
		return loginUser;
	}
	
	public void setLoginUser(IPerson loginUser) {
		this.loginUser = loginUser;
	}
	
	public Root getModel() {
		return model;
	}
}
