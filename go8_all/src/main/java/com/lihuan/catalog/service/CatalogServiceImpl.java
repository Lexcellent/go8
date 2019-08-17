package com.lihuan.catalog.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lihuan.catalog.mapper.CatalogMapper;
import com.lihuan.catalog.pojo.Catalog;

@Service
public class CatalogServiceImpl implements CatalogService {
	@Autowired
	private CatalogMapper catalogMapper;

	private Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

	@Override
	public List<Catalog> getByPid(long pid) {
		return catalogMapper.selectByPid(pid);
	}

	@Override
	public void add(Catalog catalog) {
		try {
			Date date = new Date();
			catalog.setGmtCreate(date);
			catalog.setGmtModified(date);

			catalogMapper.insertSelective(catalog);
		} catch (Exception e) {
			logger.error("CatalogServiceImpl add()方法  异常  --->" + catalog);
			throw e;
		}
	}

	@Override
	public void update(Catalog catalog) {
		try {
			catalog.setGmtModified(new Date());
			catalogMapper.updateByPrimaryKeySelective(catalog);
		} catch (Exception e) {
			logger.error("CatalogServiceImpl update()方法  异常  --->" + catalog);
			throw e;
		}
	}

	@Override
	public Catalog getById(Long id) {
		return catalogMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(Long id) {
		try {
			catalogMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("CatalogServiceImpl delete()方法  异常  --->" + id);
			throw e;
		}
	}

}
