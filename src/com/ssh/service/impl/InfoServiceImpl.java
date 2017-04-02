package com.ssh.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ssh.bean.Info;
import com.ssh.service.InfoService;

@SuppressWarnings("unchecked")
public class InfoServiceImpl implements InfoService {
	
	private SessionFactory sessionFactory;
	@Override
	public void save(Info info) {
		
		sessionFactory.getCurrentSession().save(info);
	}

	@Override
	public void update(Info info) {
		sessionFactory.getCurrentSession().update(info);
	}

	@Override
	public void delete(int id) {
	 	Object obj=sessionFactory.getCurrentSession().get(Info.class, id);
	 	sessionFactory.getCurrentSession().delete(obj);
	}

	
	@Override
	public List<Info> getAll() {
		List<Info> infolist=sessionFactory.getCurrentSession().createQuery(//
				"FROM Info ")
				.list();
		return infolist;
	}

	@Override
	public Info getById(int id) {
		
		return (Info) sessionFactory.getCurrentSession().get(Info.class, id);
	}
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public long getRowCount(String sel) {
		String hql="SELECT COUNT(*) FROM Info WHERE 1=1 ";
		if(sel!=null){
			hql+=" AND name LIKE '%" +sel+"%'";
		}
		System.out.println(hql);
		Object obj=  sessionFactory.getCurrentSession().createQuery(hql)
		.list()
		.get(0);
		Long count=(Long)obj;
		return count;
	}

	@Override
	public List<Info> getAll(int pageSize, int pageNo, String sel) {
		String hql="FROM Info WHERE 1=1 ";
		if(sel!=null){
			hql+=" AND name LIKE '%" +sel+"%'";
		}
		List<Info> listinfo=sessionFactory.getCurrentSession().createQuery(//
				hql)
				.setFirstResult(pageSize*(pageNo-1))
				.setMaxResults(pageSize)
				.list();
		return listinfo;
	}

	

	
	
}
