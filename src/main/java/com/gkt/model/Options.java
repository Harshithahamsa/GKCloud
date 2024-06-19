package com.gkt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


@Entity
public class Options {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(name = "optid")
    private int optid;

	private String opttext;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOptid() {
		return optid;
	}

	public void setOptid(int optid) {
		this.optid = optid;
	}

	public String getOpttext() {
		return opttext;
	}

	public void setOpttext(String opttext) {
		this.opttext = opttext;
	}

	

	public Options(int id, int optid, String opttext) {
		super();
		this.id = id;
		this.optid = optid;
		this.opttext = opttext;
	}

	public Options() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

		

		
	    
	    

}
