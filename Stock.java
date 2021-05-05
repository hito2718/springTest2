package com.example.demo;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	    @Id
	    @Column(nullable = false)
		private Date date;
	    @Column(nullable = false)
		private int high;
	    @Column(nullable = false)
		private int low;
	    @Column(nullable = false)
		private int open;
	    @Column(nullable = false)
		private int close;
	    @Column(nullable = false)
		private int volume;
	    @Column(nullable = false)
		private int adjclose;
		



}
