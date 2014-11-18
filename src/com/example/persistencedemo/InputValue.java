package com.example.persistencedemo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/*
 * Table: input_values
 * 
 * text (varchar)
 * 
 */

@Table(name="input_values")
public class InputValue extends Model {
	@Column(name = "text")
	public String text;
	
	public InputValue() {
		super();
	}
	
	//new InputValue("foo");
	public InputValue(String text) {
		super();
		this.text = text;
	}
	
	// InputValue.queryMostRecent()
	public static InputValue queryMostRecent() {
		return new Select().from(InputValue.class).orderBy("id DESC").limit("1").executeSingle();
	}
}
