package com.kuangxf.example.swagger.po;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户信息")
public class User {

	@ApiModelProperty(value = "用户ID", required = false)
	private Long id;

	@ApiModelProperty(value = "姓名", required = true)
	@NotNull
	@Length(min = 5, max = 30,message="长度在${min}到${max}之间")
	private String name;

	@ApiModelProperty(value = "年龄", required = true)
	@NotNull
	@Min(value = 10)
	@Max(value = 120)
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
