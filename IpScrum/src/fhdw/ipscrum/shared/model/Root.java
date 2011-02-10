package fhdw.ipscrum.shared.model;

import java.util.HashSet;

import fhdw.ipscrum.shared.exceptions.PersistenceException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.persistence.SerializationRoot;

public class Root extends Observable implements SerializationRoot{

	private HashSet<Project> projects;
	private HashSet<IPerson> persons;
	private HashSet<ITeam> teams;
	private HashSet<IRole> roles;
	
	@Override
	public void save(String identifier) throws PersistenceException {
		// No Implementation Needed
	}
	
	public HashSet<IPerson> getPersons() {
		if(this.persons==null){
			this.persons = new HashSet<IPerson>();
		}
		return persons;
	}
	
	public HashSet<Project> getProjects() {
		if(this.projects==null){
			this.projects = new HashSet<Project>();
		}
		return projects;
	}
	
	public HashSet<ITeam> getTeams() {
		if(this.teams==null){
			this.teams = new HashSet<ITeam>();
		}
		return teams;
	}
	
	public HashSet<IRole> getRoles() {
		if(this.roles==null){
			this.roles = new HashSet<IRole>();
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
	
	public void addPerson(IPerson person){
		//TODO Check Consistency
		this.getPersons().add(person);
	}
	
	public Integer countPersons(){
		return this.getPersons().size();
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
