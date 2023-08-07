package model;
//オブジェクトの状態をStreamの状態に変換させる
import java.io.Serializable;

/*ユーザーに関する情報をもつjavaBeans*/
public class User implements  Serializable{
	private String name; //ユーザー名
	private String pass; //パスワード
	
	/*デフォルトコンストラクタ*/
	public User() {}
	/*コンストラクタ（引き数を受け取る）*/
	public User(String name,String pass) {
		this.name = name;
		this.pass = pass;
	}
	
	/*メソッド (getter)*/
	public String getNmae() {
		return name;
	}
	public String getpass() {
		return pass;
	}
	

}
