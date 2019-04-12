package com.karangoel16.quotes;

public class Response{
	private String character;
	private String quote;

	public void setCharacter(String character){
		this.character = character;
	}

	public String getCharacter(){
		return character;
	}

	public void setQuote(String quote){
		this.quote = quote;
	}

	public String getQuote(){
		return quote;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"character = '" + character + '\'' + 
			",quote = '" + quote + '\'' + 
			"}";
		}
}
