import React, { useState, useEffect } from "react";
import axios from "axios";

function Floor3() {
  const [Rooms, setRooms] = useState(null);
  const [StudyRooms, setStudyRooms] = useState(null);

  const [loading, setLoading] = useState(false);

  const fetchRooms = async () => {
    try {
      setRooms(null);
      const response = await axios.get("http://localhost:8080/room");
      setRooms(response.data);
    } catch (e) {
      console.log(e);
    }
    setLoading(false);
  };

  const fetchStudyRooms = async () => {
    try {
      setStudyRooms(null);
      const response = await axios.get("http://localhost:8080/studyroom");
      setStudyRooms(response.data);
    } catch (e) {
      console.log(e);
    }
    setLoading(false);
  };

  useEffect(() => {
    fetchRooms();
  }, []);
  useEffect(() => {
    fetchStudyRooms();
  }, []);

  console.log("Rooms:", Rooms);
  console.log("StdudyRooms:", StudyRooms);

  if (loading) return <div>로딩중..</div>;
  if (!Rooms) return null;

  function isRoomFull(a, b) {
    if (b - a <= 0) return "RoomFull";
    return "RoomUsable";
  }
  function isStudyRoomFull(a) {
    if (a.status == `W`) return "RoomFull";
    return "RoomUsable";
  }

  const RoomRendering = () => {
    const result = [];
    for (let i = 0; i < Rooms.length; i++) {
      result.push(
        <div className={`Room30${i + 1}Div`} key={Rooms[i].id}>
          <span className={`Room30${i + 1}Num`}>{Rooms[i].id}</span>
          <span className={`Room30${i + 1}Status`}>
            {Rooms[i].totalSeat - Rooms[i].reserveSeat} / {Rooms[i].totalSeat}
          </span>
          <div
            className={`Room30${i + 1}Obj ${isRoomFull(Rooms[i].reserveSeat, Rooms[i].totalSeat)}`}
          ></div>
        </div>
      );
    }
    return result;
  };

  const StudyRoomRendering = () => {
    const result = [];
    for (let i = 0; i < StudyRooms.length; i++) {
      result.push(
        <div className={`Room30${i + Rooms.length + 1}Div`} key={StudyRooms[i].id}>
          <span className={`Room30${i + Rooms.length + 1}Num`}>{StudyRooms[i].id}</span>
          <span className={`Room30${i + Rooms.length + 1}Status`}>
            {StudyRooms[i].status === "W" ? "사용 중" : "예약 가능"}
          </span>
          <div
            className={`Room30${i + Rooms.length + 1}Obj ${isStudyRoomFull(StudyRooms[i])}`}
          ></div>
        </div>
      );
    }
    return result;
  };

  return (
    <>
      <div className="RoomLocation">
        <div className="RoomSeperator"></div>
        <span className="LocationLabel">대전 캠퍼스 {Rooms[0].floor}층</span>
      </div>
      {RoomRendering()}
      {StudyRoomRendering()}
    </>
  );
}

export default Floor3;
