package com.jjplanet.ssaibrary.room.controller;

import com.jjplanet.ssaibrary.room.dto.RoomDTO;
import com.jjplanet.ssaibrary.room.service.RoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    private static final String SUCCESS = "success";

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDTO>> findAllRoom() {
        return new ResponseEntity<List<RoomDTO>>(roomService.findAllRoom(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> findRoomById(@PathVariable Long id) {
        return new ResponseEntity<RoomDTO>(roomService.findRoomById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertRoom(@RequestBody RoomDTO roomDTO) {
        roomService.insertRoom(roomDTO);
        return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
    }

	// RoomDTO에 이미 id가 있기 때문에 /{id}를 사용하지 않아도 됩니다.
    @PutMapping
    public ResponseEntity<?> updateRoom(@RequestBody RoomDTO roomDTO) {
        roomService.updateRoom(roomDTO);
        return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
    }
}
