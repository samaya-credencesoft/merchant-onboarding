package com.csoft.payone.auth.user;
import com.csoft.payone.Application;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Role() {
        super();
    }

    public Role(final String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

	@ManyToMany(mappedBy = "roles")
	transient private List<ApplicationUser> users;

    public void setName(final String name) {
        this.name = name;
    }
	public List<ApplicationUser> getUsers() {
		return users;
	}

	public void setUsers(List<ApplicationUser> users) {
		this.users = users;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Role role = (Role) o;
		return Objects.equals(id, role.id) &&
				Objects.equals(name, role.name);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name);
	}
/*
	@Override
	public String toString() {
		return "{" +
				"name:" + name + '\'' +
				'}';
	} */
	@Override
	public String toString() {
		return new StringBuilder()
				.append("{")
				.append("name:"+name)
				.append("}")
				.toString();
	}
}
