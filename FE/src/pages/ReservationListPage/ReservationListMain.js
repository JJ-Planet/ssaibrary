import React from "react";
import "./ReservationListMain.css";

// import { Link } from "react-router-dom";

import Floor3 from "../../components/Floor/Floor3";
import Floor1 from "../../components/Floor/Floor1";

function Main() {
  return (
    <>
      <div className="ReservationListMain">
        <Floor1></Floor1>
      </div>
      {/* <div className="ReservationListMain">
        <div className="RoomLocation">
          <div className="RoomSeperator"></div>
          <span className="LocationLabel">대전 캠퍼스 3층</span>
        </div>
        <div className="Room301Div">
          <span className="Room301Num">301</span>
          <span className="Room301Status">예약 가능</span>
          <div className="Room301Obj"></div>
        </div>
        <div className="Room302Div">
          <span className="Room302Num">302</span>
          <span className="Room302Status">사용 중</span>
          <div className="Room302Obj"></div>
        </div>
        <div className="Room303Div">
          <span className="Room303Num">303</span>
          <span className="Room303Status">12/24</span>
          <div className="Room303Obj"></div>
        </div>
        <div className="Room304Div">
          <span className="Room304Num">304</span>
          <span className="Room304Status">24/24</span>
          <div className="Room304Obj"></div>
        </div>
        <div className="Room305Div">
          <span className="Room305Num">305</span>
          <span className="Room305Status">15/30</span>
          <div className="Room305Obj"></div>
        </div>
      </div> */}
    </>
  );
}

export default Main;
