package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.PersistenceException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import fhdw.ipscrum.shared.persistence.SerializationRoot;

public class Root implements SerializationRoot{

	private Vector<Project> projects;
	private Vector<IPerson> persons;
	private Vector<ITeam> teams;
	private Vector<IRole> roles;
	
	@Override
	public void save(String identifier) throws PersistenceException {
		// No Implementation Needed
	}
	
	public Vector<IPerson> getPersons() {
		if(this.persons==null){
			this.persons = new Vector<IPerson>();
		}
		return persons;
	}
	
	public Vector<Project> getProjects() {
		if(this.projects==null){
			this.projects = new Vector<Project>();
		}
		return projects;
	}
	
	public Vector<ITeam> getTeams() {
		if(this.teams==null){
			this.teams = new Vector<ITeam>();
		}
		return teams;
	}
	
	public Vector<IRole> getRoles() {
		if(this.roles==null){
			this.roles = new Vector<IRole>();
		}
		return roles;
	}
	
	public void removeProject(Project project){
		//TODO Check Consistency
		this.getProjects().remove(project);
	}
	
	public void addProject(Project project){
		//TODO Check Consistency
		this.getProjects().add(project);
	}
	
	public Integer countProjects(){
		return this.getProjects().size();
	}
	
	public void removePerson(IPerson person){
		//TODO Check Consistency
		this.getPersons().remove(person);
	}
	
	public void addPerson(IPerson person){
		//TODO Check Consistency
		this.getPersons().add(person);
	}
	
	public Integer countPersons(){
		return this.getPersons().size();
	}
	
	public void removeTeam(ITeam team){
		//TODO Check Consistency
		this.getTeams().remove(team);
	}
	
	public void addTeam(ITeam team){
		//TODO Check Consistency
		this.getTeams().add(team);
	}
	
	public Integer countTeams(){
		return this.getTeams().size();
	}

	public void removeRole(IRole role){
		//TODO Check Consistency
		this.getRoles().remove(role);
	}
	
	public void addRole(IRole role){
		//TODO Check Consistency
		this.getRoles().add(role);
	}
	
	public Integer countRoles(){
		return this.getRoles().size();
	}

	@Override
	public String toString() {
		return "Root";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getPersons() == null) ? 0 : this.getPersons().hashCode());
		result = prime * result
				+ ((this.getProjects() == null) ? 0 : this.getProjects().hashCode());
		result = prime * result + ((this.getRoles() == null) ? 0 : this.getRoles().hashCode());
		result = prime * result + ((this.getTeams() == null) ? 0 : this.getTeams().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Root other = (Root) obj;
		if (this.getPersons() == null) {
			if (other.getPersons() != null)
				return false;
		} else if (!this.getPersons().equals(other.getPersons()))
			return false;
		if (this.getProjects() == null) {
			if (other.getProjects() != null)
				return false;
		} else if (!this.getProjects().equals(other.getProjects()))
			return false;
		if (this.getRoles() == null) {
			if (other.getRoles() != null)
				return false;
		} else if (!this.getRoles().equals(other.getRoles()))
			return false;
		if (this.getTeams() == null) {
			if (other.getTeams() != null)
				return false;
		} else if (!this.getTeams().equals(other.getTeams()))
			return false;
		return true;
	}
}
