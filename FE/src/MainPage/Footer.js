import React from "react";
import "./Footer.css";
import { Link, useLocation } from "react-router-dom";

function Footer() {
  const location = useLocation();
  console.log(location);
  return (
    <>
      <div className="bottomBar">
        <Link to="/main">
          <div className="homeBtn">
            <div className="home"></div>
            <div className="homeTitle">Home</div>
          </div>
        </Link>
        <Link to="/account/reservation">
          <div className="reservationBtn">
            <div className="reservation"></div>
            <div className="reservationTitle">Reservation</div>
          </div>
        </Link>
        <Link to="/community">
          <div className="communityBtn">
            <div className="community"></div>
            <div className="communityTitle">Community</div>
          </div>
        </Link>
        <Link to="/account">
          <div className="accountBtn">
            <div className="account"></div>
            <div className="accountTitle">Account</div>
          </div>
        </Link>
        <div className="bottomBarDiv"> </div>
      </div>
    </>
  );
}

export default Footer;
