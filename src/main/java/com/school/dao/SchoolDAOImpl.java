package com.school.dao;

import com.school.model.School;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hga
 * Date: 7/2/15
 * Time: 1:44 AM
 * implementation of SchoolDAO.
 */

public class SchoolDAOImpl implements SchoolDAO {

	private JdbcTemplate jdbcTemplate;

	public SchoolDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

@Override
	public void saveOrUpdate(School school) {
		if (school.getId() > 0) {
			// update
			String sql = "UPDATE school SET name=?, code=?, address=?, "
						+ "emailDomain=? WHERE _id=?";
			jdbcTemplate.update(sql, school.getName(), school.getCode(),
                    school.getAddress(), school.getEmailDomain(), school.getId());
		} else {
			// insert
			String sql = "INSERT INTO school (name, code, address, emailDomain)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, school.getName(), school.getCode(),
                    school.getAddress(), school.getEmailDomain());
		}

	}

	@Override
	public void delete(int schoolId) {
		String sql = "DELETE FROM school WHERE _id=?";
		jdbcTemplate.update(sql, schoolId);
	}

	@Override
	public List<School> list() {
		String sql = "SELECT * FROM school";
		List<School> listSchool = jdbcTemplate.query(sql, new RowMapper<School>() {

			@Override
			public School mapRow(ResultSet rs, int rowNum) throws SQLException {
				School aSchool = new School();

				aSchool.setId(rs.getInt("_id"));
				aSchool.setName(rs.getString("name"));
				aSchool.setCode(rs.getString("code"));
				aSchool.setAddress(rs.getString("address"));
				aSchool.setEmailDomain(rs.getString("emailDomain"));

				return aSchool;
			}

		});

		return listSchool;
	}

	@Override
	public School get(int schoolId) {
		String sql = "SELECT * FROM school WHERE _id=" + schoolId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<School>() {

			@Override
			public School extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
				if (rs.next()) {
					School school = new School();
					school.setId(rs.getInt("_id"));
					school.setName(rs.getString("name"));
					school.setCode(rs.getString("code"));
					school.setAddress(rs.getString("address"));
					school.setEmailDomain(rs.getString("emailDomain"));
					return school;
				}

				return null;
			}

		});
	}
}