package com.eras.erasweb.model;

public enum Growth {
	SMALL(1),
	  MEDIUM(2),
	  LARGE(3);
	 private final int value;

	 Growth(int value) {
	    this.value = value;
	  }

	  public int getValue() {
	    return value;
	  }
}
