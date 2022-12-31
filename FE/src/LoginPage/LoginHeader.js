import React from "react";
import "./LoginHeader.css";
import { Link } from "react-router-dom";
function Header() {
  return (
    <>
      <div className="LoginHeader">
        <div className="FastCheckDiv">
          <span className="FastCheckTitle">좌석을 빠르게 조회하길 원한다면? </span>
          <Link to="/fastCheck">
            <span className="FastCheckBtn">빠른조회</span>
          </Link>
        </div>
      </div>
    </>
  );
}

export default Header;
