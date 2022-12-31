import React from "react";
import "./Main.css";
function LeftSeat() {
  return (
    <>
      <div className="SeatCounter">
        <div className="SeatCountDiv">
          <span id="spareSeatLabel">남은 좌석</span>
          <span id="spareSeatCnt">76</span>
          <span id="allSeatLabel">총 좌석</span>
          <span id="allSeatCnt">240</span>
          <div className="Contour"> </div>
        </div>
      </div>
    </>
  );
}

export default LeftSeat;
