package com.java;

import java.util.Scanner;

public class QuanLyNhanVien {

	private NhanVien[] danhSachNhanVien = null;
	private CongNhan[] danhSachCongNhan = null;
	private NhanVienVanPhong[] danhSachNhanVienVanPhong = null;
	private QuanLy[] danhSachQuanLy = null;
	private static int chiSoCongNhan = 0;
	private static int chiSoNhanVienVanPhong = 0;
	private static int chiSoQuanLy = 0;

	public NhanVien[] nhapDanhSachNhanVien() {
		while (true) {
			System.out.println("Nhap so luong nhan vien");
			int soLuong = new Scanner(System.in).nextInt();
			if (soLuong > 0) {
				danhSachNhanVien = new NhanVien[soLuong];
				danhSachNhanVienVanPhong = new NhanVienVanPhong[danhSachNhanVien.length];
				danhSachCongNhan = new CongNhan[danhSachNhanVien.length];
				danhSachQuanLy = new QuanLy[danhSachNhanVien.length];

				for (int i = 0; i < danhSachNhanVien.length; i++) {
					NhanVien nhanVien = danhSachNhanVien[i];

					if (nhanVien == null) {

						System.out.println("Chon doi tuong muon  nhap thong tin");
						System.out.println("1. Cong nhan");
						System.out.println("2.Nhan vien van phong");
						System.out.println("3. Quan ly");
						int chon = new Scanner(System.in).nextInt();
						switch (chon) {
						case 1:
							nhanVien = new CongNhan();
							nhanVien.nhapThongTin();
							danhSachNhanVien[i] = nhanVien;
							int chiSoCongNhan1 = chiSoCongNhan;
							danhSachCongNhan[chiSoCongNhan1] = (CongNhan) nhanVien;
							chiSoCongNhan++;

							break;
						case 2:
							nhanVien = new NhanVienVanPhong();
							nhanVien.nhapThongTin();
							danhSachNhanVien[i] = nhanVien;
							int chiSoNhanVienVanPhong1 = chiSoNhanVienVanPhong;
							danhSachNhanVienVanPhong[chiSoNhanVienVanPhong1] = (NhanVienVanPhong) nhanVien;
							chiSoNhanVienVanPhong++;
							break;
						case 3:
							nhanVien = new QuanLy();
							nhanVien.nhapThongTin();
							danhSachNhanVien[i] = nhanVien;
							int chiSoQuanLy1 = chiSoQuanLy;
							danhSachQuanLy[chiSoQuanLy1] = (QuanLy) nhanVien;
							chiSoQuanLy++;
							break;
						default:
							System.out.println("vui long chon 1 hoac hoac 3");
						}
					}
				}
				return danhSachNhanVien;

			}
			return null;
		}
	}

	public void hienThongTinDanhSachNhanVien() {
		if (danhSachNhanVien != null) {
			for (NhanVien nhanVien : danhSachNhanVien) {
				nhanVien.hienThongTin();
			}
		} else {
			System.out.println("chua co nhan vien nao vui long chon 1 de nhap danh sach nhan vien truoc");
		}
	}

	public void nhanVienCoLuongCaoNhatTheoGioiTinh() {
		System.out.println("vui long chon gioi tinh");
		System.out.println("1 => Nam, 0=> Nu, # => KXD");
		int nhapGioiTinh = new Scanner(System.in).nextInt();
		GioiTinh gioiTinh = GioiTinh.setGioiTinh(nhapGioiTinh);
		NhanVien nhanVien = nhanVienLuongCaoNhatTheogioiTinh(danhSachNhanVien, gioiTinh);
		if (nhanVien != null) {
			nhanVien.hienThongTin();
		} else {
			System.out.println("khong co nhan vien nao");
		}
	}

//	
	public void nhanVienCoLuongCaoNhatTheoPhongBan() {
		System.out.println("Vui long chon: 1 =>Cong nhan , 2 => Nhan vien van phong , # =>Quan ly)");
		int viTri = new Scanner(System.in).nextInt();
		switch (viTri) {
		case 1:
			CongNhan congNhanLuongCaoNhat = congNhanCoLuongCaoNhat(danhSachCongNhan);
			if (congNhanLuongCaoNhat != null) {
				System.out.println("Cong nhan co luong cao nhat la: ");
				congNhanLuongCaoNhat.hienThongTin();
			} else {
				System.out.println("Khong co du lieu cong nhan nen khong tim dc cong nhan co luong cao nhat");
			}
			break;
		case 2:
			NhanVienVanPhong nhanvienVanPhongLuongCaoNhat = nhanVienVanPhongCoLuongCaoNhat(danhSachNhanVienVanPhong);
			if (nhanvienVanPhongLuongCaoNhat != null) {
				System.out.println("Nhan vien van phong co luong cao nhat la: ");
				nhanvienVanPhongLuongCaoNhat.hienThongTin();
			} else {
				System.out.println(
						"khong co du lieu nhan vien van phong nen khong tim duoc nhan vien van phong co luong cao nhat");
			}
			break;
		case 3:
			QuanLy quanLyLuongCaoNhat = quanLyCoLuongCaoNhat(danhSachQuanLy);

			if (quanLyLuongCaoNhat != null) {
				System.out.println("Quan ly co luong cao nhat la: ");
				quanLyLuongCaoNhat.hienThongTin();
			} else {
				System.out.println("Khong co du lieu quan ly nen khong tim dc quan ly co luong cao nhat");
			}
			break;
		default:
			System.out.println("vui long chon 1 hoac 2 hoac 3");

		}

	}

	private NhanVien nhanVienLuongCaoNhatTheogioiTinh(NhanVien[] danhSach, GioiTinh gioiTinh) {
		if (danhSach != null) {
			int count = 0;
			for (int i = 0; i < danhSach.length; i++) {
				if (danhSach[i].getGioiTinh().getMa() == gioiTinh.getMa()) {
					count++;
				}
			}
			NhanVien[] danhSachNhanVienCoCungGioitinh = new NhanVien[count];
			count = 0;
			for (int i = 0; i < danhSach.length; i++) {
				NhanVien nhanVien = danhSach[i];
				if (nhanVien.getGioiTinh().getMa() == gioiTinh.getMa()) {
					danhSachNhanVienCoCungGioitinh[count] = nhanVien;
					count++;
				}
			}
			NhanVien nhanVienLuongCaoNhat = nhanVienluongCaoNhat(danhSachNhanVienCoCungGioitinh);
			return nhanVienLuongCaoNhat;
		}
		return null;

	}

	private NhanVien nhanVienluongCaoNhat(NhanVien[] danhSach) {
		if (danhSach != null) {
			NhanVien nhanVienLuongCaoNhat = danhSach[0];
			for (int i = 1; i < danhSach.length; i++) {
				NhanVien nhanVienThuI = danhSach[i];
				if (nhanVienLuongCaoNhat.getThuNhap() < nhanVienThuI.getThuNhap()) {
					nhanVienLuongCaoNhat = nhanVienThuI;
					return nhanVienLuongCaoNhat;
				}
			}
		}
		return null;
	}

	private CongNhan congNhanCoLuongCaoNhat(CongNhan[] danhSachCongNhan) {
		if (danhSachCongNhan != null) {
			int count = 0;
			for (int i = 0; i < danhSachCongNhan.length; i++) {
				if (danhSachCongNhan[i] != null) {
					count++;
				}
			}
			CongNhan[] danhSachCongNhanMoi = new CongNhan[count];
			count = 0;
			for (int i = 0; i < danhSachCongNhan.length; i++) {
				if (danhSachCongNhan[i] != null) {
					danhSachCongNhanMoi[count] = danhSachCongNhan[i];
					count++;
				}
			}
			CongNhan congNhanLuongCaoNhat = danhSachCongNhanMoi[0];
			for (int i = 1; i < danhSachCongNhanMoi.length; i++) {
				CongNhan congNhanThuI = danhSachCongNhan[i];
				if (congNhanLuongCaoNhat.getThuNhap() < congNhanThuI.getThuNhap()) {
					congNhanLuongCaoNhat = congNhanThuI;

				}
			}
			return congNhanLuongCaoNhat;
		} else
			return null;

	}

	private NhanVienVanPhong nhanVienVanPhongCoLuongCaoNhat(NhanVienVanPhong[] danhSachNhanvienVanPhong) {
		if (danhSachNhanvienVanPhong != null) {
			int count = 0;
			for (int i = 0; i < danhSachNhanvienVanPhong.length; i++) {
				if (danhSachNhanvienVanPhong[i] != null) {
					count++;
				}
			}
			if (count > 0) {
				NhanVienVanPhong[] danhSachNhanvienVanPhongMoi = new NhanVienVanPhong[count];
				count = 0;
				for (int i = 0; i < danhSachNhanvienVanPhong.length; i++) {
					if (danhSachNhanvienVanPhong[i] != null) {
						danhSachNhanvienVanPhongMoi[count] = danhSachNhanvienVanPhong[i];
						count++;
					}
				}
				NhanVienVanPhong nhanVienVanPhongLuongCaoNhat = danhSachNhanvienVanPhongMoi[0];
				for (int i = 1; i < danhSachNhanvienVanPhongMoi.length; i++) {
					NhanVienVanPhong nhanVienVanPhongThuI = danhSachNhanvienVanPhongMoi[i];
					if (nhanVienVanPhongLuongCaoNhat.getThuNhap() < nhanVienVanPhongThuI.getThuNhap()) {
						nhanVienVanPhongLuongCaoNhat = nhanVienVanPhongThuI;

					}
				}
				return nhanVienVanPhongLuongCaoNhat;
			}
		}
		return null;

	}

	private QuanLy quanLyCoLuongCaoNhat(QuanLy[] danhSachQuanLy) {
		if (danhSachQuanLy != null) {
			int count = 0;
			for (int i = 0; i < danhSachQuanLy.length; i++) {
				if (danhSachQuanLy[i] != null) {
					count++;
				}
			}
			if (count > 0) {
				QuanLy[] danhSachQuanLyMoi = new QuanLy[count];
				count = 0;
				for (int i = 0; i < danhSachQuanLy.length; i++) {
					if (danhSachQuanLy[i] != null) {
						danhSachQuanLyMoi[count] = danhSachQuanLy[i];
						count++;
					}
				}
				QuanLy quanLyLuongCaoNhat = danhSachQuanLyMoi[0];
				for (int i = 1; i < danhSachQuanLyMoi.length; i++) {
					QuanLy quanLyThuI = danhSachQuanLyMoi[i];
					if (quanLyLuongCaoNhat.getThuNhap() < quanLyThuI.getThuNhap()) {
						quanLyLuongCaoNhat = quanLyThuI;

					}
				}
				return quanLyLuongCaoNhat;
			}
		}
		return null;

	}

//	public void hienMenu() {
//		System.out.println("1.Nhap danh sach");
//		System.out.println("2.Hien Danh Sach");
//		System.out.println("3.tim nhan vien co thu nhap cao nhat theo:");
//	}

	// public void nhanVienCoLuongCaoNhatTheoPhongBan1() {
	//
//				CongNhan congNhanLuongCaoNhat = congNhanCoLuongCaoNhat(danhSachCongNhan);
//				NhanVienVanPhong nhanvienVanPhongLuongCaoNhat = nhanVienVanPhongCoLuongCaoNhat(danhSachNhanVienVanPhong);
//				QuanLy quanLyLuongCaoNhat = quanLyCoLuongCaoNhat(danhSachQuanLy);
//				if (congNhanLuongCaoNhat != null) {
//					System.out.println("Cong nhan co luong cao nhat la: ");
//					congNhanLuongCaoNhat.hienThongTin();
//				} else {
//					System.out.println("Khong co du lieu cong nhan nen khong tim dc cong nhan co luong cao nhat");
//				}
//				if (nhanvienVanPhongLuongCaoNhat != null) {
//					System.out.println("Nhan vien van phong co luong cao nhat la: ");
//					nhanvienVanPhongLuongCaoNhat.hienThongTin();
//				} else {
//					System.out.println(
//							"khong co du lieu nhan vien van phong nen khong tim duoc nhan vien van phong co luong cao nhat");
//				}
//				if (quanLyLuongCaoNhat != null) {
//					System.out.println("Quan ly co luong cao nhat la: ");
//					quanLyLuongCaoNhat.hienThongTin();
//				} else {
//					System.out.println("Khong co du lieu quan ly nen khong tim dc quan ly co luong cao nhat");
//				}
//			}

}
