package ch.ethz.id.bi.b3.onlineservices.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Page {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String description;
	
	@ManyToMany
	@JoinTable(name = "page_inputelement", joinColumns = @JoinColumn(name = "inputelement_id"), inverseJoinColumns = @JoinColumn(name = "page_id"))
	private Set<InputElement> inputElements = new HashSet<>();

	public Page() {
		super();
	}

	public Page(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<InputElement> getInputElements() {
		return inputElements;
	}

	public void setInputElements(Set<InputElement> inputElements) {
		this.inputElements = inputElements;
	}

	@Override
	public String toString() {
		return "Page [id=" + id + ", name=" + name + ", description=" + description + ", inputElements=" + inputElements
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
