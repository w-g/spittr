package spittr.repository.jdbc;

//import org.springframework.stereotype.Repository;

import spittr.entity.Spitter;
import spittr.repository.SpitterRepository;
import spittr.utils.JDBCUtils;

//@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

	@Override
	public void createSpitter(Spitter spitter) {
		
		String insertSpitterSql = String.format("insert into spitter(id, firstName, lastName, username, password) "
				+ "values(%s, '%s', '%s', '%s', '%s')", 
				spitter.getId(), spitter.getFirstName(), spitter.getLastName(), spitter.getUsername(), spitter.getPassword());
		
		String insertSpittleSql = String.format("insert into spittle(id, message, time, latitude, longitude) "
				+ "values(%s, '%s', '%s', %s, %s)", 
				6, "lalala6", "2017-08-14 16:17", 0.0, 0.0);
		
		JDBCUtils.executeNonQuery(insertSpitterSql, insertSpittleSql);
	}

	@Override
	public Spitter getSpitterByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
