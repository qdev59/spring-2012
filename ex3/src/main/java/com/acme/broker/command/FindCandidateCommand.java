package com.acme.broker.command;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import com.acme.common.broker.AbstractCommand;
import com.acme.ex3a.domain.business.filter.CandidateFilter;
import com.acme.ex3a.domain.entity.Candidate;

@RolesAllowed("ROLE_1")
public class FindCandidateCommand extends AbstractCommand {

	private static final long serialVersionUID = -7211206470077379528L;

	public FindCandidateCommand() {
		super(true);
	}

	private Integer id;
	private CandidateFilter filter;
	private Candidate singleResult;
	private List<Candidate> multipleResults;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CandidateFilter getFilter() {
		return filter;
	}

	public void setFilter(CandidateFilter filter) {
		this.filter = filter;
	}

	public Candidate getSingleResult() {
		return singleResult;
	}

	public void setSingleResult(Candidate singleResult) {
		this.singleResult = singleResult;
	}

	public List<Candidate> getMultipleResults() {
		return multipleResults;
	}

	public void setMultipleResults(List<Candidate> multipleResults) {
		this.multipleResults = multipleResults;
	}
}
