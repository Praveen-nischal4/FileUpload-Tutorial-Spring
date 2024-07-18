package com.myProject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.myProject.Dto.InformationDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class InformationDAOImpl implements InformationDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int saveData(InformationDTO informationDTO) {
		
		String sql ="insert into information (name,age,photo) values (?,?,?) ";
	 	jdbcTemplate.update(sql,informationDTO.getName(),informationDTO.getAge(),informationDTO.getPhoto());
	 	
	 	KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, informationDTO.getName());
            ps.setInt(2, informationDTO.getAge());
            ps.setBytes(3, informationDTO.getPhoto());
            return ps;
        }, keyHolder);

        // Retrieve the generated key
        return keyHolder.getKey().intValue();
	}

	@Override
	public InformationDTO getUserDEtails(int rollno) {
	
		String sql ="select name,age,photo from information where rollno = ?";
		
		return  jdbcTemplate.queryForObject(sql, new Object[] {rollno}, new InfoRowMapper());
	}
	
	
	public class InfoRowMapper implements RowMapper<InformationDTO>
	{

		@Override
		public InformationDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			InformationDTO infoDTO = new InformationDTO();
			infoDTO.setName(rs.getString("name"));
			infoDTO.setAge(rs.getInt("age"));
			infoDTO.setPhoto(rs.getBytes("photo"));
			
			return infoDTO;
		}
		
	}

}
