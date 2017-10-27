package bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class CityBean {

	@Id
	/*
	 * @GeneratedValue(generator="increment")
	 * @GenericGenerator(name="increment", strategy = "increment")
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;
	private String cityName;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private Collection<UserBean> users = new ArrayList<UserBean>();

	public int getCityId() {
		return cityId;
	}

	public Collection<UserBean> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserBean> users) {
		this.users = users;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
