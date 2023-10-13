package com.example.team_pj_springboot.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "chatting_messages")
@Data
public class ChattingMessagesDTO {
	
	@Id
	private int m_id;
    private String sender; // 보낸 이 사원 id 참조
    private int chat_id; // 채팅방 id
    private String m_text; // 메시지 내용
    private char read; // 'Y' 또는 'N'
    private Timestamp send_date; // 보낸 시간

}
