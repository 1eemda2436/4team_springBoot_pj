package com.example.team_pj_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "chatting_member")
@Data
public class ChattingMemberDTO {
	
	@Id
	private int 	cm_id;		// 참가자 ID [ 구분용 ]
    private String 	id; 		// 사원 ID
    private int 	chat_id; 	// 채팅방 ID [ 구분용 ]
}
