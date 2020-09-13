package com.springboot.rest.FileOperations.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileDetails {

	@Value("${file.srclocation}")
	private String srcLocation;

	@Value("${file.dstlocation}")
	private String dstLocation;

	public String getSrcLocation() {
		return srcLocation;
	}

	public void setSrcLocation(String srcLocation) {
		this.srcLocation = srcLocation;
	}

	public String getDstLocation() {
		return dstLocation;
	}

	public void setDstLocation(String dstLocation) {
		this.dstLocation = dstLocation;
	}

	public FileDetails() {
		System.out.println("Default FileDetails Constructor");

	}

}
