package ginkogyoumu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BunkRun {

	public static void main(String[] args) throws IOException {

		// 大型案件３．２ 入力値ミスのシステムエラー回避
		try {
			List<Property> propertyList = setProperty();

			// 大型案件３.７ ユーザリスト化
			for(int i=0;propertyList.size() > i;i++){
				System.out.println(i + "：" + propertyList.get(i).userName + "さん");
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("利用したいユーザの番号を入力して下さい");
			int user = Integer.parseInt(br.readLine());

			// 大型案件３.１ ３.６(BankMainのままだと初期化フラグを参照できない) ３.７
			MIZUHOBankMain bm = new MIZUHOBankMain("みずほ銀行", propertyList.get(user),108);
			bm.tourokuCheck();
			bm.uketuke();

			// 大型案件３.４ 送金
			if(bm.soukinFlg){
				for(int i=0;propertyList.size() > i;i++){
					if(propertyList.get(i).kouzabango.equals(bm.furikomiKouzaBangou)){
						propertyList.get(i).userBalance = propertyList.get(i).userBalance + bm.furikomiKingaku;
						propertyList.get(user).userBalance = propertyList.get(user).userBalance - 108 - bm.furikomiKingaku;
					}
				}
			}

			// 大型案件３.６ 初期化
			if(bm.syokikaFlg){
				propertyList = new ArrayList<Property>();
			}

			outputFile(propertyList);
		} catch(NumberFormatException e){
			System.out.println("数値を入力して下さい");
			System.out.println("処理を終了します");
		}
	}

	public static List<Property> setProperty() {
		List<Property> propertyList = new ArrayList<Property>();
		try {
			String path = System.getProperty("user.dir") + "\\src\\ginkogyoumu\\getUsersInfo.txt";
			File file = new File(path);

			if (!file.exists()) {
				System.out.print("ファイルがないんゴ");
				return null;
			}

			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String data;
			while ((data = bufferedReader.readLine()) != null) {
				String[] datas = data.split(",");
				Property prop = new Property(datas[0], Integer.parseInt(datas[1]), Integer.parseInt(datas[2]),
						Integer.parseInt(datas[3]),datas[4]);
				propertyList.add(prop);
			}

			bufferedReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return propertyList;

	}

	public static void outputFile(List<Property> propertyList) {
		PrintWriter pw = null;
		try {
			String path = System.getProperty("user.dir") + "\\src\\ginkogyoumu\\getUsersInfo.txt";
			FileWriter file = new FileWriter(path);
			pw = new PrintWriter(new BufferedWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; propertyList.size() > i; i++) {
			// ファイルに書き込む
			pw.print(propertyList.get(i).userName);
			pw.print(",");
			pw.print(propertyList.get(i).userBalance);
			pw.print(",");
			pw.print(propertyList.get(i).takarakuziFlg);
			pw.print(",");
			pw.print(propertyList.get(i).takarakuziTosenFlg);
			pw.print(",");
			pw.println(propertyList.get(i).kouzabango);
		}

		// ファイルを閉じる
		pw.close();

	}

}
