package com.vitu.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

	@Id
	private String id;
	private String name;
	private String location;
	private String about;
}
