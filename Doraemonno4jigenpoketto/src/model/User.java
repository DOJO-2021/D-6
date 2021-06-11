package model;
import java.io.Serializable;

//事務局ログイン1行分のデータを持つ
public class User implements Serializable {
		private String id; //ID
		private String pass; //pw

//引数のないuserのコンストラクタ
		public User() {
			 this.id="";
			 this.pass="";
	    }

//引数のあるUserのコンストラクタ
		public User(String id ) {
			this.id=id;

		}

//getterとsetterの設定
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id=id;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass=pass;
		}
}
