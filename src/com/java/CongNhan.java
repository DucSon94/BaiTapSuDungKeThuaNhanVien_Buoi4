package com.java;

import java.util.Scanner;

public class CongNhan extends NhanVien {

	private float ngayCong;

	public CongNhan(String ten, GioiTinh gioiTinh, float luong, float ngayCong) {
		super(ten, gioiTinh, luong);
		this.ngayCong = ngayCong;
		// TODO Auto-generated constructor stub
	}

	public CongNhan() {
		super();
	}

	public float getNgayCong() {
		return ngayCong;
	}

	public void setNgayCong(float ngayCong) {
		this.ngayCong = ngayCong;
	}

	@Override
	public float getThuNhap() {
		// TODO Auto-generated method stub
		float thuNhap = this.getLuong() + (this.ngayCong / 26 * this.getLuong());
		return thuNhap;
	}

	public void nhapThongTin() {

		super.nhapThongTin();
		System.out.println("Nhap so ngay cong: ");
		this.ngayCong = new Scanner(System.in).nextFloat();
	}

	public void hienThongTin() {
		super.hienThongTin();
		System.out.print("\t So ngay cong: " + this.ngayCong + "Thu nhap: " + this.getThuNhap());
	}

}
