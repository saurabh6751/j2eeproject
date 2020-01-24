package com.app.pojos;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "news")
public class News {
	private Integer Id;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date date;
	private String category;
	private String heading;
	private byte[] image;
	private String description;
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(Date date, String category, String heading, String description) {
		super();
		this.date = date;
		this.category = category;
		this.heading = heading;
		this.description = description;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "news_id")
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name ="news_date" )
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(name ="news_category" )
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Column(name ="news_heading")
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	@Lob
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Column(name ="news_description",length = 2000)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "News [Id=" + Id + ", date=" + date + ", category=" + category + ", heading=" + heading + ", image="
				+ Arrays.toString(image) + ", description=" + description + "]";
	}
	
	

}