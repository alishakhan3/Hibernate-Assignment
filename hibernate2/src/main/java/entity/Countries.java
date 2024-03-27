package entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "countries")
    private List<Netflix> netflixAccounts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Netflix> getNetflixAccounts() {
		return netflixAccounts;
	}

	public void setNetflixAccounts(List<Netflix> netflixAccounts) {
		this.netflixAccounts = netflixAccounts;
	}

	@Override
	public String toString() {
		return "Countries [id=" + id + ", name=" + name + ", netflixAccounts=" + netflixAccounts + "]";
	}
}

