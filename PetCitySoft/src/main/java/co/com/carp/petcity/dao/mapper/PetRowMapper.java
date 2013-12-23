package co.com.carp.petcity.dao.mapper;

import java.awt.Image;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import co.com.carp.petcity.dao.PetBreedDao;
import co.com.carp.petcity.entity.Pet;
import co.com.carp.petcity.entity.PetBreed;

public class PetRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {
		PetResultSetExtractor extractor = new PetResultSetExtractor();
		return extractor.extractData(rs);
	}

}

class PetResultSetExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException {
		int identification = rs.getInt(1);
		String name = rs.getString(2);
		String color = rs.getString(3);
		String sex = rs.getString(4);
		Date bornDate = rs.getDate(5);
		String bornPlace = rs.getString(6);
		String reproductionState = rs.getString(7);
		Image photo = null;
		try {
			Blob blob = rs.getBlob(8);
			if (blob != null)
				photo = ImageIO.read(rs.getBlob(8).getBinaryStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int idPetBreed = rs.getInt(9);
		int idOwner = rs.getInt(10);
		
		PetBreedDao petBreedDao = new PetBreedDao();
		List<PetBreed> petBreedList = petBreedDao.select(idPetBreed);
		
		if (petBreedList == null || petBreedList.size() == 0) {
			return null;
		} else {
			return new Pet(identification, name, color, sex, bornDate, bornPlace, reproductionState,
					photo, petBreedList.get(0), idOwner);
		}
	}

}
