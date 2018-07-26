package com.java;

import java.util.Scanner;

public abstract class NhanVien {
	private static int maTuTang = 0;
	private int ma;
	private String ten;
	private GioiTinh gioiTinh;
	private float luong;

	public NhanVien() {
		super();
		this.ma = ++maTuTang;
	}

	public NhanVien(String ten, GioiTinh gioiTinh, float luong) {
		this.ma = ++maTuTang;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.luong = luong;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public GioiTinh getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(GioiTinh gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public abstract float getThuNhap();

	public void nhapThongTin() {
		System.out.println("Nhap thong tin nhan vien");
		System.out.println("Nhap ten: ");
		ten = new Scanner(System.in).nextLine();
		System.out.println("Vui long chon gioi tinh");
		int chon = new Scanner(System.in).nextInt();
		this.gioiTinh = GioiTinh.setGioiTinh(chon);
		System.out.println("Nhap luong:");
		luong = new Scanner(System.in).nextFloat();
	}

	public void hienThongTin() {

		System.out.println("Thong tin nhan vien");
		System.out.println("ma nhan vien: " + this.ma + "\tTen: " + this.ten + "\tGioi tinh: "
				+ this.gioiTinh.getTenGioiTinh() + "\tLuong: " + this.luong);
	}

}
