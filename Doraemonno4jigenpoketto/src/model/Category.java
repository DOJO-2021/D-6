package model;
import java.io.Serializable;

//単元項目1行分のデータを持つ
public class Category implements Serializable{

	private int course_id;
	private int unit_id;
	private int category_id;
	private String category_item;

//引数のないCategoryのコンストラクタ
public Category() {
	super();
	this.course_id=0;
	this.unit_id=0;
	this.category_id=0;
	this.category_item="";
}


//引数のあるCategoryのコンストラクタ
public Category(int course_id,int unit_id, int category_id,String category_item) {
super();
this.course_id=course_id;
this.unit_id=unit_id;
this.category_id=category_id;
this.category_item=category_item;
}

//getterとsetterの設定
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_item() {
		return category_item;
	}
	public void setCategory_item(String category_item) {
		this.category_item = category_item;
	}

}
