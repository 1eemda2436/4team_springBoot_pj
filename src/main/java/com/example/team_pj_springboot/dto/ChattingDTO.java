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
	private int 	chat_id;		// 채팅방 ID [ 구분용 ]
    private String 	chat_name;		// 채팅방 이름

}
