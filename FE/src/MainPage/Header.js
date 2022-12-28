import React from "react";
import "./Header.css";
import { Link } from "react-router-dom";
function Header() {
  return (
    <>
      <div className="userInfo">
        <div className="profileTitle">안녕하세요, 지환님</div>

        <div className="profileTitleDesc">오늘도 행복한 하루 보내세요&nbsp;:)</div>
        <div className="profileImgDiv"></div>
        <Link to="/account">
          <div className="ProfileImg"></div>
        </Link>
      </div>
    </>
  );
}

export default Header;
