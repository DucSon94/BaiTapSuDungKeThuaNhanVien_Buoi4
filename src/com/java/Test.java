package com.java;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		QuanLyNhanVien qlnv = new QuanLyNhanVien();
		while (true) {
			System.out.println("1.Nhap danh sach");
			System.out.println("2.Hien Danh Sach");
			System.out.println("3.tim nhan vien co thu nhap cao nhat theo:");
			int chon = new Scanner(System.in).nextInt();
			switch (chon) {
			case 1:
				qlnv.nhapDanhSachNhanVien();
				break;
			case 2:
				qlnv.hienThongTinDanhSachNhanVien();
				break;
			case 3:
				System.out.println("1\t Gioitinh");
				System.out.println("2\t Theo vi tri phong ban");
				int nhap = new Scanner(System.in).nextInt();
				switch (nhap) {
				case 1:
					qlnv.nhanVienCoLuongCaoNhatTheoGioiTinh();
					break;
				case 2:
					qlnv.nhanVienCoLuongCaoNhatTheoPhongBan();
					break;
				default:
					System.out.println("Vui long chon muc 1 hoac 2");
				}
				break;
			case 4:
				System.out.println("Cam on thim da su dung chuong trinh :D");
				System.exit(0);
			}

		}
	}
}
