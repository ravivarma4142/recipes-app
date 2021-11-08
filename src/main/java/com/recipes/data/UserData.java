package com.recipes.data;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "user")
public class UserData {

	String userName;
	String password;
}
