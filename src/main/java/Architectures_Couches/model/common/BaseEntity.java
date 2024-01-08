package Architectures_Couches.model.common;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data

public abstract class BaseEntity  {	
	
	@Setter(value = AccessLevel.NONE)	
	private String id = UUID.randomUUID().toString();
}

// UUID => Immutable Universaly Unique Identifier.
// Création d'un ID ALEATOIRE pour retrouver un user ou un product
