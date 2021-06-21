package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tmanagement {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		List<Userinfo> uList = new ArrayList<Userinfo>();

		Reader tdb = new FileReader("/Users/jangjaeyeong/javaStudy/imgfile/PhoneDB.txt");
		BufferedReader br = new BufferedReader(tdb);

		String Tinfo;

		System.out.println("***************************************");
		System.out.println("*          전화번호 관리 프로그램           *");
		System.out.println("***************************************");

		boolean flag = true;

		while (flag) {

			while (!((Tinfo = br.readLine()) == null)) {

				String[] TinfoArray = Tinfo.split(",");

				Userinfo Userinfo = new Userinfo(TinfoArray[0], TinfoArray[1], TinfoArray[2]);

				uList.add(Userinfo);

			}

			System.out.println();
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("----------------------------------");
			System.out.print(">메뉴번호: ");
			int sellist = sc.nextInt();

			switch (sellist) {
			case 1: {
				System.out.println("<1.리스트>");
				for (int i = 0; i < uList.size(); i++) {
					System.out.print(i + 1 + ".  ");
					uList.get(i).showList();
				}
				break;
			}
			case 2: {

				System.out.println("<2.등록>");

				System.out.print("이름: ");
				String Rname = sc.next();

				System.out.print("휴대전화: ");
				String Rhp = sc.next();

				System.out.print("회사전화: ");
				String Rcp = sc.next();

				Userinfo adduserinfo = new Userinfo(Rname, Rhp, Rcp);
				uList.add(adduserinfo);

				Writer wdb = new FileWriter("/Users/jangjaeyeong/javaStudy/imgfile/PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(wdb);
				for (int i = 0; i < uList.size(); i++) {
					bw.write(uList.get(i).getName() + "," + uList.get(i).getHp() + "," + uList.get(i).getCompany());
					bw.newLine();
				}
				bw.close();
				break;
			}
			case 3: {
				System.out.print(">번호 : ");
				int delnum = sc.nextInt();
				uList.remove(delnum - 1);

				Writer wdb = new FileWriter("/Users/jangjaeyeong/javaStudy/imgfile/PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(wdb);
				for (int i = 0; i < uList.size(); i++) {
					bw.write(uList.get(i).getName() + "," + uList.get(i).getHp() + "," + uList.get(i).getCompany());
					bw.newLine();
				}
				bw.close();

				System.out.println("[삭제되었습니다.]");
				break;
			}
			case 4: {
				System.out.println("<4.검색>");

				System.out.print(">이름 : ");
				String i_String = sc.next();
				for (int i = 0; i < uList.size(); i++) {
					if (uList.get(i).getName().contains(i_String)) {
						System.out.print(i + 1 + ".  ");
						uList.get(i).showList();
					}
				}

				break;
			}
			case 5: {
				System.out.println();
				System.out.println("***************************************");
				System.out.println("*             감사합니다.                *");
				System.out.println("***************************************");
				flag = false;
				break;
			}
			default: {
				System.out.println("[다시 입력해 주세요.]");
				break;
			}

			}

		}
		sc.close();
		br.close();
	}

}
