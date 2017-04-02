package com.ssh.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.Info;
import com.ssh.service.InfoService;

@SuppressWarnings("serial")
public class InfoAction extends ActionSupport implements ModelDriven<Info>{

	private Info info;
	private InfoService infoService;
	private int pageNo;//第几页
	private int pageSize;//一页几行
	private int rowcount;//总行数
	private String sel;
	
	public String list() throws Exception {
		
		List<Info> infolist=infoService.getAll(pageSize,pageNo,sel);
		
		rowcount=(int) infoService.getRowCount(sel);
		//总页数
		int pageCount=rowcount%pageSize==0? rowcount/pageSize:rowcount/pageSize+1;
		
		ActionContext.getContext().put("infolist", infolist);
		
		ActionContext.getContext().put("pageCount", pageCount);
		
		return "list";
	}
	
	public String addUI() throws Exception {
		
		return "addUI";
	}

	public String add() throws Exception {
		infoService.save(info);
		return "tolist";
	}
	public String updateUI() throws Exception {
		Info infos=infoService.getById(info.getId());
		ActionContext.getContext().getValueStack().push(infos);
		return "updateUI";
	}
	public String update() throws Exception {
		Info infos=infoService.getById(info.getId());
		infos.setName(info.getName());
		infos.setAge(info.getAge());
		infos.setAddress(info.getAddress());
		infoService.update(infos);
		
		return "tolist";
	}
	public String delete() throws Exception {
		
		infoService.delete(info.getId());
		return "tolist";
	}
	//===========================
	@Override
	public Info getModel() {
		info=new Info();
		return info;
	}
	public InfoService getInfoService() {
		return infoService;
	}
	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowcount() {
		return rowcount;
	}
	public void setRowcount(int rowcount) {

		this.rowcount = rowcount;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}
	
}
