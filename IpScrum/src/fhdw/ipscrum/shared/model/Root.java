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
		result = prime * result + ((persons == null) ? 0 : persons.hashCode());
		result = prime * result
				+ ((projects == null) ? 0 : projects.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((teams == null) ? 0 : teams.hashCode());
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
		if (persons == null) {
			if (other.persons != null)
				return false;
		} else if (!persons.equals(other.persons))
			return false;
		if (projects == null) {
			if (other.projects != null)
				return false;
		} else if (!projects.equals(other.projects))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (teams == null) {
			if (other.teams != null)
				return false;
		} else if (!teams.equals(other.teams))
			return false;
		return true;
	}
}
