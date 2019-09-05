package ginkogyoumu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankMain {

	private String companyName;
	private int tax;
	public Property prop;

	public BankMain(String name,Property prop,int tax){
		companyName = name;
		this.prop = prop;
		this.tax = tax;
	}

	private void aisatu() {
		System.out.println("いらっしゃいませ！" + companyName + "へようこそ！");
		System.out.println("");
	}

	private void syukkin() throws NumberFormatException, IOException {
		prop.userBalance = prop.userBalance - (nyuryoku() + tax);
	}

	private void nyukin() throws NumberFormatException, IOException {
		prop.userBalance = prop.userBalance + (nyuryoku() - tax);
	}

	private int nyuryoku() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("金額を入力して下さい");
		int input = 0;
		input = Integer.parseInt(br.readLine());
		return input;
	}

	public void tourokuCheck() throws IOException{
		aisatu();
		if(prop.userName.equals("")){
			System.out.println("お名前を登録して下さい");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			prop.userName = br.readLine();
		} else {
			System.out.println("こんにちは" + prop.userName + "さん！");
		}
	}

	public void uketuke() throws IOException{
		System.out.println("");
		System.out.println("業務を入力して下さい  1：入金 2：出金 3：残高照会 4：送金 5：宝くじ購入  6：宝くじ抽選 7：初期化");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputNum = br.readLine();
		if("1".equals(inputNum)){
			nyukin();
		} else if("2".equals(inputNum)){
			syukkin();
		} else if("3".equals(inputNum)){
			zandakaSyoukai();
		} else if("4".equals(inputNum)){
			soukin();
		} else if("5".equals(inputNum)){
			takarakuziKounyu();
		} else if("6".equals(inputNum)){
			takarakuziTyusen();
		} else if("7".equals(inputNum)){
			syokika();
		}
		System.out.println("ありがとうございました。");
	}

	public void zandakaSyoukai()  {
		System.out.println("現在この業務は取り扱っていません");
		System.out.println("");
	}

	public void soukin() {
		System.out.println("現在この業務は取り扱っていません");
		System.out.println("");
	}

	public void takarakuziKounyu() {
		System.out.println("現在この業務は取り扱っていません");
		System.out.println("");
	}

	public void takarakuziTyusen() {
		System.out.println("現在この業務は取り扱っていません");
		System.out.println("");
	}

	public void syokika() {
		System.out.println("現在この業務は取り扱っていません");
		System.out.println("");
	}

	public boolean isDefalut(Object obj){
		// 引数が空の場合
		if(!"".equals(obj.toString())){
			return true;
		// 引数が0の場合
		} else if("0".equals(obj.toString())){
			return true;
		}
		return false;
	}
}

