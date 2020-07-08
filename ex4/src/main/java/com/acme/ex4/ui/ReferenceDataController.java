package com.acme.ex4.ui;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.acme.ex3a.domain.entity.Contract;

@Controller("refData")
public class ReferenceDataController {

	public List<Contract> getContracts() {
		return Arrays.asList(new Contract(1, "Stage"), new Contract(2, "CDD"),
				new Contract(3, "CDI"));
	}
}
