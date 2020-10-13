package net.simpleLearn.hibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "air_lines")
public class AirLines implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "air_line_name")
	private String airLineName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirLineName() {
		return airLineName;
	}

	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "airLines")
	private List<Flights> fligth = new ArrayList<Flights>();

	public List<Flights> getFligth() {
		return fligth;
	}

	public void setFligth(List<Flights> fligth) {
		this.fligth = fligth;
	}

}
