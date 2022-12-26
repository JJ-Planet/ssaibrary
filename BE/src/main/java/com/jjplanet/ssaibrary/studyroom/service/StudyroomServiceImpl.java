package com.jjplanet.ssaibrary.studyroom.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.studyroom.domain.Studyroom;
import com.jjplanet.ssaibrary.studyroom.dto.StudyroomDTO;
import com.jjplanet.ssaibrary.studyroom.repository.StudyroomRepository;

@Service
public class StudyroomServiceImpl implements StudyroomService {

	@Autowired
	private StudyroomRepository studyroomRepository;

	@Override
	public void insertStudyroom(Studyroom studyroom) throws Exception {
		studyroomRepository.save(studyroom);
	}

	@Override
	public void updateStudyroom(Studyroom studyroom) throws Exception {
		Studyroom updateStudyroom = studyroomRepository.findOneById(studyroom.getId());

		// if updateStudyroom == null

		updateStudyroom.setFloor(studyroom.getFloor());
		updateStudyroom.setSize(studyroom.getSize());
		updateStudyroom.setMaxUser(studyroom.getMaxUser());
		updateStudyroom.setStatus(studyroom.getStatus());
		studyroomRepository.save(updateStudyroom);
	}

	@Override
	public List<StudyroomDTO> findAllStudyroom() throws Exception {
		List<Studyroom> studyroomList = studyroomRepository.findAll();
		List<StudyroomDTO> studyroomDTOList = new LinkedList<>();
		for (Studyroom s : studyroomList) {
			studyroomDTOList.add(new StudyroomDTO(s.getId(), s.getFloor(), s.getSize(), s.getMaxUser(), s.getStatus()));
		}
		return studyroomDTOList;
	}

	@Override
	public StudyroomDTO findStudyroomById(Long id) throws Exception {
		Studyroom studyroom = studyroomRepository.findOneById(id);
		StudyroomDTO studyroomDTO = new StudyroomDTO(studyroom.getId(), studyroom.getFloor(), studyroom.getSize(),
				studyroom.getMaxUser(), studyroom.getStatus());
		return studyroomDTO;
	}

	@Override
	public void deleteStudyroom(Long id) throws Exception {
		studyroomRepository.deleteById(id);
	}
}
