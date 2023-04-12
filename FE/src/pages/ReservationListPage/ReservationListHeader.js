import React from "react";
import { Link } from "react-router-dom";
import "./ReservationListHeader.css";
function Header() {
  return (
    <>
      <div className="ReservationListHeader">
        <div className="SlideBar">
          <div className="SlideBarLine1"></div>
          <div className="SlideBarLine2"></div>
        </div>
        <div className="ReservationListProfileImgDiv">
          <div>
            <img className="ReservationListProfileImg" src="assets/images/man.png"></img>
          </div>
          <div className="ReservationListProfileImgBox"></div>
        </div>
        <div className="ReservationListUserInfoDiv">
          <span className="ReservationListNickName">지환 님</span>
          <span className="ReservationListPoint">Point : 22</span>
          <span className="ReservationListRank">Rank : 1위</span>
          <Link to="/account/modify">
            <span className="ReservationListUserModifyBtn">정보 수정</span>
          </Link>
          <span className="ReservationListLogoutBtn">로그 아웃</span>
        </div>
        <div className="ReservationListUserInfoBox"></div>
      </div>
    </>
  );
}

export default Header;
