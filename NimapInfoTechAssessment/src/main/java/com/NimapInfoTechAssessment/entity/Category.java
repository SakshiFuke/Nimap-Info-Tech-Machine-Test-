package com.NimapInfoTechAssessment.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "categories")
public class Category {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long categoryid;

	    private String name;

	    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference
	    private List<Product> products = new ArrayList<>();	

}
