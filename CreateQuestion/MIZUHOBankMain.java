package ginkogyoumu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MIZUHOBankMain extends BankMain {

	// 大型案件３.４送金
	public boolean soukinFlg = false;
	public String furikomiKouzaBangou = "";
	public int furikomiKingaku = 0;

	// 大型案件３.５ 初期化
	public boolean syokikaFlg = false;


	public MIZUHOBankMain(String name, Property prop, int tax) {
		super(name, prop, tax);
	}

	// 大型案件３.３ 残高照会
	public void zandakaSyoukai()  {
		System.out.println("現在の残高：" + prop.userBalance);
	}

	// 大型案件３.４送金
	public void soukin() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("送金先の口座番号を入力してください");
			furikomiKouzaBangou = br.readLine();
			System.out.println("送金金額を入力してください");
			furikomiKingaku = Integer.parseInt(br.readLine());
		} catch(IOException e){
			System.out.println("起こらないエラー");
		}
		soukinFlg = true;
	}

	// 大型案件３.５ 宝くじ購入
	public void takarakuziKounyu()  {
		if(prop.takarakuziFlg == 1){
			System.out.println("既に購入しています");
			return;
		}
		System.out.println("宝くじを購入しました");
		prop.takarakuziFlg = 1;
		prop.userBalance = prop.userBalance - 300;
	}

	// 大型案件３.６ 初期化
	public void syokika()  {
		syokikaFlg = true;
	}
}

