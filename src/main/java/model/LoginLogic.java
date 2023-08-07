package model;

import java.util.regex.Pattern;

public class LoginLogic {
	
	  /*メソッド*/
    public boolean execute(User user) {
        // パスワードがnullまたは空文字の場合は不承認
        if (user.getpass() == null || user.getpass().isEmpty()) {
            return false;
        }
        
        // 英数字を含む8文字以上の正規表現パターン
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";
        
        // パスワードが指定されたパターンにマッチするかチェック
        if (Pattern.matches(passwordPattern, user.getpass())) {
            return true; // 承認
        }
        
        return false; // 不承認
    } 

}
