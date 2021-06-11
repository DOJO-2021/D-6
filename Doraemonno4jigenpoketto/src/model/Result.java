package model;

import java.io.Serializable;

public class Result implements Serializable{
	private String result;

	//引数のないコンストラクタ
	public Result() {
		super();
		this.result="";
	}

	public Result(String result) {
		this.result=result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
