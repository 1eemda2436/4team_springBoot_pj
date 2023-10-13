package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "chatting_member")
@Data
public class ChattingDTO {
	
	@Id
	private int chat_id;
    private String chat_name;

}
