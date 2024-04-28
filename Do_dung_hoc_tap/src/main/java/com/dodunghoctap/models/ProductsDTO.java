package com.dodunghoctap.models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProductsDTO {
	
	private String ten;
	private double gia;
	private String chitiet;
	private MultipartFile anh;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getChitiet() {
		return chitiet;
	}
	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}
	public MultipartFile getAnh() {
		return anh;
	}
	public void setAnh(MultipartFile anh) {
		this.anh = anh;
	}
	
}
