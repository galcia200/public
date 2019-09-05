package ginkogyoumu;

public class Property {

	public String userName = "";
	public int userBalance = 0;
	public int takarakuziFlg = 0;
	public int takarakuziTosenFlg = 0;
	// 大型案件３.４送金
	public String kouzabango = "";

	// 大型案件３.４送金
	Property(String str1,int int1,int int2,int int3,String kouzabango) {
		userName = str1;
		userBalance = int1;
		takarakuziFlg = int2;
		takarakuziTosenFlg = int3;
		// 大型案件３.４送金
		this.kouzabango = kouzabango;
	}

}
