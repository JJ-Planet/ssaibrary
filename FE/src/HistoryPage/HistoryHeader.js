import React from "react";
import "./HistoryHeader.css";
import { Link } from "react-router-dom";
function Header() {
  return (
    <>
      <div className="TitleDiv">
        <span className="Title">이용 내역</span>
      </div>
      <div className="ReservationBtnsDiv">
        <Link to="/account/reservation">
          <div className="ReservationBtnDiv">
            <span className="ReservationBtnText">Reservation</span>
          </div>
        </Link>
        <Link to="/history">
          <div className="HistoryBtnDiv">
            <span className="HistoryBtnText">History</span>
            <div className="ShowingBar"></div>
          </div>
        </Link>
      </div>
    </>
  );
}

export default Header;
