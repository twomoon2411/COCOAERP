package kh.cocoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.cocoa.dao.TemplatesDAO;
import kh.cocoa.dto.TemplatesDTO;

@Service
public class TemplatesService implements TemplatesDAO{
	
	@Autowired
	private TemplatesDAO tdao;
	
	@Override
	public List<TemplatesDTO> getTemplateList() {
		return tdao.getTemplateList();
	}
	
	@Override
	public List<TemplatesDTO> getSubTemplateList() {
		return tdao.getSubTemplateList();
	}

}
