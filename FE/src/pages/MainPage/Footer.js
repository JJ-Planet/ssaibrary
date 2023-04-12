import React from "react";
import "./Footer.css";
import { Link } from "react-router-dom";

function Footer() {
  console.log("est")
  return (
    <>
      <div className="bottomBar">
        <Link to="/main">
          <div className="homeBtn">
            <div className="home"></div>
            <div>
              <img className="home" src="assets/images/home.png"/>
            </div>
            <div className="homeTitle">Home</div>
          </div>
        </Link>
        <Link to="/account/reservation">
          <div className="reservationBtn">
            <div>
              <img
                className="reservation"
                src="assets/images/schedule.png"
              ></img>
            </div>
            <div className="reservationTitle">Reservation</div>
          </div>
        </Link>
        <Link to="/community">
          <div className="communityBtn">
            <div>
              <img className="community" src="assets/images/chat.png"/>
            </div>
            <div className="communityTitle">Community</div>
          </div>
        </Link>
        <Link to="/account">
          <div className="accountBtn">
            <div>
              <img className="account" src="assets/images/user.png"/>
            </div>
            <div className="accountTitle">Account</div>
          </div>
        </Link>
        <div className="bottomBarDiv"> </div>
      </div>
    </>
  );
}

export default Footer;
