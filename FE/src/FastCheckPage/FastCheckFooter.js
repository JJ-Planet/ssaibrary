import React from "react";
import "./FastCheckFooter.css";
import { Link } from "react-router-dom";

function Footer() {
  return (
    <>
      <div className="bottomBar">
        <Link to="/login">
          <div className="homeBtn">
            <div className="home"></div>
            <div className="homeTitle">Back</div>
          </div>
        </Link>
        <Link to="/account/reservation">
          <div className="reservationBtn">
            <div className="reservation"></div>
            <div className="reservationTitle">1층</div>
          </div>
        </Link>
        <Link to="/community">
          <div className="communityBtn">
            <div className="community"></div>
            <div className="communityTitle">2층</div>
          </div>
        </Link>
        <Link to="/account">
          <div className="accountBtn">
            <div className="account"></div>
            <div className="accountTitle">3층</div>
          </div>
        </Link>
        <div className="bottomBarDiv"> </div>
      </div>
    </>
  );
}

export default Footer;
