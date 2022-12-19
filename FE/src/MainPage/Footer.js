import React from "react";
import "./Footer.css";
function Body() {
  return (
    <>
      <div className="bottomBar">
        <div className="homeBtn">
          <div className="home"></div>
          <div className="homeTitle">Home</div>
        </div>
        <div className="reservationBtn">
          <div className="reservation"></div>
          <div className="reservationTitle">Reservation</div>
        </div>
        <div className="communityBtn">
          <div className="community"></div>
          <div className="communityTitle">Community</div>
        </div>
        <div className="accountBtn">
          <div className="account"></div>
          <div className="accountTitle">Account</div>
        </div>
        <div className="bottomBarDiv"> </div>
      </div>
    </>
  );
}

export default Body;
