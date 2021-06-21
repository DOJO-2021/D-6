package model;

import java.io.Serializable;
import java.util.Date;

public class Qaall implements Serializable {
	  private int question_id;  //質問ID
	  private Date date;        //質問した日時
	  private String answerer;    //回答者
	  private int category_id; //単元項目ID
	  private String question; //質問内容
	  private String answer;   //回答内容
	  private int pageview;   //閲覧数
	  private String filename;
	  private String registrant;//登録者

	  //引数のないQaのコンストラクタ
	  public Qaall() {
		  super();
		  this.question_id=0;
		  this.date=null;
		  this.answerer="";
		  this.category_id=0;
		  this.question="";
		  this.answer="";
		  this.pageview=0;
		  this.filename="";
		  this.registrant="";
	  }
	  //引数のあるQaのコンストラクタ
	  public Qaall(int question_id,Date date,String answerer,int category_id,String question,String answer,int pageview,String filename,String registrant) {
		  super();
		  this.question_id=question_id;
		  this.date=date;
		  this.answerer=answerer;
		  this.category_id=category_id;
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
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}


	}
