package com.lihuan.catalog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lihuan.catalog.pojo.Catalog;
import com.lihuan.catalog.service.CatalogService;
import com.lihuan.common.Result;

@RestController
@RequestMapping("/admin/catalog")
@CrossOrigin
public class CatalogController {

	private Logger logger = LoggerFactory.getLogger(CatalogController.class);

	@Autowired
	private CatalogService catalogService;

	/**
	 * 根据父id查找
	 * 
	 * @param pid
	 * @return
	 */
	@GetMapping("/{pid}")
	public Result<List<Catalog>> getCatalogByPid(@PathVariable long pid) {
		try {

			List<Catalog> list = catalogService.getByPid(pid);
			return Result.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("CatalogController getCatalogByPid()方法异常 --->" + pid);
			return Result.error();
		}
	}

	/**
	 * 查找单个
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findById/{id}")
	public Result<Catalog> getCatalogById(@PathVariable long id) {
		try {

			Catalog catalog = catalogService.getById(id);
			return Result.ok(catalog);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("CatalogController getCatalogById()方法异常 --->" + id);
			return Result.error();
		}
	}

	/**
	 * 新增
	 * 
	 * @param catalog
	 * @return
	 */
	@PostMapping
	public Result<Catalog> addCatalog(@RequestBody Catalog catalog) {
		try {
			catalogService.add(catalog);
			return Result.ok();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("CatalogController addCatalog()方法异常 --->" + catalog);
			return Result.error();
		}
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Result<Catalog> deleteCatalog(@PathVariable long id) {
		try {
			catalogService.delete(id);
			return Result.ok();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("CatalogController deleteCatalog()方法异常 --->" + id);
			return Result.error();
		}
	}

	/**
	 * 修改
	 * 
	 * @param catalog
	 * @return
	 */
	@PutMapping
	public Result<Catalog> updateCatalog(@RequestBody Catalog catalog) {
		try {
			catalogService.update(catalog);
			return Result.ok();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("CatalogController updateCatalog()方法异常 --->" + catalog);
			return Result.error();
		}
	}
}
