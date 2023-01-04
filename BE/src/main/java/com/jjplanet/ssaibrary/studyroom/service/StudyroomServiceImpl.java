package com.jjplanet.ssaibrary.studyroom.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.exception.NotFoundException;
import com.jjplanet.ssaibrary.studyroom.domain.Studyroom;
import com.jjplanet.ssaibrary.studyroom.dto.StudyroomDTO;
import com.jjplanet.ssaibrary.studyroom.repository.StudyroomRepository;

@Service
public class StudyroomServiceImpl implements StudyroomService {

	@Autowired
	private StudyroomRepository studyroomRepository;

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
		Studyroom studyroom = studyroomRepository.findById(id).orElseThrow(NotFoundException::new);
		StudyroomDTO studyroomDTO = new StudyroomDTO(studyroom.getId(), studyroom.getFloor(), studyroom.getSize(),
				studyroom.getMaxUser(), studyroom.getStatus());
		return studyroomDTO;
	}

	@Override
	public void insertStudyroom(StudyroomDTO studyroomDTO) throws Exception {
		Studyroom studyroom = new Studyroom(studyroomDTO.getId(), studyroomDTO.getFloor(), studyroomDTO.getSize(),
				studyroomDTO.getMaxUser(), studyroomDTO.getStatus());
		studyroomRepository.save(studyroom);
	}

	@Override
	public void updateStudyroom(StudyroomDTO studyroomDTO) throws Exception {
		Studyroom updateStudyroom = studyroomRepository.findById(studyroomDTO.getId())
				.orElseThrow(NotFoundException::new);

//		updateStudyroom.setFloor(studyroomDTO.getFloor());
//		updateStudyroom.setSize(studyroomDTO.getSize());
//		updateStudyroom.setMaxUser(studyroomDTO.getMaxUser());
//		updateStudyroom.setStatus(studyroomDTO.getStatus());
		studyroomRepository.save(updateStudyroom);
	}

	@Override
	public void deleteStudyroom(Long id) throws Exception {
		studyroomRepository.deleteById(id);
	}
}
