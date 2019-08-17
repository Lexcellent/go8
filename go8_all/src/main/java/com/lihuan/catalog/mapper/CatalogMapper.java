package com.lihuan.catalog.mapper;

import java.util.List;

import com.lihuan.catalog.pojo.Catalog;

public interface CatalogMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Catalog record);

	int insertSelective(Catalog record);

	Catalog selectByPrimaryKey(Long id);

	List<Catalog> selectByPid(Long pid);

	int updateByPrimaryKeySelective(Catalog record);

	int updateByPrimaryKey(Catalog record);
}