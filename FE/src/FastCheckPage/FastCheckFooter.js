import React from "react";
import "./FastCheckFooter.css";
import { useDispatch } from "react-redux";
import { first, second, third } from "../Store/counterFloor";
import { useNavigate } from "react-router-dom";

function Footer() {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  return (
    <>
      <div className="bottomBar">
          <div className="homeBtn" onClick={()=>navigate(-1)}>
            <div className="home"></div>
            <div className="homeTitle">Back</div>
          </div>
        <div className="reservationBtn" onClick={() => dispatch(first())}>
          <div className="reservation"></div>
          <div className="reservationTitle">1층</div>
        </div>
        <div className="communityBtn" onClick={() => dispatch(second())}>
          <div className="community"></div>
          <div className="communityTitle">2층</div>
        </div>
        <div className="accountBtn" onClick={() => dispatch(third())}>
          <div className="account"></div>
          <div className="accountTitle">3층</div>
        </div>
        <div className="bottomBarDiv"> </div>
      </div>
    </>
  );
}

export default Footer;
