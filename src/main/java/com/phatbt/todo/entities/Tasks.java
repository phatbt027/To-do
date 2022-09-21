package com.phatbt.todo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TASK")
@Data
public class Tasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column(name = "task_name", nullable = false)
	private String taskName;
	
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "finished")
	private boolean finished;
}
