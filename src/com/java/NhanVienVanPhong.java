package com.java;

import java.util.Scanner;

public class NhanVienVanPhong extends NhanVien {
	private float heSo;

	public NhanVienVanPhong(int maTuTang, String ten, GioiTinh gioiTinh, float luong, float heSo) {
		super(ten, gioiTinh, luong);
		// TODO Auto-generated constructor stub
		this.heSo = heSo;
	}

	public NhanVienVanPhong() {
		super();
	}

	public float getHeSo() {
		return heSo;
	}

	public void setHeSo(float heSo) {
		this.heSo = heSo;
	}

	@Override
	public float getThuNhap() {
		// TODO Auto-generated method stub
		float thuNhap = this.getLuong() + this.heSo * this.getLuong();
		return thuNhap;
	}

	public void nhapThongTin() {

		super.nhapThongTin();
		System.out.println("Nhap he so: ");
		this.heSo = new Scanner(System.in).nextFloat();
	}

	public void hienThongTin() {
		super.hienThongTin();
		System.out.print("\tHe so: " + this.heSo + "\tThu nhap: " + this.getThuNhap());
	}

}
