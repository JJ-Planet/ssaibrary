import React from "react";
import "./AccountHeader.css";
function Header() {
  return (
    <>
      <div className="accountUserInfo">
        <div className="accoutUserInfo">
          <div className="accountProfileImgDiv"></div>
          <div >
            <img className="accountProfileImg" src = "assets/images/man.png" />
          </div>
          <div className="accountUserName">창겸 님</div>
          <div className="ranking">랭킹</div>
          <div className="userRanking">1000등</div>
          <div className="point">포인트</div>
          <div className="userPoint">32000P</div>
        </div>
      </div>
    </>
  );
}

export default Header;
