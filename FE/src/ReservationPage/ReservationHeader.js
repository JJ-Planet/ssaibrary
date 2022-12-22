import React from "react";
import "./ReservationHeader.css";
function Header() {
  return (
    <>
      <div className="TitleDiv">
        <span className="Title">예약 확인</span>
      </div>
      <div className="ReservationBtnsDiv">
        <div className="ReservationBtnDiv">
          <span className="ReservationBtnText">Reservation</span>
          <div className="ShowingBar"></div>
        </div>
        <div className="HistoryBtnDiv">
          <span className="HistoryBtnText">History</span>
        </div>
      </div>
    </>
  );
}

export default Header;
