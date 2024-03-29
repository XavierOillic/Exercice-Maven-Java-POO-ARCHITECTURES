package Architectures_Couches.model;

import Architectures_Couches.model.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString (callSuper = true)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor

public class Product extends BaseEntity {
	
	@NonNull
	private String name;
	
	private int price;
	
	private int quantity;
	
	private Boolean inStock;

}
