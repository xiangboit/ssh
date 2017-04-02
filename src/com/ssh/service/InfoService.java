package com.ssh.service;

import java.util.List;

import com.ssh.bean.Info;

public interface InfoService {
	
	public void save(Info info);
	
	public void update(Info info);
	
	public void delete(int id);
	
	public List<Info> getAll();
	
	public Info getById(int id);

	public long getRowCount(String sel);

	public List<Info> getAll(int pageSize, int pageNo, String sel);


	

	
}
