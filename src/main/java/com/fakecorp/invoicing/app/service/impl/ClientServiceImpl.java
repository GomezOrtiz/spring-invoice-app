package com.fakecorp.invoicing.app.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fakecorp.invoicing.app.model.dao.ClientDao;
import com.fakecorp.invoicing.app.model.entity.Client;
import com.fakecorp.invoicing.app.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;

	@Override
	@Transactional(readOnly=true)
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<Client> getClientsByPage(int numPage, int maxPages) {
		Pageable pageRequested = PageRequest.of(numPage, maxPages);
		return clientDao.findAll(pageRequested);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<Client> getClientsByNameAndPage(String name, int numPage, int maxPages) {
		Pageable pageRequested = PageRequest.of(numPage, maxPages);
		return clientDao.findAllByNameContainsIgnoreCase(name, pageRequested);
	}

	@Override
	@Transactional(readOnly=true)
	public Client findById(Long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Client> findByName(String name) {
		return clientDao.findByName(name);
	}

	@Override
	@Transactional
	public void create(Client client) {
		client.setCreatedAt(new Date());
		clientDao.save(client);
	}
		
	@Override
	@Transactional
	public void update(Client client) {
		if(!clientDao.findById(client.getId()).isEmpty()) {
			client.setUpdatedAt(new Date());
			clientDao.save(client);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		if(!clientDao.findById(id).isEmpty()) {
			clientDao.deleteById(id);
		}
	}

}
