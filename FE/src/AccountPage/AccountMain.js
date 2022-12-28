import React from "react";
import "./AccountMain.css";
import { Link } from "react-router-dom";

function Main() {
  return (
    <>
      <div className="accountMain">
        <div className="accountMainDiv1">
          <div className="accountMainSeperator"> </div>
          <div className="MainDiv1Label">내 정보</div>
          <div className="accountUpdateDiv">
            <Link to="/modify">
              <span className="accountUpdateTitle">정보 수정</span>
              <div className="accountUpdateIcon1"></div>
            </Link>
          </div>
          <div className="accountLogOutDiv">
            <div className="LogOutTitle">로그아웃</div>
            <div className="accountUpdateIcon2"></div>
          </div>
        </div>
        <div className="accountMainDiv2">
          <div className="accountMainSeperator"> </div>
          <div className="MainDiv2Label">예약 확인 및 관리</div>
          <div className="AccountReservationDiv">
            <div className="accountUpdateTitle">예약 확인</div>
            <div className="accountUpdateIcon1"></div>
          </div>
          <div className="UsageHistoryDiv">
            <div className="UsageHistoryTitle">이용 내역</div>
            <div className="accountUpdateIcon2"></div>
          </div>
        </div>
        <div className="accountMainDiv3">
          <div className="accountMainSeperator"> </div>
          <div className="MainDiv1Label">일반</div>
          <div className="accountUpdateDiv">
            <div className="accountUpdateTitle">공지사항</div>
            <div className="accountUpdateIcon1"></div>
          </div>
          <div className="accountUpdateDiv">
            <div className="accountUpdateTitle">FAQ</div>
            <div className="accountUpdateIcon2"></div>
          </div>
          <div className="accountUpdateDiv">
            <div className="accountUpdateTitle">문의하기</div>
            <div className="accountUpdateIcon3"></div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Main;
