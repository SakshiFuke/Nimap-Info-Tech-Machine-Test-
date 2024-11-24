package com.NimapInfoTechAssessment.productdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

	private Long productsId;
	private String name;
	private double price;
	private Long categoryid;
}
