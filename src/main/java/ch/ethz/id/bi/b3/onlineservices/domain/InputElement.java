package ch.ethz.id.bi.b3.onlineservices.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class InputElement {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String label;
	private String explain;
	private String type;
	
	@ManyToMany(mappedBy = "inputElements")
	private Set<Page> pages = new HashSet<>();
	
	public InputElement() {
		super();
	}
	public InputElement(String label, String explain, String type) {
		super();
		this.label = label;
		this.explain = explain;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public String getLabel() {
		return label;
	}
	public String getExplain() {
		return explain;
	}
	public String getType() {
		return type;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<Page> getPages() {
		return pages;
	}
	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}
	@Override
	public String toString() {
		return "InputElement [id=" + id + ", label=" + label + ", explain=" + explain + ", type=" + type + ", pages="
				+ pages + "]";
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
		InputElement other = (InputElement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
