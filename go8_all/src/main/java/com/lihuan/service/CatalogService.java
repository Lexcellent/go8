package com.lihuan.service;

import java.util.List;

import com.lihuan.pojo.Catalog;

public interface CatalogService {

	List<Catalog> getByPid(long pid);

	Catalog getById(Long id);

	void add(Catalog catalog);

	void update(Catalog catalog);

	void delete(Long id);

}
