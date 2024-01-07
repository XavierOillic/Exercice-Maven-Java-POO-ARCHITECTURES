package Architectures_Couches.model;

import Architectures_Couches.model.common.BaseEntity;
import Architectures_Couches.utils.persistence.CrudRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends BaseEntity {	
	@NonNull
	private String login;
	@NonNull
	private String password;

}
