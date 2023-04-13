import React, { useEffect, useState } from "react";
import styles from "./Floor.module.css";
import { Link } from "react-router-dom";

import { getAllStudyRoomInfo } from "../../api/studyroomAPI";
import { getAllRoomInfo } from "../../api/roomAPI";

let isFull = false;
const current = 29;
const max = 30;
if (current == max) {
  isFull = true;
}
const toDetail = (roomId) => {
  console.log("Detail Page Router", roomId);
};
const nothing = () => {
  console.log("이곳은 예약 불가 토스트가 올라올 자리입니다.");
};

// getAllStudyRoomInfo();

function Floor() {
  const [studyRooms, setStudyRooms] = useState();
  const [rooms, setRooms] = useState();
  const [isLoadingStudyRoom, setIsLoadingStudyRoom] = useState(false);
  const [isLoadingRoom, setIsLoadingRoom] = useState(false);

  useEffect(() => {
    getAllStudyRoomInfo().then((response) => {
      setStudyRooms(response);
      setIsLoadingStudyRoom(true);

    });
    getAllRoomInfo().then((response) => {
      setRooms(response);
      setIsLoadingRoom(true);
    });
  }, []);

  console.log(studyRooms);
  console.log(rooms);
  if (isLoadingStudyRoom && isLoadingRoom) {
    return (
      <>
        <div className="RoomLocation">
          <div className="RoomSeperator"></div>
          <span className="LocationLabel">대전 캠퍼스 3층</span>
        </div>
          <div
            className={styles.Room1Div}
            onClick={studyRooms[0].status == "W" ? nothing : () => toDetail(studyRooms[0].id)}
          >
            <span className={styles.Room1Num}>301</span>
            <div className={styles.BigRoomStatus}>
              {studyRooms[0].status == "W" ? "사용 중" : "예약 가능"}
            </div>
            <div
              className={
                studyRooms[0].status == "W" ? styles.Full : styles.Empty
              }
            ></div>
          </div>
        <div
          className={styles.Room2Div}
          onClick={studyRooms[1].status == "W" ? nothing : () => toDetail(studyRooms[1].id)}
        >
          <span className={styles.Room2Num}>302</span>
          <div className={styles.BigRoomStatus}>
            {studyRooms[1].status == "W" ? "사용 중" : "예약 가능"}
          </div>
          <div
            className={studyRooms[1].status == "W" ? styles.Full : styles.Empty}
          ></div>
        </div>

        <div
          className={styles.Room3Div}
          onClick={rooms[0].isAvailable == "N"  ? nothing : () => toDetail(rooms[0].id)}
        >
          <span className={styles.Room3Num}>{rooms[0].id}</span>
          <div className={styles.SmallRoomStatus}>
            {rooms[0].isAvailable == "N" ? "예약 불가" : `${rooms[0].reserveSeat} / ${rooms[0].totalSeat}`}
          </div>
          <div className={rooms[0].isAvailable == "N"  ? styles.FullSmall : styles.EmptySmall}></div>
        </div>

        <div
          className={styles.Room4Div}
          onClick={rooms[1].isAvailable == "N"  ? nothing : () => toDetail(rooms[1].id)}
        >
          <span className={styles.Room4Num}>{rooms[1].id}</span>
          <div className={styles.SmallRoomStatus}>
            {rooms[1].isAvailable == "N"  ? "예약 불가" : `${rooms[1].reserveSeat} / ${rooms[1].totalSeat}`}
          </div>
          <div className={rooms[1].isAvailable == "N"  ? styles.FullSmall : styles.EmptySmall}></div>
        </div>

        <div
          className={styles.Room5Div}
          onClick={rooms[2].isAvailable == "N"  ? nothing : () => toDetail(rooms[2].id)}
        >
          <span className={styles.Room5Num}>{rooms[2].id}</span>
          <div className={styles.SmallRoomStatus}>
            {rooms[2].isAvailable == "N"  ? "예약 불가" : `${rooms[2].reserveSeat} / ${rooms[2].totalSeat}`}
          </div>
          <div className={rooms[2].isAvailable == "N"  ? styles.FullSmall : styles.EmptySmall}></div>
        </div>
      </>
    );
  }
}

export default Floor;
