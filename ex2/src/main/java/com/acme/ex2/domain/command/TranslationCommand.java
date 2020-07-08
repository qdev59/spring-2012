package com.acme.ex2.domain.command;

import com.acme.ex2.domain.entity.Word;

public class TranslationCommand {
	private Word input;
	private Word output;

	public TranslationCommand(Word wordIn, Word wordOut) {
		this.input = wordIn;
		this.output = wordOut;
	}

	public String getLangIn() {
		return this.input.getLang();
	}

	public String getLangOut() {
		return this.output.getLang();
	}

	public Word getInput() {
		return input;
	}

	public Word getOutput() {
		return output;
	}
}
