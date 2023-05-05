package com.virendra.blog.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Role {
	
	@Id
	private int id;
	
	private String name;

}
