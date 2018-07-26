package com.java;

import java.util.Scanner;

public class QuanLy extends NhanVien {
	private int soNhanvien;

	public QuanLy() {
		super();
	}

	public QuanLy(String ten, GioiTinh gioiTinh, float luong, int soNhanvien) {
		super(ten, gioiTinh, luong);
		this.soNhanvien = soNhanvien;
		// TODO Auto-generated constructor stub
	}

	public int getSoNhanvien() {
		return soNhanvien;
	}

	public void setSoNhanvien(int soNhanvien) {
		this.soNhanvien = soNhanvien;
	}

	public float getPhuCap() {

		if (this.soNhanvien < 10) {
			return 500;
		} else if (this.soNhanvien >= 10 || this.soNhanvien <= 20) {
			return 1000;
		} else {
			return 2000;
		}
	}

	@Override
	public float getThuNhap() {
		// TODO Auto-generated method stub
		float thuNhap = this.getLuong() + this.getPhuCap();
		return 0;
	}

	public void nhapThongTin() {

		super.nhapThongTin();
		System.out.println("Nhap so nhan vien dang quan ly:");
		this.soNhanvien = new Scanner(System.in).nextInt();
	}

	public void hienThongTin() {

		super.hienThongTin();
		System.out.print("\tSo nhan vien dang quan ly: " + this.soNhanvien + "\tPhu cap: " + this.getPhuCap()
				+ "\tThu nhap: " + this.getThuNhap());
	}

}
