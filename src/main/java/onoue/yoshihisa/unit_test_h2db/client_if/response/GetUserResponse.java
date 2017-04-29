package onoue.yoshihisa.unit_test_h2db.client_if.response;

import java.io.Serializable;

public class GetUserResponse extends Response implements Serializable {
	private static final long serialVersionUID = 4722150550565982178L;

	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
