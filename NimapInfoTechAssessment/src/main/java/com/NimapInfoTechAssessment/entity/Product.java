package com.NimapInfoTechAssessment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "products")
public class Product {

		 @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
		 private Long productsId;

		 private String name;

		 private double price;

		 @ManyToOne
		 @JoinColumn(name = "category_id", nullable = false)
		 @JsonBackReference
		 private Category category;

}
