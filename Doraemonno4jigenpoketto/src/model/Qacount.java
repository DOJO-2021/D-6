package model;


public class Qacount {
	private int count;

	//引数のあるコンストラクタ
	public Qacount(int count) {
		super();
		this.count = count;
	}
	//引数のないQaのコンストラクタ
	public Qacount() {
		super();
		this.count=0;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
