package model;
import java.io.Serializable;
import java.util.Date;
//質問と回答1行分のデータを持つ

public class Qaplus implements Serializable {
	  private int question_id;  //質問ID
	  private Date date;        //質問した日時
	  private String answerer;    //回答者
	  private String course; //コース
	  private String unit; //単元
	  private String category_item; //単元項目
	  private String textbook; //教科書
	  private String question; //質問内容
	  private String answer;   //回答内容
	  private int pageview;   //閲覧数
	  private String filename;
	  private String registrant;//登録者

	  //引数のないQaのコンストラクタ
	  public Qaplus() {
		  super();
		  this.question_id=0;
		  this.date=null;
		  this.answerer="";
		  this.course="";
		  this.unit="";
		  this.textbook="";
		  this.category_item="";
		  this.question="";
		  this.answer="";
		  this.pageview=0;
		  this.filename="";
		  this.registrant="";
	  }
	  //引数のあるQaのコンストラクタ
	  public Qaplus(int question_id,Date date,String answerer,String course, String unit, String category_item, String textbook, String question,String answer,int pageview,String filename,String registrant) {
		  super();
		  this.question_id=question_id;
		  this.date=date;
		  this.answerer=answerer;
		  this.category_item=category_item;
		  this.course=course;
		  this.unit=unit;
		  this.textbook=textbook;
		  this.question=question;
		  this.answer=answer;
		  this.pageview=pageview;
		  this.filename=filename;
		  this.registrant=registrant;
	  }

	  //getterとsetterの設定
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAnswerer() {
		return answerer;
	}
	public void setAnswerer(String answerer) {
		this.answerer = answerer;
	}
	public String getCategory_item() {
		return category_item;
	}
	public void setCategory_id(String category_item) {
		this.category_item = category_item;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getPageview() {
		return pageview;
	}
	public void setPageview(int pageview) {
		this.pageview = pageview;
	}
	public String getRegistrant() {
		return registrant;
	}
	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getTextbook() {
		return textbook;
	}
	public void setTextbook(String textbook) {
		this.textbook = textbook;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}


	}

/*public class Qaplus implements Serializable {
  private int question_id;  //質問ID
  private Date date;        //質問した日時
  private String answerer;    //回答者
  private String course; //コース
  private String unit; //単元
  private String category_item; //単元項目
  private String textbook; //教科書
  private String question; //質問内容
  private String answer;   //回答内容
  private int pageview;   //閲覧数
  private String registrant;//登録者

  //引数のないQaのコンストラクタ
  public Qaplus() {
	  super();
	  this.question_id=0;
	  this.date=null;
	  this.answerer="";
	  this.course="";
	  this.unit="";
	  this.textbook="";
	  this.category_item="";
	  this.question="";
	  this.answer="";
	  this.pageview=0;
	  this.registrant="";
  }
  //引数のあるQaのコンストラクタ
  public Qaplus(int question_id,Date date,String answerer,String course, String unit, String category_item, String textbook, String question,String answer,int pageview,String registrant) {
	  super();
	  this.question_id=question_id;
	  this.date=date;
	  this.answerer=answerer;
	  this.category_item=category_item;
	  this.course=course;
	  this.unit=unit;
	  this.textbook=textbook;
	  this.question=question;
	  this.answer=answer;
	  this.pageview=pageview;
	  this.registrant=registrant;
  }

  //getterとsetterの設定
public int getQuestion_id() {
	return question_id;
}
public void setQuestion_id(int question_id) {
	this.question_id = question_id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getAnswerer() {
	return answerer;
}
public void setAnswerer(String answerer) {
	this.answerer = answerer;
}
public String getCategory_item() {
	return category_item;
}
public void setCategory_id(String category_item) {
	this.category_item = category_item;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}

public int getPageview() {
	return pageview;
}
public void setPageview(int pageview) {
	this.pageview = pageview;
}
public String getRegistrant() {
	return registrant;
}
public void setRegistrant(String registrant) {
	this.registrant = registrant;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public String getTextbook() {
	return textbook;
}
public void setTextbook(String textbook) {
	this.textbook = textbook;
}


}*/