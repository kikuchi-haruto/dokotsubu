package model;

//オブジェクトをバイトストリームに変換
import java.io.Serializable;

/*つぶやきに関する情報をもつJavabeans*/
public class Mutter implements Serializable {

	/*フィールド*/
	private String userName;//ユーザー名
	private String text;    //つぶやき内容

	/*デフォルトコンストラクタ*/
	public Mutter() {}
	
	/*コンストラクタ（引き数あり）*/
	public Mutter (String userName,String text) {
		this.userName = userName;
		this.text = text;
	}
	
	/*メソッド(getter)*/
	public String getUserName() {
		return userName;
	}
	
	public String getText() {
		return text;
	}
}
