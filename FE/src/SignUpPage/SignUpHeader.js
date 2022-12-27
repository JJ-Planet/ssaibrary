import React from "react";
import "./SignUpHeader.css";
import { Link } from "react-router-dom";
function Header() {
  return (
    <>
      <div className="SignUpHeader">
        <span className="SignUpSubTitle">
          예약을 쉽게! 간편하게 ! <br></br>
          안녕하세요 SSaibrary 입니다.
        </span>
        <span className="SignUpMainTitle">만나서 반가워요!!😄</span>
        <Link to="/login">
          <span className="SignUpBackBtn">뒤로</span>
        </Link>
      </div>
    </>
  );
}

export default Header;
