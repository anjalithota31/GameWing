package com.ty.gamewing.entity;

import java.util.List;

import com.ty.gamewing.dto.Club;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {
	 private int statusCode;
	 private String message;
	 private T data;
}
