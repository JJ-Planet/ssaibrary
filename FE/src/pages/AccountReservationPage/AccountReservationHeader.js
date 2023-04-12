import React from "react";
import "./AccountReservationHeader.css";
import { Link } from "react-router-dom";
function Header() {
  return (
    <>
      <div className="TitleDiv">
        <span className="Title">예약 확인</span>
      </div>
      <div className="ReservationBtnsDiv">
        <Link to="/account/reservation">
          <div className="ReservationBtnDiv">
            <span className="ReservationBtnText1">Reservation</span>
            <div className="ShowingBar"></div>
          </div>
        </Link>
        <Link to="/history">
          <div className="HistoryBtnDiv">
            <span className="HistoryBtnText1">History</span>
          </div>
        </Link>
      </div>
    </>
  );
}

export default Header;
