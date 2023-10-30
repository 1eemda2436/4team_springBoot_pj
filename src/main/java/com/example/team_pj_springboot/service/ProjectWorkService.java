package com.example.team_pj_springboot.service;

import java.util.List;
import com.example.team_pj_springboot.dto.ProjectWorkDTO;

public interface ProjectWorkService {
	
	public List<ProjectWorkDTO> list(int pj_id);
	
	public void save(ProjectWorkDTO dto);
	
	public void saveComplete(int pw_id, String complete);
	
	public ProjectWorkDTO get(int pw_id);
	
	public void delete(int pw_id);

}
